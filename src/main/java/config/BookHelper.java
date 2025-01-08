package config;

import entity.Book;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookHelper {
    private SessionFactory sessionFactory;

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Book> getAllBooksName() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root);

        Query query = session.createQuery(cq);
        List<Book> listBook = query.getResultList();
        session.close();
        return listBook;
    }
}
