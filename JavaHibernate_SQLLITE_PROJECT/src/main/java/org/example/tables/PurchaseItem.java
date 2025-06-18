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

    public PurchaseItem() {}
    public PurchaseItem(Purchase purchase, Ticket ticket) {
        this.purchase = purchase;
        this.ticket = ticket;
    }
}
