package com.ydprojects.functional.stepdefinitions;

import com.ydprojects.config.AppConfig;
import com.ydprojects.dao.BookDAOImpl;
import com.ydprojects.entity.book.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@ContextConfiguration(classes= AppConfig.class)
public class AddBookStepDefinitions {
    private static final String UTF8_FILE_PATH = "src/test/resources/33364.txt.utf-8.txt";
    private static final String PDF_FILE_PATH = "src/test/resources/33364.txt.utf-8.pdf";
    private static final String TEST_BOOK_NAME = "Random Book9";

    @Autowired
    private BookDAOImpl dao;

    @When("I add a {string}")
    public void iAddA(String bookType) {
        BookType type = bookType.equalsIgnoreCase("PDF") ? BookType.PDF : BookType.UTF8;
        String filePath = bookType.equalsIgnoreCase("PDF") ? PDF_FILE_PATH : UTF8_FILE_PATH;
        BookImpl book = BookFactory.getBook(type,filePath,TEST_BOOK_NAME);
        dao.addBook(book);
    }

    @Then("the {string} book is successfully added to the database")
    public void theBookIsSuccessfullyAddedToTheDatabase(String bookType) {
       // BookType type = bookType.equalsIgnoreCase("PDF") ? BookType.PDF : BookType.UTF8;
        Class clazz = bookType.equalsIgnoreCase("PDF") ? PDF.class : UTF8.class;
        List<BookImpl> listOfBooks =  dao.getBookByName(TEST_BOOK_NAME,clazz);
        Assert.assertTrue(listOfBooks.size() >=1);
        dao.deleteBooksByName(TEST_BOOK_NAME,clazz);
    }


}
