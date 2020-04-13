package com.ydprojects.modal;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookImpl implements Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "bookType", nullable = false)
    private String bookType;

    @Column(name = "contentAsString", nullable = false)
    private String bookContentsAsString;

    @Column(name = "wordCount", nullable = false)
    private int wordCount;

    @Column(name = "specificWordCount", nullable = false)
    private int specificWordCount;

    @Column(name = "bookAsFile", columnDefinition = "BLOB")
    byte[] bookAsFile;

    @Column(name = "bookName", nullable = false)
    private String bookName;

    public BookImpl(String bookType, String bookContentsAsString, int wordCount, int specificWordCount, byte[] bookAsFile, String bookName) {
        this.bookType = bookType;
        this.bookContentsAsString = bookContentsAsString;
        this.wordCount = wordCount;
        this.specificWordCount = specificWordCount;
        this.bookName = bookName;
        this.bookAsFile = bookAsFile;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public void setSpecificWordCount(int specificWordCount) {
        this.specificWordCount = specificWordCount;
    }

    public void setBookContentsAsString(String bookContentsAsString) {
        this.bookContentsAsString = bookContentsAsString;
    }

    @Override
    public byte[] getBook() {
        return bookAsFile;
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
    public Long getId() {
        return id;
    }

    @Override
    public int getSpecificWordCount(String specificWordToSearch) {
        return specificWordCount;
    }

    @Override
    public String getBookType() {
        return bookType;
    }

    @Override
    public String getBookName(String nameOfTheBook) {
        return bookName;
    }
}
