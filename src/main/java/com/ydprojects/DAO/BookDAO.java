package com.ydprojects.DAO;

import com.ydprojects.modal.Book;
import com.ydprojects.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BookDAO {

    private static final Logger LOG = LoggerFactory.getLogger(BookDAO.class);
    public boolean addBook(Book book) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.save(book);
                transaction.commit();
                LOG.info("Successfully saved the student");
                return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOG.trace("{}",e);

        }
        return false;
    }

    public Book getBook() {
        //todo
        return new Book(0,null,null,0,0);
    }
}
