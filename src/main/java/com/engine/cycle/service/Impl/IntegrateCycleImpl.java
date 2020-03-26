package com.engine.cycle.service.Impl;

import com.engine.cycle.Repository.CrudService;
import com.engine.cycle.models.*;
import com.engine.cycle.service.IntegrateCycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class IntegrateCycleImpl implements IntegrateCycle {
    @Autowired
    CrudService crudService;

    @Autowired
    EntityManager em;

    @Override
    public int calculateCostCycle(Cycle cycle) {
        int i = -1;
        try {
            i = calculateCostChain(cycle.getChainAssembly(), cycle.getDate()) +
                    calculateCostFrame(cycle.getFrame(), cycle.getDate()) +
                    calculateCostSeat(cycle.getSeat(), cycle.getDate()) +
                    calculateCostWheels(cycle.getWheel(), cycle.getDate());
        } catch (NoResultException e) {
            e.printStackTrace();
            return -1;
        }
        System.out.println(i + " Price :: " + Thread.currentThread().getName());
        return i;
    }

    private int calculateCostWheels(Wheel wheel, Date purDate) throws NoResultException {
        Query q = em.createNamedQuery("Wheel.findByType");
        q.setParameter(1, wheel.getType());
        q.setParameter(2, purDate);
        List<Wheel> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0).getPrice();
        }
        return 0;
    }

    private int calculateCostFrame(Frame frame, Date purDate) throws NoResultException {
        Query q = em.createNamedQuery("Frame.findByType");
        q.setParameter(1, frame.getType());
        q.setParameter(2, purDate);
        List<Frame> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0).getPrice();
        }
        return 0;
    }

    private int calculateCostSeat(Seat seat, Date purDate) throws NoResultException {
        Query q = em.createNamedQuery("Seat.findByType");
        q.setParameter(1, seat.getType());
        q.setParameter(2, purDate);
        List<Seat> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0).getPrice();
        }
        return 0;
    }

    private int calculateCostChain(ChainAssembly assembly, Date purDate) throws NoResultException {
        Query q = em.createNamedQuery("ChainAssembly.findByType");
        q.setParameter(1, assembly.getType());
        q.setParameter(2, purDate);
        List<ChainAssembly> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0).getPrice();
        }
        return 0;
    }
}
