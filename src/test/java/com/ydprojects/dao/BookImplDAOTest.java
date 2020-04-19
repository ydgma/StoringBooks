package com.ydprojects.dao;

import com.ydprojects.modal.BookFactory;
import com.ydprojects.modal.BookImpl;
import com.ydprojects.modal.PDF;
import com.ydprojects.modal.UTF8;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BookImplDAOTest {
    private BookDAO bookDAO= new BookDAO();
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
        PDF bookImpl = bookDAO.getBook(16L, PDF.class);
        assertNotNull(bookImpl);
    }

    @Test
    public void getUTF8Test() {
        UTF8 bookImpl = bookDAO.getBook(15L, UTF8.class);
        assertNotNull(bookImpl);
    }

    @Test(expected = NullPointerException.class)
    public void deleteBook() {
        bookDAO.deleteBook(17L,PDF.class);
    }

}