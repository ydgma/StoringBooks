package com.ydprojects.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BookConverterUtil {

    public static byte[] convertBookToFile(String filePath) throws IOException {
            File inputFile = new File(filePath);
            FileInputStream inputStream = new FileInputStream(inputFile);

            byte[] fileBytes = new byte[(int) inputFile.length()];
            inputStream.read(fileBytes);
            inputStream.close();
            return fileBytes;
    }
}
