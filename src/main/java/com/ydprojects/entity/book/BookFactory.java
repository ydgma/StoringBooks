package com.ydprojects.entity.book;

public class BookFactory {

    public static BookImpl getBook(BookType bookType, String filePath, String bookName, String wordToSearch){
        if(bookType == BookType.PDF) {
            return new PDF(bookName,filePath, wordToSearch);
        } else if (bookType == BookType.UTF8) {
            return new UTF8(bookName, filePath, wordToSearch);
        } else {
            return null;
        }
    }
}
