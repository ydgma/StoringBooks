package entity;

public class UTF8 extends AbstractBook{

    private String filePath;

    public UTF8(String filePath) {
        this.filePath = filePath;
        convertBookContentsToString();
    }

    @Override
    public String getBookFilePath() {
        return filePath;
    }
}
