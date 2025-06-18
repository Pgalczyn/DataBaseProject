package org.example.tables;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Customer customer;
    @OneToMany
    private List<PurchaseItem> itemsPurchased = new ArrayList<PurchaseItem>();
    private Date date;

    public Purchase() {}
    public Purchase(Customer customer) {
        this.customer = customer;
        this.date = new Date();
    }

    public void addItem(PurchaseItem item) {
        itemsPurchased.add(item);
    }
}
