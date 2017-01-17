package com.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by rjaraja on 7/18/16.
 */
public class GetResponse {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static void main(String[] args) throws IOException, JSONException {
        String[] boardUrls = new String[]{
                "http://100.65.4.65:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.65.4.72:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.116.137.169:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.116.137.173:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.65.4.64:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.9.218.214:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.65.8.161:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.9.218.109:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.65.8.162:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.65.8.148:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.65.4.7:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.9.218.199:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.65.4.57:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.65.4.66:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.117.10.35:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.116.138.190:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.116.137.170:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.116.137.168:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.116.137.171:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.116.141.102:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.116.141.101:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.116.137.175:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.116.141.98:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.116.137.174:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.116.141.99:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.9.249.60:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.116.141.104:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.65.4.73:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.64.7.160:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.64.7.213:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.64.7.172:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.64.7.162:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.64.7.19:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.117.10.34:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.117.10.36:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.64.7.179:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.117.10.29:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.117.10.32:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.117.10.30:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.117.10.33:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.64.7.163:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.65.8.150:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.9.218.212:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.117.13.48:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.117.13.46:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.117.13.45:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.9.222.218:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.9.218.195:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.117.13.49:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.9.216.90:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.117.13.50:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.117.13.44:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.9.218.150:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.117.13.51:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.117.13.47:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.116.141.100:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.65.8.149:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.65.8.151:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.116.141.97:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.65.8.160:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.65.8.15:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://10.9.212.8:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.64.7.203:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA",
                "http://100.65.4.56:8080/rest/GetCityStateProvince/results.json?Data.PostalCode=794231100&Option.Database.US=UAM_USA"

        };

        for (String boardUrl : boardUrls) {

            try {
                JSONObject json = readJsonFromUrl(boardUrl);
                System.out.println("url - " + boardUrl + " - json " + json);
            } catch (Exception e) {
                System.out.println(boardUrl);
            }

        }
    }
}
