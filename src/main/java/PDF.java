import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PDF extends AbstractBook {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractBook.class);
    private String filePath;

    public PDF(String filePath) {
        this.filePath = filePath;
        this.convertBookContentsToString();
    }

    @Override
    public void convertBookContentsToString() {
        String filePath = getBookFilePath();
        try {
            bookAsString = String.join("", Files.readAllLines(Paths.get(filePath)));
        } catch (IOException e) {
            LOG.info("{}",e);
        }
    }

    @Override
    String getBookFilePath() {
        return filePath;
    }
}
