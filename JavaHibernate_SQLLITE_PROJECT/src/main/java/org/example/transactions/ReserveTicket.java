package org.example.transactions;

import jakarta.persistence.OptimisticLockException;
import org.example.tables.Customer;
import org.example.tables.Log;
import org.example.tables.Reserve;
import org.example.tables.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.Date;

// rezerwacja jest dokonywana wtedy gdy uzytkownik dodaje bilet do koszyka i jest aktywna przez 20 min
public class ReserveTicket {
    public static void reserve(Session session, Customer customer, Ticket t) {
            Transaction tx = session.beginTransaction();

            try{
                Ticket ticket = session.get(Ticket.class,t.getId());

                if(ticket==null){
                    throw new RuntimeException("Ticket does not exist");
                }
                else if (ticket.isSold()){
                    throw new RuntimeException("Ticket is Sold");
                }
                else if(ticket.isReserved()){
                    String HQL = "FROM Reserve r WHERE r.ticket.id = :ticketId ORDER BY r.expirationTime DESC";
                    Reserve reservation = (Reserve) session.createQuery(HQL,Reserve.class)
                            .setParameter("ticketId",ticket.getId())
                            .setMaxResults(1)
                            .uniqueResult();
                    LocalDateTime expiration = LocalDateTime.now();
                    if (reservation.getExpirationTime().isBefore(expiration)) {
                        throw new RuntimeException("Ticket is currently reserved");
                    }
                    else {
                        System.out.println("Ticket is available last reservation is expired");
                    }
                }
                ticket.setReserved(true);
                Reserve reserve = new Reserve(customer, t);
                session.persist(reserve);
                Log log = new Log(new Date(),"RESERVE",customer);
                session.persist(log);
                tx.commit();
                System.out.println("Bilet zarezerwowany pomyślnie");
            } catch (OptimisticLockException e) {
                tx.rollback();
                System.out.println("Nie udało się zarezerwować biletu (ktoś go już zarezerwował)");
            } catch (Exception e) {
                tx.rollback();
                e.printStackTrace();
            }

            }

    }
