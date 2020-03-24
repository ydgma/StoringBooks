package com.ydprojects.DAO;

import com.ydprojects.modal.Book;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BookDAOTest {
    private BookDAO bookDAO= new BookDAO();

    @Test
    public void addBookTesT() {
        Book book = new Book(2,"abcd","abc123",3,4);
        boolean successfullySubmitted = bookDAO.addBook(book);
       assertTrue(successfullySubmitted);
    }

    @Test
    public void getBookTest() {
        Book book =  bookDAO.getBook();
        assertNotNull(book);
    }
}
