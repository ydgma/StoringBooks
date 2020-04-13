package com.ydprojects.modal;

public class BookFactory {

    public static AbstractBook getBook(String bookType, String filePath, String bookName){
        if(bookType.equalsIgnoreCase("PDF")) {
            return new PDF(filePath,bookName);
        } else if (bookType.equalsIgnoreCase("UTF8")) {
            return new UTF8(filePath,bookName);
        } else {
            return null;
        }
    }
}
