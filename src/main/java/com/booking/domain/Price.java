package com.booking.domain;

import java.util.Date;

public class Price {
    private PriceType Type;
    private double price;
    private Date start;
    private Date end;

    public Price(PriceType type, double price, Date start, Date end) {
        Type = type;
        this.price = price;
        this.start = start;
        this.end = end;
    }

    public PriceType getType() {
        return Type;
    }

    public void setType(PriceType type) {
        Type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
