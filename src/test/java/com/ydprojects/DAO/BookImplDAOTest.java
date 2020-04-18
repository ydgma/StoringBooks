package com.ydprojects.DAO;

import com.ydprojects.modal.BookFactory;
import com.ydprojects.modal.PDF;
import com.ydprojects.modal.UTF8;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class BookImplDAOTest {
    private BookDAO bookDAO= new BookDAO();

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
}