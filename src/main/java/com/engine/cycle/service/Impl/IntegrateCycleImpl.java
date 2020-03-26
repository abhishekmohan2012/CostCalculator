package com.engine.cycle.service.Impl;

import com.engine.cycle.Constants;
import com.engine.cycle.models.*;
import com.engine.cycle.models.wheelComponentModule.Rim;
import com.engine.cycle.models.wheelComponentModule.Spoke;
import com.engine.cycle.models.wheelComponentModule.Tube;
import com.engine.cycle.models.wheelComponentModule.Tyre;
import com.engine.cycle.repository.CrudService;
import com.engine.cycle.service.IntegrateCycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class IntegrateCycleImpl implements IntegrateCycle, Constants {
    @Autowired
    CrudService crudService;

    @Autowired
    EntityManager em;

    @Override
    public void calculateCostCycle(Cycle cycle) {
        int chain, frame, seat, wheel, rim, spoke, tube, tyre;
        try {
            chain = calculateCostChain(cycle.getChainAssembly(), cycle.getDate());
            frame = calculateCostFrame(cycle.getFrame(), cycle.getDate());
            seat = calculateCostSeat(cycle.getSeat(), cycle.getDate());
            wheel = calculateCostWheels(cycle.getWheel(), cycle.getDate());
            rim = calculateCostRim(cycle.getWheel().getRim(), cycle.getDate());
            spoke = calculateCostSpoke(cycle.getWheel().getSpoke(), cycle.getDate());
            tube = calculateCostTube(cycle.getWheel().getTube(), cycle.getDate());
            tyre = calculateCostTyre(cycle.getWheel().getTyre(), cycle.getDate());
        } catch (NoResultException e) {
            e.printStackTrace();
            System.out.println("No Configuration found");
            return;
        }
        if (chain > 0 && frame > 0 && seat > 0 && wheel > 0 && rim > 0 && spoke > 0 && tyre > 0 && tube > 0) {
            System.out.println(chain + frame + seat + wheel + rim + spoke + tyre + tube + " Price :: " + Thread.currentThread().getName());
        } else {
            System.out.println("No Configuration found");
        }
    }

    private int calculateCostWheels(Wheel wheel, Date purDate) throws NoResultException {
        Query q = em.createNamedQuery(WHEEL);
        q.setParameter(1, wheel.getType());
        q.setParameter(2, purDate);
        List<Wheel> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0).getPrice();
        }
        return -1;
    }

    private int calculateCostFrame(Frame frame, Date purDate) throws NoResultException {
        Query q = em.createNamedQuery(FRAME);
        q.setParameter(1, frame.getType());
        q.setParameter(2, purDate);
        List<Frame> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0).getPrice();
        }
        return -1;
    }

    private int calculateCostSeat(Seat seat, Date purDate) throws NoResultException {
        Query q = em.createNamedQuery(SEAT);
        q.setParameter(1, seat.getType());
        q.setParameter(2, purDate);
        List<Seat> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0).getPrice();
        }
        return -1;
    }

    private int calculateCostChain(ChainAssembly assembly, Date purDate) throws NoResultException {
        Query q = em.createNamedQuery(CHAIN_ASSEMBLY);
        q.setParameter(1, assembly.getType());
        q.setParameter(2, purDate);
        List<ChainAssembly> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0).getPrice();
        }
        return -1;
    }

    private int calculateCostRim(Rim rim, Date purDate) throws NoResultException {
        Query q = em.createNamedQuery(RIM);
        q.setParameter(1, rim.getType());
        q.setParameter(2, purDate);
        List<Rim> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0).getPrice();
        }
        return -1;
    }

    private int calculateCostSpoke(Spoke spoke, Date purDate) throws NoResultException {
        Query q = em.createNamedQuery(SPOKE);
        q.setParameter(1, spoke.getType());
        q.setParameter(2, purDate);
        List<Spoke> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0).getPrice();
        }
        return -1;
    }

    private int calculateCostTube(Tube tube, Date purDate) throws NoResultException {
        Query q = em.createNamedQuery(TUBE);
        q.setParameter(1, tube.getType());
        q.setParameter(2, purDate);
        List<Tube> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0).getPrice();
        }
        return -1;
    }

    private int calculateCostTyre(Tyre tyre, Date purDate) throws NoResultException {
        Query q = em.createNamedQuery(TYRE);
        q.setParameter(1, tyre.getType());
        q.setParameter(2, purDate);
        List<Tyre> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0).getPrice();
        }
        return -1;
    }
}
