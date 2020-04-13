package com.ydprojects.DAO;

import com.ydprojects.modal.PDF;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PDFTest {
    private String FILE_PATH = "src/test/resources/33364.txt.utf-8.pdf";
    private PDF pdf = new PDF(FILE_PATH,"Random Book");

   /* @Test
    public void getFileContentsAsStringTest() {
        boolean isEmpty = pdf.getBookContentsAsString().isEmpty();
        assertFalse(isEmpty);
    }*/

  /*  @Test
    public void getWordCountTest() {
        int expected = 4950;
        int actual = pdf.wordCount();
        assertEquals(expected,actual);
    }

    @Test
    public void getSpecificWordCount() {
        int expectedNumber = 0;
        String wordToSearch = "word that doesn't exist";
        int actualNumber = pdf.specificWordCount(wordToSearch);
        assertEquals(expectedNumber,actualNumber);
    }*/
}
