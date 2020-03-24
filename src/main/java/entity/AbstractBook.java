package entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class AbstractBook implements Book {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractBook.class);
    protected String bookAsString;
    private static final String WHITE_SPACE_SPLITTER = "\\s+";

    abstract String getBookFilePath();

    public void convertBookContentsToString () {
        String filePath = getBookFilePath();
        try {
            bookAsString = String.join("", Files.readAllLines(Paths.get(filePath)));
        } catch (IOException e) {
            LOG.info("{}",e);
        }
    }

    @Override
    public String getFileContentAsString() {
        return bookAsString;
    }

    @Override
    public int getWordCount() {
        return bookAsString.split(WHITE_SPACE_SPLITTER).length;
    }

    @Override
    public int getSpecificWordCount(String wordToSearch) {
        String [] arrayOfStrings = bookAsString.split(WHITE_SPACE_SPLITTER);
        int count = 0;
        for (String s: arrayOfStrings) {
            if(s.equalsIgnoreCase(wordToSearch)) {
                count ++;
            }
        }
        return count;
    }
}
