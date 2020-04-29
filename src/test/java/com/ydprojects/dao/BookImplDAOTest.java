package com.ydprojects.dao;

import com.ydprojects.entity.book.BookFactory;
import com.ydprojects.entity.book.BookType;
import com.ydprojects.entity.book.PDF;
import com.ydprojects.entity.book.UTF8;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BookImplDAOTest {
    private BookDAOImpl bookDAO= new BookDAOImpl();
    private static final Logger LOG = LoggerFactory.getLogger(BookImplDAOTest.class);
    private static final String UTF8_FILE_PATH = "/Users/yasirudahanayake/IdeaProjects/StoringData/src/test/resources/33364.txt.utf-8.txt";
    private static final String PDF_FILE_PATH  = "/Users/yasirudahanayake/IdeaProjects/StoringData/src/test/resources/33364.txt.utf-8.pdf";

    // need a way to mock the values instead of querying database
    // or clean up values after running each test

    @Test
    public void addUTF8Test() throws IOException {
        UTF8 book = (UTF8) BookFactory.getBook(BookType.UTF8, UTF8_FILE_PATH,"Random Book2");
        boolean successfullySubmitted = bookDAO.addBook(book);
        assertTrue(successfullySubmitted);
    }

    @Test
    public void addPDFTest() {
        PDF pdf = (PDF) BookFactory.getBook(BookType.PDF, PDF_FILE_PATH,"Random Book10");
        boolean successfullySubmitted = bookDAO.addBook(pdf);
        assertTrue(successfullySubmitted);
    }


    @Test
    public void getPDFTest() {
        PDF bookImpl = (PDF)bookDAO.getBook(16L, PDF.class);
        assertNotNull(bookImpl);
    }

    @Test
    public void getUTF8Test() {
        UTF8 bookImpl = (UTF8)bookDAO.getBook(15L, UTF8.class);
        assertNotNull(bookImpl);
    }

    @Test
    public void getBookByNameTest() {
       List<PDF> bookList =  bookDAO.getBookByName("Random Book2", PDF.class);
       assertTrue(bookList.size()>1);
    }

    @Test(expected = NullPointerException.class)
    public void deleteBookByNameTest() {
        PDF pdf = (PDF) BookFactory.getBook(BookType.PDF, PDF_FILE_PATH,"Delete Book");
        boolean successfullySubmitted = bookDAO.addBook(pdf);
        bookDAO.deleteBook(pdf.getId(),PDF.class);
        bookDAO.getBook(pdf.getId(), PDF.class);
    }

    @Test(expected = NullPointerException.class)
    public void deleteBookTest() {
        bookDAO.deleteBook(17L,PDF.class);
    }

    @Test
    public void updateBookTest() {
       UTF8 utf8 =  (UTF8)bookDAO.getBook(15L, UTF8.class);
       utf8.setBookName("Updated Name");
       bookDAO.updateBook(utf8);
    }

}