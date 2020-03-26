package com.engine.cycle.models.wheelComponentModule;

import com.engine.cycle.models.AbstractModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "SPOKE")
@NamedQuery(name = "Spoke.findByType",
        query = "SELECT t from Spoke t where t.type = ?1 and ?2 between t.start_date and t.end_date")

public class Spoke extends AbstractModel {
    @Column(name = "TYPE")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
