package org.example.tables;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Ticket ticket;

    private LocalDateTime reservationTime;
    private LocalDateTime expirationTime;

    public Reserve() {}

    public Reserve(Customer customer, Ticket ticket) {
        this.customer = customer;
        this.ticket = ticket;
        this.reservationTime = LocalDateTime.now();
        this.expirationTime = LocalDateTime.now().plusMinutes(20);
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

}
