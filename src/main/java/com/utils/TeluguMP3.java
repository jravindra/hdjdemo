package com.utils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rjaraja on 12/31/16.
 */
public class TeluguMP3 {
    public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException {
//        String directoryURL = "http://telugump3downloads.net/music/index.php?dir=";
//        String directory = "NTR%20HITS";
//        String loadURL = "http://telugump3downloads.net/music/load/";
//        String dirPattern = "dir=NTR\\ HITS\\/(.*?)&";
//        String filePattern = "file=load\\/NTR HITS\\/(.*?)\\/(.*?)&";

//        getAllMP3URLs(directoryURL, directory, loadURL, dirPattern, filePattern);

//        http://telugump3downloads.net/music/index.php?dir=2016%20telugu%20mp3/Dhruva+%282016%29+MP3&p=1&page=1&sort=0

        String directoryURL = "http://telugump3downloads.net/music/index.php?dir=";
        String directory = "2016%20telugu%20mp3";
        String loadURL = "http://telugump3downloads.net/music/load/";
        String dirPattern = "dir=2016 telugu mp3\\/(.*?)&";
        String filePattern = "file=load\\/2016 telugu mp3\\/(.*?)\\/(.*?)&";


        List<String> albumList = new LinkedList<>();
        albumList.add("Dhruva (2016) MP3");

        String page = "&p=1&page=1&sort=0";
        getMP3URL(directoryURL, directory, loadURL, filePattern, page, albumList);
    }

    private static void getAllMP3URLs(String directoryURL, String directory, String loadURL, String dirPattern, String filePattern) throws UnsupportedEncodingException {
        for (int i = 3; i < 23; i++) {

            String page = "&p=1&page=" + i + "&sort=0";
            String albumHTML = getHTML(directoryURL + directory + page);
            List<String> albumList = getMatches(dirPattern, albumHTML, 1);

            getMP3URL(directoryURL, directory, loadURL, filePattern, page, albumList);
        }
    }

    private static void getMP3URL(String directoryURL, String directory, String loadURL, String filePattern, String page, List<String> albumList) throws UnsupportedEncodingException {
        String siteURL = directoryURL + directory + "/";
        for (String album : albumList) {
            String songUrl = siteURL + URLEncoder.encode(album, "UTF-8") + page;
            String songHTML = getHTML(songUrl);
            List<String> songList = getMatches(filePattern, songHTML, 2);
            String songSiteURL = loadURL + directory + "/";
            for (String song : songList) {
                String songURL = songSiteURL + album + "/" + song;
                System.out.println(songURL);
            }
        }
    }

    private static String getHTML(String urlText) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;

        try {
            url = new URL(urlText);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            StringBuffer stringBuffer = new StringBuffer();
            while ((line = br.readLine()) != null) {
                stringBuffer.append(line).append("\n");
                //System.out.println(line);
            }

            String html = stringBuffer.toString();
//            System.out.println(html);

            return html;

            //getMatches(html);

        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
        return null;
    }

    private static List<String> getMatches(String patternText, String source, int groupNumber) {
        Pattern pattern = Pattern.compile(patternText);
        Matcher matcher = pattern.matcher(source);
        matcher.matches();
        int matchCount = matcher.groupCount();
        List<String> list = new LinkedList<>();

        while (matcher.find()) {
            list.add(matcher.group(groupNumber));
//            System.out.println("-- group:"+matcher.group(1));
        }
        return list;
    }
}
