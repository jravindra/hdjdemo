package com.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rjaraja on 3/27/17.
 */
public class DownloadFile {

    private List<String> cookies;
    private HttpsURLConnection conn;

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {
        login();
    }

    private void downloadFile() throws IOException {
        URL website = new URL("https://members.testingmom.com/test-prep/document/5302");
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("information.html");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }

    public static void login() throws Exception {
        String url = "https://www.testingmom.com/login/";
        String gmail = "https://members.testingmom.com/test-prep/document/5302";


        DownloadFile http = new DownloadFile();

        // make sure cookies is turn on
        CookieHandler.setDefault(new CookieManager());

        // 1. Send a "GET" request, so that you can extract the form's data.
        String page = http.GetPageContent(url);
        String postParams = http.getFormParams(page, "to.ravindra@gmail.com", "austin316");

        // 2. Construct above post's content and then send a POST request for
        // authentication
        http.sendPostJSoup(url, postParams);

        // 3. success then go to gmail.
        String result = http.GetPageContent(gmail);
        System.out.println(result);
    }

    private void sendPostJSoup(String url, String postParams) throws Exception {
        Connection.Response res = Jsoup
                .connect(url).header("Connection","keep-alive")
                .header("Cache-Control","max-age=0")
                .header("Origin","https://www.testingmom.com")
                .header("Upgrade-Insecure-Requests","1")
                .header("User-Agent","Mozilla/5.0 (Macintosh Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
                .header("Content-Type","application/x-www-form-urlencoded")
                .header("Accept","text/html,application/xhtml+xml,application/xmlq=0.9,image/webp,*/*q=0.8")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Accept-Language","en-US,enq=0.8")
                .header("Referer", "https://www.testingmom.com/login/")
                .data("tm-action", "tm-login", "log", "to.ravindra@gmail.com", "pwd", "austin316")
                .method(Connection.Method.POST)
                .execute();

        int i = res.statusCode();
        Map<String, String> cookies = res.cookies();
        System.out.println(cookies);
    }

    private void sendPost(String url, String postParams) throws Exception {

        URL obj = new URL(url);
        conn = (HttpsURLConnection) obj.openConnection();

        // Acts like a browser
        conn.setUseCaches(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Connection","keep-alive");
        conn.setRequestProperty("Cache-Control","max-age=0");
        conn.setRequestProperty("Origin","https://www.testingmom.com");
        conn.setRequestProperty("Upgrade-Insecure-Requests","1");
        conn.setRequestProperty("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        conn.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        conn.setRequestProperty("Accept-Encoding","gzip, deflate, br");
        conn.setRequestProperty("Accept-Language","en-US,en;q=0.8");
        conn.setRequestProperty("Referer", "https://www.testingmom.com/login/");

        for (String cookie : this.cookies) {
            conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
        }
        conn.setRequestProperty("Content-Length", Integer.toString(postParams.length()));

        conn.setDoOutput(true);
        conn.setDoInput(true);

        // Send post request
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(postParams);
        wr.flush();
        wr.close();

        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + postParams);
        System.out.println("Response Code : " + responseCode);


        BufferedReader in =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
         System.out.println(response.toString());

    }

    private String GetPageContent(String url) throws Exception {

        URL obj = new URL(url);
        conn = (HttpsURLConnection) obj.openConnection();

        // default is GET
        conn.setRequestMethod("GET");

        conn.setUseCaches(false);

        // act like a browser
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setRequestProperty("Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        if (cookies != null) {
            for (String cookie : this.cookies) {
                conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
            }
        }
        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Get the response cookies
        setCookies(conn.getHeaderFields().get("Set-Cookie"));

        return response.toString();

    }

    public String getFormParams(String html, String username, String password)
            throws UnsupportedEncodingException {

        System.out.println("Extracting form's data...");

        Document doc = Jsoup.parse(html);

        Elements form = doc.select("form");
        Element loginform = form.get(1);

//        // Google form id
//        Element loginform = doc.getElementById("gaia_loginform");
        Elements inputElements = loginform.getElementsByTag("input");
        List<String> paramList = new ArrayList<String>();
        for (Element inputElement : inputElements) {
            String key = inputElement.attr("name");
            String value = inputElement.attr("value");

            if (key.equals("log"))
                value = username;
            else if (key.equals("pwd"))
                value = password;
            if (key != null && !key.equalsIgnoreCase("")) {
                paramList.add(key + "=" + URLEncoder.encode(value, "UTF-8"));
            }
            System.out.println(paramList);
        }

        // build parameters list
        StringBuilder result = new StringBuilder();
        for (String param : paramList) {
            if (result.length() == 0) {
                result.append(param);
            } else {
                result.append("&" + param);
            }
        }
        return result.toString();
    }

    public List<String> getCookies() {
        return cookies;
    }

    public void setCookies(List<String> cookies) {
        this.cookies = cookies;
    }
}
