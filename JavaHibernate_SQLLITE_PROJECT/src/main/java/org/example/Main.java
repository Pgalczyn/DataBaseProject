package org.example;

import org.example.dataSeeder.DataSeed;
import org.example.tables.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    private static SessionFactory sessionFactory = null;




    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        configuration.addAnnotatedClass(Ticket.class);
        configuration.addAnnotatedClass(Purchase.class);
        configuration.addAnnotatedClass(PurchaseItem.class);
        configuration.addAnnotatedClass(Log.class);
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Reserve.class);

        sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        DataSeed.seedCustomers(session);
        DataSeed.seedTickets(session);
        tx.commit();


        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
