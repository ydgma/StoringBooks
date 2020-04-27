package com.ydprojects.entity.book;

import java.io.Serializable;

public interface Book extends Serializable {
    String getBookContentsAsString();
    BookType getBookType();
    String getBookName();
    int getSpecificWordCount(String wordToSearch);
    int getWordCount();
    Long getId();
    byte[] getBook();
}
