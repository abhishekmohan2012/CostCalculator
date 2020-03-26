package com.engine.cycle.models;

import javax.persistence.*;

@Entity
@Table(name = "WHEEL")
@NamedQuery(name = "Wheel.findByType",
        query = "SELECT w from Wheel w where w.type = ?1 and ?2 between w.start_date and w.end_date")

public class Wheel extends AbstractModel{

    @Column(name = "TYPE")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
