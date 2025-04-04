package com.SimplProject.ExpenseTracker.DTO;

import com.SimplProject.ExpenseTracker.entity.Expense;
import com.SimplProject.ExpenseTracker.entity.Income;

import java.util.List;

public class GraphDTO {

    private List<Expense>expenseList;


    private List<Income>incomeList;


    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public List<Income> getIncomeList() {
        return incomeList;
    }

    public void setIncomeList(List<Income> incomeList) {
        this.incomeList = incomeList;
    }

    @Override
    public String toString() {
        return "GraphDTO{" +
                "expenseList=" + expenseList +
                ", incomeList=" + incomeList +
                '}';
    }
}
