package com.engine.cycle.controller;

import com.engine.cycle.models.Cycle;
import com.engine.cycle.models.Frame;
import com.engine.cycle.service.OrderProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InputController {
    @Autowired
    OrderProcess orderProcess;

    @GetMapping(path = "/", produces = "application/json")
    public Cycle getCycle(){
        return new Cycle();
    }

    @GetMapping(path = "/frame", produces = "application/json")
    public Frame getFrame(){
        return new Frame();
    }

    @PostMapping(path = "/order", consumes = "application/json")
    public void getOrder(@RequestBody List<Cycle> cycleList) {
        orderProcess.getAllPrice(cycleList);
    }
}
