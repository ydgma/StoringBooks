package com.ydprojects.entity.book;

import com.ydprojects.util.BookConverterUtil;

import javax.persistence.*;

@MappedSuperclass
public abstract class BookImpl implements Book {

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

    public BookImpl(String filePath, BookType bookType, String bookContentsAsString, int wordCount, byte[] bookAsFile, String bookName) {
        this.filePath = filePath;
        this.bookType = bookType;
        this.bookContentsAsString = bookContentsAsString;
        this.wordCount = wordCount;
        this.bookName = bookName;
        this.bookAsFile = bookAsFile;
    }

    public BookImpl(String bookName, String filePath, BookType bookType) {
        this.bookName = bookName;
        this.filePath = filePath;
        this.bookType = bookType;
        setBookContentAsString();
        setWordCount();
        setBookAsFile();
    }

    protected BookImpl(){}

    protected abstract String convertBookToString();

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

    public int getSpecificWordCount(String specificWordToSearch) {
        return BookConverterUtil.specificWordCount(specificWordToSearch, bookContentsAsString);
    }

    @Override
    public BookType getBookType() {
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
