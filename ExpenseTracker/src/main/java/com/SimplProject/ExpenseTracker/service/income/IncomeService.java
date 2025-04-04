package com.SimplProject.ExpenseTracker.service.income;

import com.SimplProject.ExpenseTracker.DTO.ExpenseDTO;
import com.SimplProject.ExpenseTracker.DTO.IncomeDTO;
import com.SimplProject.ExpenseTracker.entity.Expense;
import com.SimplProject.ExpenseTracker.entity.Income;

import java.util.List;
import java.util.Optional;

public interface IncomeService {

    Income postIncome(IncomeDTO incomeDTO);
    List<Income> getAllIncome();
    Optional<Income> getIncomeById(Long theId);
    Income updateIncome(Long id, IncomeDTO incomeDTO);
    void deleteIncome(Long theId);

}
