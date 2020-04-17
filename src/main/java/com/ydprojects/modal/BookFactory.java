package com.ydprojects.modal;

public class BookFactory {

    public static BookImpl getBook(String bookType, String filePath, String bookName, String wordToSearch){
        if(bookType.equalsIgnoreCase("PDF")) {
            return new PDF(bookName,filePath, wordToSearch);
        } else if (bookType.equalsIgnoreCase("UTF8")) {
            return new UTF8(bookName, filePath, wordToSearch);
        } else {
            return null;
        }
    }
}
