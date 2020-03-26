package com.engine.cycle.service.Impl;

import com.engine.cycle.models.Cycle;
import com.engine.cycle.repository.CrudService;
import com.engine.cycle.service.IntegrateCycle;
import com.engine.cycle.service.OrderProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class OrderProcessImpl implements OrderProcess {
    @Autowired
    IntegrateCycle integrateCycle;
    @Autowired
    CrudService crudService;

    private ExecutorService executorService = new ThreadPoolExecutor(10,10,0L
            , TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());

    @Override
    public void getAllPrice(List<Cycle> cycleList) {
        for (Cycle cycle : cycleList) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    integrateCycle.calculateCostCycle(cycle);
                }
            });
        }
    }
}
