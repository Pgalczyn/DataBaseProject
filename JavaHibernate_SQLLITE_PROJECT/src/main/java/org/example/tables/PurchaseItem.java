package org.example.tables;

import jakarta.persistence.*;

@Entity
public class PurchaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Purchase purchase;
    @ManyToOne
    private Ticket ticket;
    private int quantity;
}
