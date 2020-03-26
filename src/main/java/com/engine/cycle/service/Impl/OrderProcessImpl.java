package com.engine.cycle.service.Impl;

import com.engine.cycle.Repository.CrudService;
import com.engine.cycle.models.Cycle;
import com.engine.cycle.service.IntegrateCycle;
import com.engine.cycle.service.OrderProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class OrderProcessImpl implements OrderProcess {
    @Autowired
    IntegrateCycle integrateCycle;
    @Autowired
    CrudService crudService;

    private ExecutorService executorService = new ThreadPoolExecutor(10,10,0L
            , TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());

    @Override
    public List<Integer> getAllPrice(List<Cycle> cycleList) {
        List<Integer> prices = new ArrayList<>();
        for (Cycle cycle : cycleList) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                   // System.out.println(Thread.currentThread().getName());
                    prices.add(integrateCycle.calculateCostCycle(cycle));
                }
            });
            //prices.add(integrateCycle.calculateCostCycle(cycle));
        }
        return prices;
    }
}
