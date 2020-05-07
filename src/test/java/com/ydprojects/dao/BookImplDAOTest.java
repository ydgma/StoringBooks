package com.ydprojects.dao;

import com.ydprojects.config.AppConfig;
import com.ydprojects.entity.book.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
@DirtiesContext(classMode= DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookImplDAOTest {

    @Autowired
    private BookDAOImpl bookDAO;

    private static final Logger LOG = LoggerFactory.getLogger(BookImplDAOTest.class);
    private static final String UTF8_FILE_PATH = "src/test/resources/33364.txt.utf-8.txt";
    private static final String PDF_FILE_PATH = "src/test/resources/33364.txt.utf-8.pdf";
    private static UTF8 unitTestBook1;
    private static PDF unitTestBook2;
    private static PDF unitTestBook3;
    private static UTF8 unitTestBook4;
    private static PDF unitTestBook5;
    private static PDF unitTestBook6;
    private static PDF unitTestBook7;
    private static UTF8 unitTestBook8;
    // need a way to mock the values instead of querying database

    @Test
    public void addUTF8Test() throws IOException {
        unitTestBook1 = (UTF8) BookFactory.getBook(BookType.UTF8, UTF8_FILE_PATH, "unit test book 1");
        boolean successfullySubmitted = bookDAO.addBook(unitTestBook1);
        assertTrue(successfullySubmitted);
        bookDAO.deleteBook(unitTestBook1.getId(),UTF8.class);
    }

    @Test
    public void addPDFTest() {
        unitTestBook2 = (PDF) BookFactory.getBook(BookType.PDF, PDF_FILE_PATH, "unit test book 2");
        boolean successfullySubmitted = bookDAO.addBook(unitTestBook2);
        assertTrue(successfullySubmitted);
        bookDAO.deleteBook(unitTestBook2.getId(),PDF.class);
    }

    @Test
    public void getPDFTest() {
        unitTestBook3 = (PDF) BookFactory.getBook(BookType.PDF, PDF_FILE_PATH, "unit test book 3");
        bookDAO.addBook(unitTestBook3);
        PDF bookImpl = (PDF) bookDAO.getBook(unitTestBook3.getId(), PDF.class);
        assertNotNull(bookImpl);
        bookDAO.deleteBook(unitTestBook3.getId(),PDF.class);
    }

    @Test
    public void getUTF8Test() {
        unitTestBook4 = (UTF8) BookFactory.getBook(BookType.UTF8, UTF8_FILE_PATH, "unit test book 4");
        bookDAO.addBook(unitTestBook4);
        UTF8 bookImpl = (UTF8) bookDAO.getBook(unitTestBook4.getId(), UTF8.class);
        assertNotNull(bookImpl);
        bookDAO.deleteBook(unitTestBook4.getId(),UTF8.class);
    }

    @Test
    public void getBookByNameTest() {
        unitTestBook5 = (PDF) BookFactory.getBook(BookType.PDF, PDF_FILE_PATH, "unit test book 5");
        bookDAO.addBook(unitTestBook5);
        List<PDF> bookList = bookDAO.getBookByName("unit test book 5", UTF8.class);
        assertTrue(bookList.size() >= 1);
        bookDAO.deleteBook(unitTestBook5.getId(),PDF.class);
    }

    @Test(expected = NullPointerException.class)
    public void deleteBookByNameTest() {
        unitTestBook6 = (PDF) BookFactory.getBook(BookType.PDF, PDF_FILE_PATH, "unit test book 6");
        bookDAO.addBook(unitTestBook6);
        bookDAO.deleteBooksByName(unitTestBook6.getBookName(), PDF.class);
        bookDAO.getBook(unitTestBook6.getId(), PDF.class);
    }

    @Test(expected = NullPointerException.class)
    public void deleteBookTest() {
        unitTestBook7 = (PDF) BookFactory.getBook(BookType.PDF, PDF_FILE_PATH, "unit test book 7");
        bookDAO.addBook(unitTestBook7);
        bookDAO.deleteBook(unitTestBook7.getId(), PDF.class);
        bookDAO.getBook(unitTestBook7.getId(), PDF.class);
    }

    // need to make this to be more generic
    @Test
    public void updateBookTest() {
        unitTestBook8 = (UTF8) BookFactory.getBook(BookType.UTF8, UTF8_FILE_PATH, "unit test book 8");
        bookDAO.addBook(unitTestBook8);
        unitTestBook8.setBookName("Updated Name");
        bookDAO.updateBook(unitTestBook8);
        bookDAO.deleteBook(unitTestBook8.getId(),UTF8.class);
    }
}