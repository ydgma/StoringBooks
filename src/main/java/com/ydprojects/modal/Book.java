package com.ydprojects.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @Column(name = "bookID", unique = true)
    private int id;

    @Column(name = "bookType", nullable = false)
    private String bookType;

    @Column(name = "contentAsString", nullable = false)
    private String bookContentsAsString;

    @Column(name = "wordCount", nullable = false)
    private int wordCount;

    @Column(name = "specificWordCount", nullable = false)
    private int specificWordCount;

    public Book (int id, String bookType, String bookContentsAsString, int wordCount, int specificWordCount) {
        this.id = id;
        this.bookType = bookType;
        this.bookContentsAsString = bookContentsAsString;
        this.wordCount = wordCount;
        this.specificWordCount = specificWordCount;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookContentsAsString() {
        return bookContentsAsString;
    }

    public void setBookContentsAsString(String bookContentsAsString) {
        this.bookContentsAsString = bookContentsAsString;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getSpecificWordCount() {
        return specificWordCount;
    }

    public void setSpecificWordCount(int specificWordCount) {
        this.specificWordCount = specificWordCount;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}
