package com.ydprojects.modal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractBook {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractBook.class);
    protected static final String WHITE_SPACE_SPLITTER = "\\s+";

    abstract String getBookType();
    abstract String getBookFilePath();
    abstract String getBookContentsAsString();
    abstract int getWordCount();
    abstract int getSpecificWordCount(String wordToSearch);
    abstract byte [] getBookAsFile();
    abstract String bookName();

    protected int specificWordCount(String wordToSearch) {
        String [] arrayOfStrings = getBookContentsAsString().split(WHITE_SPACE_SPLITTER);
        int count = 0;
        for (String s: arrayOfStrings) {
            if(s.equalsIgnoreCase(wordToSearch)) {
                count ++;
            }
        }
        return count;
    }

    protected int wordCount() {
        return getBookContentsAsString().split(WHITE_SPACE_SPLITTER).length;
    }
}
