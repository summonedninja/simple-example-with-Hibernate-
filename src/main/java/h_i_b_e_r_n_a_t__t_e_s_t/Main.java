package h_i_b_e_r_n_a_t__t_e_s_t;

import config.AuthorHelper;
import config.BookHelper;
import config.HibernateUtil;
import entity.Book;
import entity.Person;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        for(Person person: new AuthorHelper().getPersonList()) {
            System.out.println("author (" + person.getName() + " )");
        }
        for(Book book: new BookHelper().getAllBooksName()) {
            System.out.println("author (" + book.getNameBook() + " )");
        }
    }
}
