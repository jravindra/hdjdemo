package com.utils;

import com.utils.dto.oneops.OneOpsEntity;
import org.apache.htrace.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rjaraja on 7/18/16.
 */
public class OneOps {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String urlString) throws IOException, JSONException {

        URL url = new URL(urlString);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("Authorization", "Basic " + "b0dxcGFra2pnTnVwdVBoRVFtZnA6");
        urlConnection.setRequestProperty("Content-Type", "application/json");
        urlConnection.setRequestProperty("Accept", "application/json");

        InputStream is = urlConnection.getInputStream();

        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            StringBuffer sb = new StringBuffer();
            jsonText = sb.append("{ \"a\": ").append(jsonText).append("}").toString();
            ObjectMapper mapper = new ObjectMapper();
            OneOpsEntity oneOpsEntity = mapper.readValue(jsonText, OneOpsEntity.class);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static JSONObject readWithHeadersJsonFromUrl(String url) throws IOException, JSONException {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();


        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Authorization", "Basic " + "b0dxcGFra2pnTnVwdVBoRVFtZnA6");
        httpGet.setHeader("Content-Type", "application/json");
        httpGet.setHeader("Accept", "application/json");

        HttpResponse response = defaultHttpClient.execute(httpGet);

        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String jsonText = EntityUtils.toString(entity);

            getDCIP(jsonText);


//            JSONObject json = new JSONObject(jsonText);
            return null;
        }

//        "public_ip":"(.*?)"

        return null;
    }

    private static void getDCIP(String jsonText) {
        Map<String, List<String>> groupTwoMatches = getGroupTwoMatches("\"public_ip\":\"(.*?)\".*?\"ciName\":\"(.*?)\"", jsonText, 1);
        for (Map.Entry<String, List<String>> entry : groupTwoMatches.entrySet()) {

            System.out.println(entry.getKey() + " - ");
            for (String value : entry.getValue()) {
                System.out.println(value);
            }
        }
    }

    private static void getIP() {
        //            Map<String, List<String>> groupTwoMatches = getGroupTwoMatches("\"public_ip\":\"(.*?)\"", jsonText, 1);
//            List<String> matches = getMatches("\"public_ip\":\"(.*?)\"", jsonText, 1);
//            for (String match : matches) {
//
//                System.out.println(match);
//            }
    }

    public static void main(String[] args) throws IOException, JSONException {
        String[] boardUrls = new String[]{
                "https://oneops.prod.walmart.com/services/assemblies/ca-services/operations/environments/prod3/platforms/ca/components/compute/instances?instances_state=all"

        };

        for (String boardUrl : boardUrls) {

            try {
//                JSONObject json = readWithHeadersJsonFromUrl(boardUrl);

                JSONObject json = readJsonFromUrl(boardUrl);
                System.out.println("url - " + boardUrl + " - json " + json);
            } catch (Exception e) {
                System.out.println(boardUrl);
            }

        }
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

    private static Map<String, List<String>> getGroupTwoMatches(String patternText, String source, int groupNumber) {
        Pattern pattern = Pattern.compile(patternText);
        Matcher matcher = pattern.matcher(source);
        matcher.matches();
        int matchCount = matcher.groupCount();
        Map<String, List<String>> list = new HashMap<>();

        while (matcher.find()) {
            String value = matcher.group(groupNumber);
            String key = matcher.group(groupNumber + 1);
            List<String> values = list.get(key);
            if (values == null) {
                values = new LinkedList<>();
                list.put(key, values);
            }
            values.add(value);
            list.put(key, values);
//            System.out.println("-- group:"+matcher.group(1));
        }
        return list;
    }
}
