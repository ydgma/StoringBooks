package com.ydprojects.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BookConverterUtil {
    protected static final String WHITE_SPACE_SPLITTER = "\\s+";

    public static byte[] convertBookToFile(String filePath) throws IOException {
            File inputFile = new File(filePath);
            FileInputStream inputStream = new FileInputStream(inputFile);

            byte[] fileBytes = new byte[(int) inputFile.length()];
            inputStream.read(fileBytes);
            inputStream.close();
            return fileBytes;
    }

    public static int specificWordCount(String wordToSearch, String contentAsString) {
        String [] arrayOfStrings = contentAsString.split(WHITE_SPACE_SPLITTER);
        int count = 0;
        for (String s: arrayOfStrings) {
            if(s.equalsIgnoreCase(wordToSearch)) {
                count ++;
            }
        }
        return count;
    }

    public static int wordCount(String contentAsString) {
        return contentAsString.split(WHITE_SPACE_SPLITTER).length;
    }
}
