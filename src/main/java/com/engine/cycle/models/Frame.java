package com.engine.cycle.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "FRAME")
@NamedQuery(name = "Frame.findByType",
        query = "SELECT f from Frame f where f.type = ?1 and ?2 between f.start_date and f.end_date")
public class Frame extends AbstractModel{

    @Column(name = "TYPE")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
