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
    @OneToMany
    private List<Customer> customerList = new ArrayList<>();
    private String action;
}
