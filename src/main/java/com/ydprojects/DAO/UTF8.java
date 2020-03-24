package com.ydprojects.DAO;

public class UTF8 extends BookType {

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
