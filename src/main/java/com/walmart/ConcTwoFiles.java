package com.walmart;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rjaraja on 7/4/16.
 */
public class ConcTwoFiles {
    public static void main(String[] args) throws IOException {
        // Files to read
        File file1 = new File("/Users/rjaraja/Downloads/psswd.txt");
        File file2 = new File("/Users/rjaraja/Downloads/www.testingmom.com_20th_Jul_2016.txt");

// File to write
        File file3 = new File("/Users/rjaraja/Downloads/download.txt");

// Read the file as string
        List<String> file1lines = FileUtils.readLines(file1);
        List<String> file2ines = FileUtils.readLines(file2);

        List<String> psswds = new LinkedList<>();


        Pattern p = Pattern.compile(".*?:-{1,}(.*)");
        for (int i = 0; i < file1lines.size(); i++) {

            String line = file1lines.get(i);
            line = line.replaceAll(" ", "-");
            file1lines.set(i, line + ".pdf");

            Matcher m = p.matcher(line);

            if (m.find()) {
                System.out.println(m.group(1));
                psswds.add(m.group(1));
            }
        }

        List<String> finalLines = new LinkedList<>();
        for (int i = 0; i < file1lines.size(); i++) {
            finalLines.add(file2ines.get(i) + "|" + file1lines.get(i) + "|" + psswds.get(i));
        }

// Write the file
        FileUtils.writeLines(file3, finalLines);
//        FileUtils.write(file3, file2Str, true); // true for append
    }
}
