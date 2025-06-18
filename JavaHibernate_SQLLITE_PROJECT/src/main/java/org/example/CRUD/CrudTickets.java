package org.example.CRUD;

import org.example.tables.Customer;
import org.example.tables.Ticket;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class CrudTickets {

    public static List<Ticket> allAvailableTickets(Session session) {
        String hql = "FROM Ticket t WHERE t.isSold = false";
        return session.createQuery(hql, Ticket.class).getResultList();
    }

    public static List<Ticket> ticketsForConreteEvent(Session session,String event,String sector) {

        String hql = "FROM Ticket t WHERE t.event = :event AND t.sector = :sector";

        return session.createQuery(hql, Ticket.class)
                .setParameter("event", event)
                .setParameter("sector", sector)
                .getResultList();
    }

    public static List<Ticket> futureEvents(Session session) {
        String hql = "FROM Ticket t WHERE t.date > :now";
        return session.createQuery(hql, Ticket.class)
                .setParameter("now", new Date())
                .getResultList();
    }

    public static List<Ticket> priceRange(Session session,int from,int to) {
        String hql = "FROM Ticket t WHERE t.price BETWEEN :min AND :max";
        return session.createQuery(hql, Ticket.class)
                .setParameter("min", from)
                .setParameter("max", to)
                .getResultList();
    }

    public static List<Ticket> allReserved(Session session) {
        String hql = "FROM Ticket t WHERE t.isSold = true OR t.isReserved = true";
        return session.createQuery(hql, Ticket.class).getResultList();
    }

    public static List<Ticket> getPurchasedTickets(Session session, Customer customer) {
        String hql = """
        SELECT pi.ticket
        FROM PurchaseItem pi
        WHERE pi.purchase.customer = :customer
    """;

        return session.createQuery(hql, Ticket.class)
                .setParameter("customer", customer)
                .getResultList();
    }

}
