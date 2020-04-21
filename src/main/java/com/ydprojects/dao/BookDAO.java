package com.ydprojects.dao;

import com.ydprojects.entity.book.BookImpl;

public interface BookDAO <T extends BookImpl> {

    boolean addBook(BookImpl bookImpl);
    T getBook(Long bookId, Class T );
    void deleteBook(Long bookId, Class T);
    void updateBook(T newBook);

}
