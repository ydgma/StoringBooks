package com.ydprojects.dao;

import com.ydprojects.entity.book.BookFactory;
import com.ydprojects.entity.book.PDF;
import com.ydprojects.entity.book.UTF8;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BookImplDAOTest {
    private BookDAOImpl bookDAO= new BookDAOImpl();
    private static final Logger LOG = LoggerFactory.getLogger(BookImplDAOTest.class);

    @Test
    public void addUTF8Test() throws IOException {
        String filePath = "/Users/yasirudahanayake/IdeaProjects/StoringData/src/test/resources/33364.txt.utf-8.txt";
        UTF8 book = (UTF8) BookFactory.getBook("UTF8", filePath,"Random Book2", "project");
        boolean successfullySubmitted = bookDAO.addBook(book);
        assertTrue(successfullySubmitted);
    }

    @Test
    public void addPDFTest() {
        String filePath = "/Users/yasirudahanayake/IdeaProjects/StoringData/src/test/resources/33364.txt.utf-8.pdf";
        PDF pdf = (PDF) BookFactory.getBook("PDF", filePath,"Random Book9", "project");
        boolean successfullySubmitted = bookDAO.addBook(pdf);
        assertTrue(successfullySubmitted);
    }

    // need a way to mock the values instead of querying database

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

    @Test(expected = NullPointerException.class)
    public void deleteBook() {
        bookDAO.deleteBook(17L,PDF.class);
    }

    @Test
    public void updateBook() {
       UTF8 utf8 =  (UTF8)bookDAO.getBook(15L, UTF8.class);
       utf8.setBookName("Updated Name");
       bookDAO.updateBook(utf8);
    }

}