package com.ydprojects.entity.book;

import com.ydprojects.util.BookConverterUtil;

import javax.persistence.*;

@MappedSuperclass
public abstract class BookImpl implements Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookID")
    private Long id;

    @Column(name = "bookType", nullable = false)
    private String bookType;

    @Transient
    private String bookContentsAsString;

    @Column(name = "wordCount", nullable = false)
    private int wordCount;

    @Column(name = "specificWordCount", nullable = false)
    private int specificWordCount;

    @Column(name = "bookAsFile", columnDefinition = "BLOB")
    byte[] bookAsFile;

    @Column(name = "bookName", nullable = false)
    private String bookName;

    @Transient
    private String filePath;

    public BookImpl(String filePath, String bookType, String bookContentsAsString, int wordCount, int specificWordCount, byte[] bookAsFile, String bookName) {
        this.filePath = filePath;
        this.bookType = bookType;
        this.bookContentsAsString = bookContentsAsString;
        this.wordCount = wordCount;
        this.specificWordCount = specificWordCount;
        this.bookName = bookName;
        this.bookAsFile = bookAsFile;
    }

    public BookImpl(String bookName, String filePath, String bookType, String wordToSearch) {
        this.bookName = bookName;
        this.filePath = filePath;
        this.bookType = bookType;
        setBookContentAsString();
        setWordCount();
        setSpecificWordCount(wordToSearch);
        setBookAsFile();
    }

    protected BookImpl(){}

    protected abstract String convertBookToString();

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

    private void setBookContentAsString() {
        this.bookContentsAsString = convertBookToString();
    }

    private void setSpecificWordCount(String wordToSearch) {
        this.specificWordCount = BookConverterUtil.specificWordCount(wordToSearch, bookContentsAsString);
    }

    private void setWordCount() {
        this.wordCount = BookConverterUtil.wordCount(bookContentsAsString);
    }

    private void setBookAsFile() {
        this.bookAsFile = BookConverterUtil.convertFileToByteArray(filePath);
    }

    public int getSpecificWordCount() {
        return specificWordCount;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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
        return BookConverterUtil.specificWordCount(specificWordToSearch, bookContentsAsString);
    }

    @Override
    public String getBookType() {
        return bookType;
    }

    @Override
    public String getBookName() {
        return bookName;
    }

    public String getFilePath() {
        return filePath;
    }
}
