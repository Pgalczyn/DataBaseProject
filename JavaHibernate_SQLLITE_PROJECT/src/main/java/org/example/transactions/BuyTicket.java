package org.example.transactions;

import org.example.tables.Customer;
import org.example.tables.Reserve;
import org.example.tables.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public class BuyTicket {
    public static void buy(Session session, List<Ticket> ticketList, Customer customer) {

        Transaction tx = session.beginTransaction();

       for (Ticket t : ticketList) {

           try{
               Ticket ticket = session.get(Ticket.class,t.getId());

               if(ticket==null){
                   throw new RuntimeException("Ticket does not exist");
               }
               else if (ticket.isSold()){
                   throw new RuntimeException("Ticket is Sold");
               }

               String hql = "FROM Reserve r WHERE r.ticket = :ticket AND r.customer = :customer ORDER BY r.expirationTime DESC";
               Reserve reservation = session.createQuery(hql, Reserve.class)
                       .setParameter("ticket", ticket)
                       .setParameter("customer", customer)
                       .setMaxResults(1)
                       .uniqueResult();

               if(reservation==null){
                   throw new RuntimeException("Reservation does not exist");
               }
               LocalDateTime expiration = LocalDateTime.now();
               if(reservation.getExpirationTime().isBefore(expiration)){
                   throw new RuntimeException("Reservation is expired");
               }

               ticket.setSold(true);

           }
       }



    }
}
