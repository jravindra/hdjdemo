package com.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by rjaraja on 4/14/16.
 */
public class CAPercentile {

    public static void main(String[] args) throws IOException {
        CAPercentile percentile = new CAPercentile();
//        File file = new File("/Users/rjaraja/Downloads/12.txt");
        String[] files = {"/Users/rjaraja/GET.log", "/Users/rjaraja/POST.log", "/Users/rjaraja/PUT.log", "/Users/rjaraja/DELETE.log"};
//        String[] files = {"/Users/rjaraja/GET.log"};
//        File file = new File("/Users/rjaraja/Downloads/graylog-search-result-absolute-2016-04-18T07-00-00.000Z-2016-04-18T18-00-00.000Z.csv");
//        File file = new File("/Users/rjaraja/Downloads/graylog-search-result-absolute-2016-04-18T07-00-00.000Z-2016-04-18T18-00-00.000Z.csv");
//        File file = new File("/Users/rjaraja/Downloads/graylog-search-result-relative-1800.csv");
        for (String file : files) {
            System.out.println();
            System.out.println(file);
            System.out.println();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                String prevKey = null;
                HashMap<String, ArrayList<Double>> map = new HashMap<>();
                Double a = Double.valueOf(.95);
                while ((line = br.readLine()) != null) {
                    String[] split = line.split(",");
                    String key = split[1];
                    Double e = Double.valueOf(split[0]);
                    if (map.get(key) == null) {
                        if (prevKey != null) {
                            ArrayList<Double> prevdoubles = map.get(prevKey);
                            if (!prevdoubles.isEmpty()) {
                                Double[] array = new Double[]{};
                                array = prevdoubles.toArray(array);
                                double v = percentile.excelPercentile(array, a);
//                            System.out.println(prevKey);
                                System.out.println("\"" + prevKey + "\"" + "," + "\"" + Double.valueOf(v).intValue() + "\"" + "," + "\"" + array.length + "\"");
//                                System.out.println("" + prevKey + " - " + Double.valueOf(v).intValue());
//                            System.out.println("" + prevKey + " " + " - " + Double.valueOf(v).intValue());
                            }
                            map.clear();
                        }
                        ArrayList<Double> value = new ArrayList<>();
                        value.add(e);
                        map.put(key, value);
                    } else {
                        ArrayList<Double> doubles = map.get(key);
                        doubles.add(e);
                    }

                    prevKey = key;

                }
            }
        }

    }

    // warning - modifies data
    double excelPercentile(Double[] data, double percentile) {
        Arrays.sort(data);
        double index = percentile * (data.length - 1);
        int lower = (int) Math.floor(index);
        if (lower < 0) { // should never happen, but be defensive
            return data[0];
        }
        if (lower >= data.length - 1) { // only in 100 percentile case, but be defensive
            return data[data.length - 1];
        }
        double fraction = index - lower;
        // linear interpolation
        double result = data[lower] + fraction * (data[lower + 1] - data[lower]);
        return result;
    }
}
