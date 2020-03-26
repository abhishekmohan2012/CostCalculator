package com.engine.cycle.models;

import com.engine.cycle.models.wheelComponentModule.Rim;
import com.engine.cycle.models.wheelComponentModule.Spoke;
import com.engine.cycle.models.wheelComponentModule.Tube;
import com.engine.cycle.models.wheelComponentModule.Tyre;

import javax.persistence.*;

@Entity
@Table(name = "WHEEL")
@NamedQuery(name = "Wheel.findByType",
        query = "SELECT w from Wheel w where w.type = ?1 and ?2 between w.start_date and w.end_date")

public class Wheel extends AbstractModel {

    @Column(name = "TYPE")
    private String type;

    @Transient
    private Rim rim;

    @Transient
    private Spoke spoke;

    @Transient
    private Tube tube;

    @Transient
    private Tyre tyre;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Rim getRim() {
        return rim;
    }

    public void setRim(Rim rim) {
        this.rim = rim;
    }

    public Spoke getSpoke() {
        return spoke;
    }

    public void setSpoke(Spoke spoke) {
        this.spoke = spoke;
    }

    public Tube getTube() {
        return tube;
    }

    public void setTube(Tube tube) {
        this.tube = tube;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
}
