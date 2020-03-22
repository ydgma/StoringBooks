import java.io.File;
import java.util.List;

public interface Book {

    String getFileContentAsString();
    int getWordCount();
    int getSpecificWordCount(String wordToSearch);

}
