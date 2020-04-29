package com.ydprojects.dao;

import com.ydprojects.entity.book.BookFactory;
import com.ydprojects.entity.book.BookType;
import com.ydprojects.entity.book.PDF;
import com.ydprojects.entity.book.UTF8;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BookImplDAOTest {
    private static BookDAOImpl bookDAO= new BookDAOImpl();
    private static final Logger LOG = LoggerFactory.getLogger(BookImplDAOTest.class);
    private static final String UTF8_FILE_PATH = "/Users/yasirudahanayake/IdeaProjects/StoringData/src/test/resources/33364.txt.utf-8.txt";
    private static final String PDF_FILE_PATH  = "/Users/yasirudahanayake/IdeaProjects/StoringData/src/test/resources/33364.txt.utf-8.pdf";
    private static UTF8 unitTestBook1;
    private static PDF unitTestBook2;
    private static PDF unitTestBook3;
    private static UTF8 unitTestBook4;
    private static PDF unitTestBook5;
    private static PDF unitTestBook6;
    private static PDF unitTestBook7;
    private static UTF8 unitTestBook8;
    // need a way to mock the values instead of querying database

    @BeforeClass
    public static void setUp(){
        unitTestBook1 = (UTF8) BookFactory.getBook(BookType.UTF8, UTF8_FILE_PATH,"unit test book 1");
        unitTestBook2 = (PDF) BookFactory.getBook(BookType.PDF, PDF_FILE_PATH,"unit test book 2");
        unitTestBook3 = (PDF) BookFactory.getBook(BookType.PDF, PDF_FILE_PATH,"unit test book 3");
        bookDAO.addBook(unitTestBook3);
        unitTestBook4 = (UTF8) BookFactory.getBook(BookType.UTF8, UTF8_FILE_PATH,"unit test book 4");
        bookDAO.addBook(unitTestBook4);
        unitTestBook5 = (PDF) BookFactory.getBook(BookType.PDF, PDF_FILE_PATH,"unit test book 5");
        bookDAO.addBook(unitTestBook5);
        unitTestBook6 = (PDF) BookFactory.getBook(BookType.PDF, PDF_FILE_PATH,"unit test book 6");
        bookDAO.addBook(unitTestBook6);
        unitTestBook7 = (PDF) BookFactory.getBook(BookType.PDF, PDF_FILE_PATH,"unit test book 7");
        bookDAO.addBook(unitTestBook7);
        unitTestBook8 = (UTF8) BookFactory.getBook(BookType.UTF8, PDF_FILE_PATH,"unit test book 8");
        bookDAO.addBook(unitTestBook8);
    }

    @Test
    public void addUTF8Test() throws IOException {
        boolean successfullySubmitted = bookDAO.addBook(unitTestBook1);
        assertTrue(successfullySubmitted);
    }

    @Test
    public void addPDFTest() {
        boolean successfullySubmitted = bookDAO.addBook(unitTestBook2);
        assertTrue(successfullySubmitted);
    }

    @Test
    public void getPDFTest() {
        PDF bookImpl = (PDF)bookDAO.getBook(unitTestBook3.getId(), PDF.class);
        assertNotNull(bookImpl);
    }

    @Test
    public void getUTF8Test() {
        UTF8 bookImpl = (UTF8)bookDAO.getBook(unitTestBook4.getId(), UTF8.class);
        assertNotNull(bookImpl);
    }

    @Test
    public void getBookByNameTest() {
       List<PDF> bookList =  bookDAO.getBookByName("unit test book 5", UTF8.class);
       assertTrue(bookList.size()>=1);
    }

    @Test(expected = NullPointerException.class)
    public void deleteBookByNameTest() {
        bookDAO.deleteBooksByName(unitTestBook6.getBookName(),PDF.class);
        bookDAO.getBook(unitTestBook6.getId(), PDF.class);
    }

    @Test(expected = NullPointerException.class)
    public void deleteBookTest() {
        bookDAO.deleteBook(unitTestBook7.getId(),PDF.class);
        bookDAO.getBook(unitTestBook7.getId(),PDF.class);
    }

    // need to make this to be more generic
    @Test
    public void updateBookTest() {
       unitTestBook8.setBookName("Updated Name");
       bookDAO.updateBook(unitTestBook8);
    }

    @AfterClass
    public static void tearDown() {
        bookDAO.deleteBooksByName(unitTestBook1.getBookName(),UTF8.class);
        bookDAO.deleteBooksByName(unitTestBook2.getBookName(),PDF.class);
        bookDAO.deleteBooksByName(unitTestBook3.getBookName(),PDF.class);
        bookDAO.deleteBooksByName(unitTestBook4.getBookName(),UTF8.class);
        bookDAO.deleteBooksByName(unitTestBook5.getBookName(),PDF.class);
        bookDAO.deleteBooksByName(unitTestBook7.getBookName(),PDF.class);
        bookDAO.deleteBooksByName(unitTestBook8.getBookName(),UTF8.class);
    }
}