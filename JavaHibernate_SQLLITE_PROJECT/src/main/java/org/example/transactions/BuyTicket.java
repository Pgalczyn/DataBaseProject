package org.example.transactions;

import jakarta.persistence.OptimisticLockException;
import org.example.tables.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class BuyTicket {
    public static void buy(Session session, List<Ticket> ticketList, Customer customer) {
        Transaction tx = session.beginTransaction();
        try {
            Purchase purchase = new Purchase(customer);

            for (Ticket t : ticketList) {
                Ticket ticket = session.get(Ticket.class, t.getId());

                if (ticket == null) throw new RuntimeException("Ticket does not exist");
                if (ticket.isSold()) throw new RuntimeException("Ticket is already sold");

                String hql = "FROM Reserve r WHERE r.ticket = :ticket AND r.customer = :customer ORDER BY r.expirationTime DESC";
                Reserve reservation = session.createQuery(hql, Reserve.class)
                        .setParameter("ticket", ticket)
                        .setParameter("customer", customer)
                        .setMaxResults(1)
                        .uniqueResult();

                if (reservation == null) throw new RuntimeException("Reservation not found");
                if (reservation.getExpirationTime().isBefore(LocalDateTime.now())) {
                    throw new RuntimeException("Reservation has expired");
                }

                ticket.setSold(true);
                PurchaseItem purchaseItem = new PurchaseItem(purchase, ticket);
                session.persist(purchaseItem);
                purchase.addItem(purchaseItem);
            }
            Log log = new Log(new Date(),"BUY",customer);
            session.persist(log);
            session.persist(purchase);
            tx.commit();
        }
        catch (OptimisticLockException e) {
            tx.rollback();
            e.printStackTrace();
            System.out.println("racing condition");
        }

        catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            System.out.println("Nie udało się kupić biletów");
        }
    }
}
