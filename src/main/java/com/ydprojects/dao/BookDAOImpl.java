package com.ydprojects.dao;

import com.ydprojects.entity.book.BookImpl;
import com.ydprojects.config.HibernateConfig;
import com.ydprojects.entity.book.BookType;
import com.ydprojects.entity.book.PDF;
import com.ydprojects.entity.book.UTF8;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

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
    public  T getBook(Long bookId, Class clazz ) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        T book = (T) session.get(clazz, bookId);
        if(!book.getBookType().toString().equalsIgnoreCase(clazz.getSimpleName())) {
            throw new RuntimeException("please retrieve a valid book with a type of " + clazz.getSimpleName());
        }
        return book;
    }

    public List<T> getBookByName(String nameOfBook, Class clazz ) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(clazz);
        List<T> list = criteria.add(Restrictions.eq("bookName", nameOfBook)).list();
        return list;
    }

    @Override
    public void deleteBook(Long bookId, Class clazz) {
        T book = getBook(bookId, clazz);
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(book);
        LOG.info("deleting book by id {}", bookId);
        transaction.commit();
    }

    public void deleteBooksByName(String bookName, Class clazz ) {
        List<T> books = getBookByName(bookName, clazz);
        List<T> listOfPDFs = extractBooksOfTypeFromList(books,BookType.PDF);
        List<T> listOfUTF8s = extractBooksOfTypeFromList(books,BookType.UTF8);
        //delete PDFs
        listOfPDFs.forEach(p -> deleteBook(p.getId(),PDF.class));
        //delete UTF8s
        listOfUTF8s.forEach(p -> deleteBook(p.getId(), UTF8.class));

    }

    @Override
    public void updateBook(BookImpl newBook) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        if(!newBook.getBookType().toString().equalsIgnoreCase(newBook.getClass().getSimpleName())) {
            throw new RuntimeException("Unable to modify the type field of the book " + newBook.getClass().getSimpleName());
        }
        session.update(newBook);
        transaction.commit();
    }

    private List<T> extractBooksOfTypeFromList(List<T> books, BookType bookType) {
        return books
                .stream()
                .filter(b-> b.getBookType() == bookType)
                .collect(Collectors.toList());
    }
}
