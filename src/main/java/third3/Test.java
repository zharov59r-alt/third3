package third3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import third3.entity.Role;
import third3.entity.User;

import java.util.Set;

public class Test {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration() // фабрика по производству сессий
                .configure("hibernate.cfg.xml") // данное название является стандартным и его можно не писать
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Role adminRole = new Role("Admin");
            Role userRole = new Role("User");

            User user = new User("qwe");

            user.addRole(adminRole);
            user.addRole(userRole);

            session.persist(user);

            session.getTransaction().commit();


/*

            session.beginTransaction();

            User user = session.find(User.class, 1);

            System.out.println(user.getRoles());

            session.getTransaction().commit();


            session.beginTransaction();

            Role role = session.find(Role.class, 1);

            session.remove(role);

            session.getTransaction().commit();

*/
        } finally {
            factory.close();
        }



    }
}
