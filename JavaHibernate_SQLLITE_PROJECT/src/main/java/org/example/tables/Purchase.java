package org.example.tables;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Customer customer;
    @OneToMany
    private List<PurchaseItem> itemsPurchased;


}
