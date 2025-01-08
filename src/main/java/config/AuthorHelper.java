package config;

import entity.Person;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AuthorHelper {
    private SessionFactory sessionFactory;

    public AuthorHelper () {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public List<Person> getPersonList() {
        Session session = sessionFactory.openSession();
        session.get(Person.class,1L);

        CriteriaBuilder cd = session.getCriteriaBuilder();
        CriteriaQuery cq = cd.createQuery(Person.class);
        Root<Person> author = cq.from(Person.class);
        cq.select(author);
        Query query = session.createQuery(cq);
        List<Person> person = query.getResultList();
        session.close();
        return person;
    }
}
