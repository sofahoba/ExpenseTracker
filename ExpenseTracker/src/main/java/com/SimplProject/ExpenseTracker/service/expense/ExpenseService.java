package com.SimplProject.ExpenseTracker.service.expense;


import com.SimplProject.ExpenseTracker.DTO.ExpenseDTO;
import com.SimplProject.ExpenseTracker.entity.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {


    Expense postExpense(ExpenseDTO expenseDTO);
    List<Expense> getAllExpenses();
    Optional<Expense> getExpenseById(Long theId);
    Expense updateExpense(Long id, ExpenseDTO expenseDTO);
    void deleteExpense(Long theId);
}
