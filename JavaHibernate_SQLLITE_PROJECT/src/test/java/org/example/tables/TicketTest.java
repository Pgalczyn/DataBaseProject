package org.example.tables;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    public void testConstructorAndGetters() {
        Date date = new Date();
        Ticket ticket = new Ticket(date, "Koncert", 150, "A", 5, 12);

        assertEquals(date, ticket.getDate());
        assertEquals("A", ticket.getSector());
        assertEquals("Koncert", ticket.getEvent());
        assertEquals(150, ticket.getPrice());
        assertEquals(5, ticket.getSeatRow());
        assertEquals(12, ticket.getSeatNumber());
        assertFalse(ticket.isReserved());
        assertFalse(ticket.isSold());
    }

    @Test
    public void testSetters() {
        Ticket ticket = new Ticket();
        Date now = new Date();

        ticket.setPrice(200);
        ticket.setSeatNumber(3);
        ticket.setSeatRow(1);
        ticket.setSector("VIP");
        ticket.setReserved(true);
        ticket.setSold(true);
        ticket.setDate(now);

        assertEquals(200, ticket.getPrice());
        assertEquals(3, ticket.getSeatNumber());
        assertEquals(1, ticket.getSeatRow());
        assertEquals("VIP", ticket.getSector());
        assertTrue(ticket.isReserved());
        assertTrue(ticket.isSold());
        assertEquals(now, ticket.getDate());
    }

}