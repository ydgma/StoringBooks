package com.ydprojects.DAO;

import com.ydprojects.modal.*;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class BookImplDAOTest {
    private BookDAO bookDAO= new BookDAO();

    //todo need
    @Test
    public void addUTF8Test() throws IOException {
        String filePath = "/Users/yasirudahanayake/IdeaProjects/StoringData/src/test/resources/33364.txt.utf-8.txt";
        BookImpl book = BookFactory.getBook("utf8", filePath,"Random Book2", "project");
        //UTF8 utf8 = new UTF8(filePath,"new book");
       /* BookImpl bookImpl = new BookImpl(utf8.getBookType(),
                utf8.getBookContentsAsString(),
                utf8.getWordCount(),
                utf8.getSpecificWordCount("and"),
                utf8.getBookAsFile(),
                utf8.bookName());*/
        boolean successfullySubmitted = bookDAO.addBook(book);
        assertTrue(successfullySubmitted);
    }

   /* @Test
    public void getBookTest() {
        BookImpl bookImpl =  bookDAO.getBook();
        assertNotNull(bookImpl);
    }*/
}