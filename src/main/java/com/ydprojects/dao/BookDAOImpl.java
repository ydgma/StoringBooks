package com.ydprojects.dao;

import com.ydprojects.entity.book.BookImpl;
import com.ydprojects.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookDAOImpl <T extends BookImpl> implements BookDAO{
    private static final Logger LOG = LoggerFactory.getLogger(BookDAOImpl.class);

    @Override
    public boolean addBook(BookImpl bookimpl) {
        Transaction transaction = null;

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.save(bookimpl);
                transaction.commit();
                LOG.info("Successfully saved book");
                return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOG.trace("{}",e);

        }
        return false;
    }

    @Override
    public  T getBook(Long bookId, Class T ) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        T book = (T) session.get(T, bookId);
        if(!book.getBookType().equalsIgnoreCase(T.getSimpleName())) {
            throw new RuntimeException("please retrieve a valid book with a type of " + T.getSimpleName());
        }
        return book;
    }

    @Override
    public void deleteBook(Long bookId, Class T) {
        T book = getBook(bookId, T);
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(book);
        transaction.commit();
    }

    @Override
    public void updateBook(BookImpl newBook) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        if(!newBook.getBookType().equalsIgnoreCase(newBook.getClass().getSimpleName())) {
            throw new RuntimeException("Unable to modify the type field of the book " + newBook.getClass().getSimpleName());
        }
        session.update(newBook);
        transaction.commit();
    }
}
