package org.example.tables;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    @ManyToOne
    private Customer customer;
    private String action;

    public Log() {}
    public Log(Date date, String action, Customer customer) {
        this.date = date;
        this.action = action;
        this.customer = customer;
    }
}
