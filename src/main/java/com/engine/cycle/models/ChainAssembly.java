package com.engine.cycle.models;

import javax.persistence.*;

@Entity
@Table(name = "CHAIN_ASSEMBLY")
@NamedQuery(name = "ChainAssembly.findByType",
        query = "SELECT c from ChainAssembly c where c.type = ?1 and ?2 between c.start_date and c.end_date")

public class ChainAssembly extends AbstractModel {

    @Column(name = "TYPE")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
