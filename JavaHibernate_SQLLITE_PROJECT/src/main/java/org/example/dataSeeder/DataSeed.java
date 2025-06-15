package org.example.dataSeeder;

import org.example.tables.Customer;
import org.example.tables.Ticket;
import org.hibernate.Session;

import java.sql.Date;
import java.util.List;

public class DataSeed {
    public static void seedCustomers(Session session) {
        List<Customer> customers = List.of(
                new Customer("jnowak", "Jan", "Nowak", "jan.nowak@example.com", "haslo123"),
                new Customer("akowalska", "Anna", "Kowalska", "anna.kowalska@example.com", "qwerty"),
                new Customer("tmalinowski", "Tomasz", "Malinowski", "t.malinowski@example.com", "tajne123"),
                new Customer("mszpak", "Magda", "Szpak", "magda.szpak@example.com", "magda2025"),
                new Customer("pzajac", "Piotr", "Zając", "piotr.zajac@example.com", "piotrz!"),
                new Customer("klewandowski", "Kasia", "Lewandowska", "kasia.lewandowska@example.com", "lewkas"),
                new Customer("dolszewski", "Dawid", "Olszewski", "dawid.olszewski@example.com", "abc12345"),
                new Customer("akaczmarek", "Agnieszka", "Kaczmarek", "agnieszka.kaczmarek@example.com", "agn2024"),
                new Customer("rmazur", "Robert", "Mazur", "robert.mazur@example.com", "robmaz"),
                new Customer("nwróbel", "Natalia", "Wróbel", "natalia.wrobel@example.com", "haslonatalia")
        );

        for (Customer customer : customers) {
            session.persist(customer);
        }
    }

    public static void seedTickets(Session session) {
        List<Ticket> tickets = List.of(
                new Ticket(Date.valueOf("2025-07-10"), "Koncert A", 100, "A", 1, 1),
                new Ticket(Date.valueOf("2025-07-10"), "Koncert A", 100, "A", 1, 2),
                new Ticket(Date.valueOf("2025-07-10"), "Koncert A", 100, "A", 1, 3),
                new Ticket(Date.valueOf("2025-07-11"), "Koncert B", 150, "B", 2, 1),
                new Ticket(Date.valueOf("2025-07-11"), "Koncert B", 150, "B", 2, 2),
                new Ticket(Date.valueOf("2025-07-11"), "Koncert B", 150, "B", 2, 3),
                new Ticket(Date.valueOf("2025-07-12"), "Teatr C", 200, "C", 3, 1),
                new Ticket(Date.valueOf("2025-07-12"), "Teatr C", 200, "C", 3, 2),
                new Ticket(Date.valueOf("2025-07-12"), "Teatr C", 200, "C", 3, 3),
                new Ticket(Date.valueOf("2025-07-13"), "Koncert A", 100, "A", 4, 1),
                new Ticket(Date.valueOf("2025-07-13"), "Koncert A", 100, "A", 4, 2),
                new Ticket(Date.valueOf("2025-07-13"), "Koncert A", 100, "A", 4, 3),
                new Ticket(Date.valueOf("2025-07-14"), "Koncert B", 150, "B", 5, 1),
                new Ticket(Date.valueOf("2025-07-14"), "Koncert B", 150, "B", 5, 2),
                new Ticket(Date.valueOf("2025-07-14"), "Koncert B", 150, "B", 5, 3),
                new Ticket(Date.valueOf("2025-07-10"), "Teatr C", 200, "C", 6, 1),
                new Ticket(Date.valueOf("2025-07-10"), "Teatr C", 200, "C", 6, 2),
                new Ticket(Date.valueOf("2025-07-10"), "Teatr C", 200, "C", 6, 3),
                new Ticket(Date.valueOf("2025-07-11"), "Koncert A", 100, "A", 7, 1),
                new Ticket(Date.valueOf("2025-07-11"), "Koncert A", 100, "A", 7, 2),
                new Ticket(Date.valueOf("2025-07-11"), "Koncert A", 100, "A", 7, 3),
                new Ticket(Date.valueOf("2025-07-12"), "Koncert B", 150, "B", 8, 1),
                new Ticket(Date.valueOf("2025-07-12"), "Koncert B", 150, "B", 8, 2),
                new Ticket(Date.valueOf("2025-07-12"), "Koncert B", 150, "B", 8, 3),
                new Ticket(Date.valueOf("2025-07-13"), "Teatr C", 200, "C", 9, 1),
                new Ticket(Date.valueOf("2025-07-13"), "Teatr C", 200, "C", 9, 2),
                new Ticket(Date.valueOf("2025-07-13"), "Teatr C", 200, "C", 9, 3),
                new Ticket(Date.valueOf("2025-07-14"), "Koncert A", 100, "A", 10, 1),
                new Ticket(Date.valueOf("2025-07-14"), "Koncert A", 100, "A", 10, 2),
                new Ticket(Date.valueOf("2025-07-14"), "Koncert A", 100, "A", 10, 3)
        );

        for (Ticket t : tickets) {
            session.persist(t);
        }
    }

}
