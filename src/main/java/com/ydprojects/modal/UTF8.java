package com.ydprojects.modal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UTF8 extends AbstractBook {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractBook.class);
    private String bookContentsAsString;
    private int wordCount;
    private int specificWordCount;
    private byte [] bookAsFile;
    private String bookName;
    private String filePath;

    public UTF8(String filePath, String bookName) {
        this.filePath = filePath;
        this.bookContentsAsString = convertBookContentsToString();
        this.wordCount = super.wordCount();
        this.bookName = bookName;
        this.filePath = filePath;
    }

    private String convertBookContentsToString () {
        String filePath = getBookFilePath();
        try {
            bookContentsAsString = String.join("", Files.readAllLines(Paths.get(filePath)));
        } catch (IOException e) {
            LOG.info("{}",e);
        }
        return "failed to convert book to String";
    }

    @Override
    public String getBookContentsAsString() {
        return bookContentsAsString;
    }

    @Override
    public int getWordCount() {
        return wordCount;
    }

    @Override
    public int getSpecificWordCount(String wordToSearch) {
        this.specificWordCount = super.specificWordCount(wordToSearch);
        return specificWordCount;
    }

    @Override
    public byte[] getBookAsFile() {
        return bookAsFile;
    }

    @Override
    public String bookName() {
        return bookName;
    }

    @Override
    public String getBookType() {
        return "UTF8";
    }

    @Override
    public String getBookFilePath() {
        return filePath;
    }
}
