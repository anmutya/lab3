package an_mutya.lab3;

import entyties.Countries;
import entyties.Kium;
import entyties.Reactors;
import entyties.Operators;
import entyties.Owners;
import entyties.Regions;
import entyties.Status;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author annamutovkina
 */
public class main {

    public static void createReactors(Session session, ArrayList<Reactors> reactors) {
        session.beginTransaction();
        for (Reactors react : reactors) {
            session.persist(react);
        }
        session.flush();
        session.getTransaction().commit();
    }

    public static void createOwners(Session session, ArrayList<Owners> owners) {
        session.beginTransaction();
        for (Owners owner : owners) {
            session.persist(owner);
        }
        session.flush();
        session.getTransaction().commit();
    }

    public static void createOperators(Session session, ArrayList<Operators> operators) {
        session.beginTransaction();
        for (Operators operator : operators) {
            session.persist(operator);
        }
        session.flush();
        session.getTransaction().commit();
    }

    public static void createCountries(Session session, ArrayList<Countries> countries) {
        session.beginTransaction();
        for (Countries country : countries) {
            session.persist(country);
        }
        session.flush();
        session.getTransaction().commit();
    }

    public static void createRegions(Session session, ArrayList<Regions> regions) {
        session.beginTransaction();
        for (Regions region : regions) {
            session.persist(region);
        }
        session.flush();
        session.getTransaction().commit();
    }

    public static void createStatus(Session session, ArrayList<Status> statuses) {
        session.beginTransaction();
        for (Status status : statuses) {
            session.persist(status);
        }
        session.flush();
        session.getTransaction().commit();
    }

    public static void createKiums(Session session, ArrayList<Kium> kiums) throws SQLException {
        session.beginTransaction();
        int count = 0;
        for (Kium kium : kiums) {
            session.persist(kium);
            count++;
            if (count % 25 == 0) {
                session.flush();
                session.clear();
                Logger.getGlobal().log(Level.INFO, "Write " + count + " rows");
            }
        }
        session.flush();
        session.clear();
        session.getTransaction().commit();
    }

    public static void main(String[] args) {
        ArrayList<Reactors> reactorses = null;
        ArrayList<Operators> operatorses = null;
        ArrayList<Owners> owners = null;
        ArrayList<Regions> regions = null;
        ArrayList<Countries> countries = null;
        ArrayList<Status> statuses = null;
        ArrayList<Kium> kiums = null;
        CreateEntitiesForDB entity = new CreateEntitiesForDB();
        try {
            reactorses = entity.createReactors();
            operatorses = entity.createOperators();
            owners = entity.createOwners();
            regions = entity.createRegions();
            countries = entity.createCountries();
            statuses = entity.createStatus();
            kiums = entity.createKium();

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
            try {

                Session session = sessionFactory.openSession();
                createKiums(session, kiums);

                session.close();

//                sessionFactory.inTransaction(session -> {
//                    var test = (Reactors) session.get(Reactors.class, 1);
//                    var owner = test.getOwner();
//                    System.out.println(owner.getId() + "-" + owner.getName());
//
//                });
            } catch (Exception ex) {
                System.out.println(ex);

            }
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
