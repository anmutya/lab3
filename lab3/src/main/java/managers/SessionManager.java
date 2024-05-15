package managers;

import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {
    private Session session;

    public Session getSession() {
        return session;
    }

    public Session createSession() {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Operators.class)
                .addAnnotatedClass(Status.class)
                .addAnnotatedClass(Reactors.class)
                .addAnnotatedClass(Countries.class)
                .addAnnotatedClass(Kium.class)
                .addAnnotatedClass(Owners.class)
                .addAnnotatedClass(Regions.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        this.session = sessionFactory.openSession();
        return session;
    }

    public void closeSession() {
        session.close();
    }

}
