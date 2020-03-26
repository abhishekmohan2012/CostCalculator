package com.engine.cycle.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "SEAT")
@NamedQuery(name = "Seat.findByType",
        query = "SELECT s from Seat s where s.type = ?1 and ?2 between s.start_date and s.end_date")
public class Seat extends AbstractModel{

    @Column(name = "TYPE")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
