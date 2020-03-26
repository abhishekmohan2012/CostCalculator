package com.engine.cycle.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractModel {
    @Id
    @Column(name = "RECORD_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq", initialValue = 1000, sequenceName = "seq", allocationSize = 100)
    @JsonIgnore
    private long id;

    @Column(name = "PRICE", nullable = false)
    @JsonIgnore
    private int price;

    @Column(name = "START_DATE")
    @JsonIgnore
    private Date start_date;

    @Column(name = "END_DATE")
    @JsonIgnore
    private Date end_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
