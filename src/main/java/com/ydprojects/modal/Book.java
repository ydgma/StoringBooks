package com.ydprojects.modal;

import java.io.Serializable;

public interface Book extends Serializable {
    String getBookContentsAsString();
    String getBookType();
    String getBookName();
    int getSpecificWordCount(String wordToSearch);
    int getWordCount();
    Long getId();
    byte[] getBook();
}
