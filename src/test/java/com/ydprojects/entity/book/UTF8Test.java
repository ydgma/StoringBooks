
package com.ydprojects.entity.book;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class UTF8Test {
    private static final Logger LOG = LoggerFactory.getLogger(UTF8Test.class);
    private static final String FILE_PATH = "src/test/resources/33364.txt.utf-8.txt";
    private static final String BOOK_NAME = "test Book";
    private static final String SPECIFIC_WORD_TO_SEARCH = "project";
    private com.ydprojects.entity.book.UTF8 UTF8 = new UTF8(BOOK_NAME,FILE_PATH);

    @Test
    public void getFileContentsAsStringTest() {
        boolean isEmpty = UTF8.getBookContentsAsString().isEmpty();
        assertFalse(isEmpty);
    }

    @Test
    public void getWordCountTest() {
        int expected = 4448;
        int actual = UTF8.getWordCount();
        assertEquals(expected,actual);
    }

    @Test
    public void getSpecificWordCount() {
        int expectedNumber = 0;
        String wordToSearch = "this word does not exist";
        int actualNumber = UTF8.getSpecificWordCount(wordToSearch);
        assertEquals(expectedNumber,actualNumber);
    }
}

