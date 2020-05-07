package com.ydprojects.entity.book;

import com.ydprojects.util.BookConverterUtil;

import javax.persistence.*;

@MappedSuperclass
public class BookImpl implements Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "bookType", nullable = false)
    private BookType bookType;

    @Transient
    private String bookContentsAsString;

    @Column(name = "wordCount", nullable = false)
    private int wordCount;

    @Transient
    private int specificWordCount;

    @Column(name = "bookAsFile", columnDefinition = "BLOB")
    byte[] bookAsFile;

    @Column(name = "bookName", nullable = false)
    private String bookName;

    @Transient
    private String filePath;

    public BookImpl(){}

    public void setBookType(BookType bookType) {
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

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setBook(byte[] bookAsByteArray) {
        this.bookAsFile = bookAsByteArray;
    }

    public int getSpecificWordCount() {
        return specificWordCount;
    }

    public String getFilePath() {
        return filePath;
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
    public BookType getBookType() {
        return bookType;
    }

    @Override
    public String getBookName() {
        return bookName;
    }
}
