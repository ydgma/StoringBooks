package com.ydprojects.modal;

import com.ydprojects.modal.PDF;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PDFTest {
    private String FILE_PATH = "src/test/resources/33364.txt.utf-8.pdf";
    private static final String BOOK_NAME = "RANDOM BOOK";
    private static final String SPECIFIC_WORD_TO_SEARCH = "project";
    private PDF pdf = new PDF(BOOK_NAME, FILE_PATH, SPECIFIC_WORD_TO_SEARCH);

    @Test
    public void getFileContentsAsStringTest() {
        boolean isEmpty = pdf.getBookContentsAsString().isEmpty();
        assertFalse(isEmpty);
    }

   @Test
    public void getWordCountTest() {
        int expected = 4950;
        int actual = pdf.getWordCount();
        assertEquals(expected,actual);
    }

    @Test
    public void getSpecificWordCount() {
        int expectedNumber = 0;
        String wordToSearch = "word that doesn't exist";
        int actualNumber = pdf.getSpecificWordCount(wordToSearch);
        assertEquals(expectedNumber,actualNumber);
    }
}
