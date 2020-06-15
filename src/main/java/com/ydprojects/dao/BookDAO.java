package com.ydprojects.dao;

import com.ydprojects.entity.book.BookImpl;

import java.util.List;

public interface BookDAO <T extends BookImpl> {

    boolean addBook(BookImpl bookImpl);
    T getBook(Long bookId, Class clazz );
    boolean deleteBook(Long bookId, Class clazz);
    boolean updateBook(T newBook);
    List retrieveAllBooks();

}
