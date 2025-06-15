package org.example.tables;

import jakarta.persistence.*;

import java.util.Date;

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
}
