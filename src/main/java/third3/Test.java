package third3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration() // фабрика по производству сессий
                .configure("hibernate.cfg.xml") // данное название является стандартным и его можно не писать
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();


            session.getTransaction().commit();

        } finally {
            factory.close();
        }



    }
}
