package org.example.tables;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    private Date date;
    private String event;
    private int price;
    private String sector;
    private int seatRow;
    private int seatNumber;
    private boolean isReserved;
    private boolean isSold;
    @Version
    private int version;
    public Ticket(){}

    public Ticket(Date date, String event, int price, String sector, int seatRow, int seatNumber) {
        this.date = date;
        this.event = event;
        this.price = price;
        this.sector = sector;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.isReserved = false;
        this.isSold = false;

    }

    public static void printTickets(List<Ticket> tickets) {
        for (Ticket t : tickets) {
            System.out.printf("ID: %d, Event: %s, Date: %s, Sector: %s, Row: %d, Seat: %d, Price: %d, Sold: %b, Reserved: %b%n",
                    t.getId(),
                    t.getEvent(),
                    t.getDate(),
                    t.getSector(),
                    t.getSeatRow(),
                    t.getSeatNumber(),
                    t.getPrice(),
                    t.isSold(),
                    t.isReserved()
            );
        }
    }



    public String getEvent() {
        return event;
    }

    public int getId() {
        return id;
    }
    public boolean isReserved() {
        return isReserved;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
