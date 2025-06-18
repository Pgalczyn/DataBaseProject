package org.example.CRUD;

import org.example.tables.Customer;
import org.hibernate.Session;

import java.util.List;

public class CrudCustomer {

    public static List<Customer> allCustomers(Session session) {
        String hql = "FROM Customer";
        return session.createQuery(hql, Customer.class).getResultList();
    }

    public static Customer getCustomerById(Session session, int id) {
        return session.get(Customer.class, id);
    }

    public static Customer getCustomerByUsername(Session session, String username) {
        String hql = "FROM Customer c WHERE c.username = :username";
        return session.createQuery(hql, Customer.class)
                .setParameter("username", username)
                .uniqueResult();
    }

    public static List<Customer> getCustomersBySurname(Session session, String surname) {
        String hql = "FROM Customer c WHERE c.surname = :surname";
        return session.createQuery(hql, Customer.class)
                .setParameter("surname", surname)
                .getResultList();
    }
}
