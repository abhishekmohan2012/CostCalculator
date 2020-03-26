package com.engine.cycle.service;

import com.engine.cycle.models.Cycle;

import java.util.List;

public interface OrderProcess {
    public List<Integer> getAllPrice(List<Cycle> cycleList);
}
