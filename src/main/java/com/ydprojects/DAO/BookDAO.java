package com.ydprojects.DAO;

import com.ydprojects.modal.BookImpl;
import com.ydprojects.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookDAO {

    private static final Logger LOG = LoggerFactory.getLogger(BookDAO.class);
    public boolean addBook(BookImpl bookImpl) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.save(bookImpl);
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

    /*public BookImpl getBook() {
        //todo
        //return new BookImpl(0,null,null,0,0);
    }*/
}
