package com.ydprojects.DAO;

import com.ydprojects.modal.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class BookType extends BookDAO {
    private static final Logger LOG = LoggerFactory.getLogger(BookType.class);
    protected String bookAsString;
    private static final String WHITE_SPACE_SPLITTER = "\\s+";

    abstract String getBookFilePath();

    public void convertBookContentsToString () {
        String filePath = getBookFilePath();
        try {
            bookAsString = String.join("", Files.readAllLines(Paths.get(filePath)));
        } catch (IOException e) {
            LOG.info("{}",e);
        }
    }

    public String bookContentsAsString() {
        return bookAsString;
    }

    public int wordCount() {
        return bookAsString.split(WHITE_SPACE_SPLITTER).length;
    }

    public int specificWordCount(String wordToSearch) {
        String [] arrayOfStrings = bookAsString.split(WHITE_SPACE_SPLITTER);
        int count = 0;
        for (String s: arrayOfStrings) {
            if(s.equalsIgnoreCase(wordToSearch)) {
                count ++;
            }
        }
        return count;
    }
}
