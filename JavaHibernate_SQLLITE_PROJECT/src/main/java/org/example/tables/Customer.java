package org.example.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String firstname;
    private String surname;
    private String email;
    private String password;

    public Customer() {}

    public Customer(String username, String firstname, String surname, String email, String password) {
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}
