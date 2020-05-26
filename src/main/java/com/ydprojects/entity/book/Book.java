package com.ydprojects.entity.book;

import java.io.Serializable;
import java.util.Date;

public interface Book extends Serializable {
    BookType getBookType();
    String getBookName();
    int getWordCount();
    Long getId();
    byte[] getBook();
    int getRating();
    Date getDate();
}
