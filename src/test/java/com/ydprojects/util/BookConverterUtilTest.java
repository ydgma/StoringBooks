package com.ydprojects.util;

import com.ydprojects.dao.BookDAOImpl;
import com.ydprojects.entity.book.BookFactory;
import com.ydprojects.entity.book.BookType;
import com.ydprojects.entity.book.UTF8;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BookConverterUtilTest {
    private static UTF8 unitTestBook1;
    private static final String UTF8_FILE_PATH = "src/test/resources/33364.txt.utf-8.txt";
    private static final String FILE_DESTINATION = "src/test/resources/randomFile.pdf";
    private static BookDAOImpl bookDAO;
    private static final Logger LOG = LoggerFactory.getLogger(BookConverterUtilTest.class);

    @BeforeClass
    public static void setUp(){
        unitTestBook1 = (UTF8) BookFactory.getBook(BookType.UTF8, UTF8_FILE_PATH,"unit test book 1");
    }

   @Test
    public void convertFromByteToFileTest() throws IOException {
        BookConverterUtil.writeByteArrayToFile(unitTestBook1.getBook(),FILE_DESTINATION);
        Path path = Paths.get(FILE_DESTINATION);
        Assert.assertTrue(Files.exists(path));
    }

    @AfterClass
    public static void tearDown() {
        Path path = Paths.get(FILE_DESTINATION);
        try {
            Files.delete(path);
        } catch (IOException e) {
            LOG.info("{}",e);
        }
    }

}
