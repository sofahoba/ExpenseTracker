package com.SimplProject.ExpenseTracker.controller;

import com.SimplProject.ExpenseTracker.entity.Expense;
import com.SimplProject.ExpenseTracker.entity.Income;
import com.SimplProject.ExpenseTracker.repository.ExpenseRepository;
import com.SimplProject.ExpenseTracker.repository.IncomeRepository;
import com.SimplProject.ExpenseTracker.service.stats.StatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


@RestController
@RequestMapping("/api/stats")
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService=statsService;
    }

    @GetMapping("/graph-data")
    public ResponseEntity<?>getChartDetails(){
        return ResponseEntity.ok(statsService.getChartData());
    }


    @GetMapping
    public ResponseEntity<?>getStats(){
        return ResponseEntity.ok(statsService.getStats());
    }

}
