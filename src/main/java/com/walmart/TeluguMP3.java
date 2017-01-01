package com.walmart;

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
        for (int i = 3; i < 23; i++) {
            String page = "&p=1&page=" + i + "&sort=0";
            String albumHTML = getHTML("http://telugump3downloads.net/music/index.php?dir=NTR%20HITS" + page);
            List<String> albumList = getMatches("dir=NTR\\ HITS\\/(.*?)&", albumHTML, 1);

            String siteURL = "http://telugump3downloads.net/music/index.php?dir=NTR%20HITS/";
            for (String album : albumList) {
                String songUrl = siteURL + URLEncoder.encode(album, "UTF-8") + page;
//            System.out.println(songUrl);
                String songHTML = getHTML(songUrl);
                List<String> songList = getMatches("file=load\\/NTR HITS\\/(.*?)\\/(.*?)&", songHTML, 2);
                String songSiteURL = "http://telugump3downloads.net/music/load/NTR%20HITS/";
                for (String song : songList) {
                    String songURL = songSiteURL + album + "/" + song;
                    System.out.println(songURL);
                }
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
