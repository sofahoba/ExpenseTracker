package com.SimplProject.ExpenseTracker.service.stats;

import com.SimplProject.ExpenseTracker.DTO.GraphDTO;
import com.SimplProject.ExpenseTracker.DTO.StatDTO;
import com.SimplProject.ExpenseTracker.entity.Expense;
import com.SimplProject.ExpenseTracker.entity.Income;

import java.time.LocalDate;
import java.util.List;

public interface StatsService {

    GraphDTO getChartData();

    StatDTO getStats();

}
