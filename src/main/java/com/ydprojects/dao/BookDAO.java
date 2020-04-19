package com.ydprojects.dao;

import com.ydprojects.modal.BookImpl;
import com.ydprojects.modal.PDF;
import com.ydprojects.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookDAO {
    private static final Logger LOG = LoggerFactory.getLogger(BookDAO.class);

    public boolean addBook(BookImpl bookimpl) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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

    public <T extends BookImpl> T getBook(Long bookId, Class T ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        T book = (T) session.get(T, bookId);
        if(!book.getBookType().equalsIgnoreCase(T.getSimpleName())) {
            throw new RuntimeException("please retrieve a valid book with a type of " + T.getSimpleName());
        }
        return book;
    }

    public <T extends BookImpl> void deleteBook(Long bookId, Class T ) {
        T book = getBook(bookId, T);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(book);
        transaction.commit();
    }
}
