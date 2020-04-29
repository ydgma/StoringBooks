package com.ydprojects.entity.book;

public class BookFactory {

    public static BookImpl getBook(BookType bookType, String filePath, String bookName){
        if(bookType == BookType.PDF) {
            return new PDF(bookName,filePath);
        } else if (bookType == BookType.UTF8) {
            return new UTF8(bookName, filePath);
        } else {
            return null;
        }
    }
}
