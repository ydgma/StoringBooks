package com.ydprojects.DAO;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class UTF8Test {

    //TODO need to add mocking
    private static final Logger LOG = LoggerFactory.getLogger(UTF8Test.class);
    private static final String FILE_PATH = "src/test/resources/33364.txt.utf-8.txt";
    private com.ydprojects.DAO.UTF8 UTF8 = new UTF8(FILE_PATH);


    @Test
    public void getFileContentsAsStringTest() {
        boolean isEmpty = UTF8.bookContentsAsString().isEmpty();
        assertFalse(isEmpty);
    }

    @Test
    public void getWordCountTest() {
        int expected = 4448;
        int actual = UTF8.wordCount();
        assertEquals(expected,actual);
    }

    @Test
    public void getSpecificWordCount() {
        int expectedNumber = 0;
        String wordToSearch = "this word does not exist";
        int actualNumber = UTF8.specificWordCount(wordToSearch);
        assertEquals(expectedNumber,actualNumber);
    }
}
