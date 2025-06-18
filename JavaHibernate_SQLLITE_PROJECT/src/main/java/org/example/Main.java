package org.example;

import org.example.CRUD.CrudCustomer;
import org.example.CRUD.CrudReports;
import org.example.CRUD.CrudTickets;
import org.example.dataSeeder.DataSeed;
import org.example.tables.*;
import org.example.transactions.BuyTicket;
import org.example.transactions.ReserveTicket;
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
//
//       Transaction tx = session.beginTransaction();
//        DataSeed.seedCustomers(session);
//        DataSeed.seedTickets(session);
//         List<Ticket> ticketList =  CrudTickets.allAvailableTickets(session);
//
//         Ticket.printTickets(ticketList);
//        List<Customer> customers = CrudCustomer.allCustomers(session);
//        Customer.printCustomers(customers);
        Customer customer = session.get(Customer.class, 1);
        Ticket ticket = session.get(Ticket.class, 1);
//        ReserveTicket.reserve(session, customer, ticket);
      //  BuyTicket.buy(session,List.of(ticket), customer);

//        List<Ticket> tickets = CrudTickets.getPurchasedTickets(session,customer);
//        Ticket.printTickets(tickets);
  //     Long x = CrudReports.amountOfSoldTicketsLast7Days(session);
        Long x = CrudReports.totalRevenueLast7Days(session);
        System.out.println(x);
//     tx.commit();


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
