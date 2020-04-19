package com.ydprojects.util;

import javassist.bytecode.ByteArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BookConverterUtil {
    private static final Logger LOG = LoggerFactory.getLogger(BookConverterUtil.class);
    protected static final String WHITE_SPACE_SPLITTER = "\\s+";

    public static byte[] convertFileToByteArray(String filePath){
            File inputFile = new File(filePath);
            byte[] fileBytes = new byte[(int) inputFile.length()];
        try {
            FileInputStream inputStream = new FileInputStream(inputFile);
            inputStream.read(fileBytes);
            inputStream.close();
        } catch (IOException e) {
           LOG.info("{}",e);
        }
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

    public static String convertByteArrayToFile(Byte[] fileInArrayFormat) {

        return null;
    }
}
