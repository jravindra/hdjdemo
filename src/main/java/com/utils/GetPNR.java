package com.utils;

/**
 * Created by rjaraja on 8/14/16.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetPNR {
    public static void main(String[] pnrStrings) {
        final String[] pnrStrings1 = {
                "2	 	0337484080	1150625841	TPTY	SBC	24-5-2011	Delivered	03-5-2011",
                "3	 	0337484027	1416126812	TPTY	SBC	24-5-2011	Delivered	03-5-2011",
                "5	 	0335700916	4541053339	KJM	TPTY	22-5-2011	Delivered	27-4-2011",
                "6	 	0335707986	4328613364	KJM	TPTY	22-5-2011	Delivered	27-4-2011",
                "7	 	0337484740	4541206519	SBC	TPTY	22-5-2011	Delivered	03-5-2011",
                "10	 	0337484331	4541206409	MAS	SBC	20-5-2011	Delivered	03-5-2011",
                "11	 	0337484814	4541206481	MAS	SBC	20-5-2011	Delivered	03-5-2011"};

        try {
            for (String pnrString : pnrStrings1) {
                Matcher pnrMatcher = getGroup(pnrString);
                if (pnrMatcher != null) {
                    System.out.println("Train - " + pnrMatcher.group(3) + " - "
                            + pnrMatcher.group(4));
//					System.out.println(pnrMatcher.group(1) + " " + pnrMatcher.group(2));
                    // lccp_pnrno1=115&lccp_pnrno2=0625841&submitpnr=Get+Status
                    String data = URLEncoder.encode("lccp_pnrno1", "UTF-8")
                            + "="
                            + URLEncoder.encode(pnrMatcher.group(1), "UTF-8");
                    data += "&" + URLEncoder.encode("lccp_pnrno2", "UTF-8")
                            + "="
                            + URLEncoder.encode(pnrMatcher.group(2), "UTF-8");
                    data += "&" + URLEncoder.encode("submitpnr", "UTF-8") + "="
                            + URLEncoder.encode("Get Status", "UTF-8");

                    // Send data
                    URL url = new URL(
                            "http://www.indianrail.gov.in/cgi_bin/inet_pnrstat_cgi.cgi");
                    URLConnection conn = url.openConnection();
                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn
                            .getOutputStream());
                    wr.write(data);
                    wr.flush();

                    // Get the response
                    BufferedReader rd = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));
                    String line;
                    while ((line = rd.readLine()) != null) {
                        Pattern pattern = Pattern.compile("<B>(P.*)</B>");
                        Matcher matcher = pattern.matcher(line);
                        if (matcher.find()) {
                            System.out.println(matcher.group(1));
                            for (int i = 0; i < 2; i++) {
                                line = rd.readLine();
                                displayPnr(line);
                            }
                        }
                        //System.out.println(line);// Process lin/e...
                    }
                    wr.close();
                    rd.close();
                }
                System.out.println();
                System.out.println();
            }
        } catch (Exception e) {
        }

    }

    private static Matcher getGroup(String pnrString) {
        Pattern pattern = Pattern
                .compile("\\d\\s+\\d+\\s+(\\d{3}+)(\\d{7}+)\\s+(\\w+)\\s+(\\w+)");
        Matcher matcher = pattern.matcher(pnrString);
        if (matcher.find()) {
            return matcher;
        }
        return null;
    }

    public static void displayPnr(String line) {
        //

        Pattern pattern = Pattern.compile("<B>(.*)</B>");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }

    }
}
