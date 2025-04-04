package com.SimplProject.ExpenseTracker.DTO;

import com.SimplProject.ExpenseTracker.entity.Expense;
import com.SimplProject.ExpenseTracker.entity.Income;

public class StatDTO {

    private double income;
    private double expense;

    private Income latestIncome;
    private Expense latestExpense;


    private Double minIncome;
    private Double maxIncome;
    private Double minExpense;
    private Double maxExpense;
    private Double balance;


    public Double getMinIncome() {
        return minIncome;
    }

    public void setMinIncome(Double minIncome) {
        this.minIncome = minIncome;
    }

    public Double getMaxIncome() {
        return maxIncome;
    }

    public void setMaxIncome(Double maxIncome) {
        this.maxIncome = maxIncome;
    }

    public Double getMinExpense() {
        return minExpense;
    }

    public void setMinExpense(Double minExpense) {
        this.minExpense = minExpense;
    }

    public Double getMaxExpense() {
        return maxExpense;
    }

    public void setMaxExpense(Double maxExpense) {
        this.maxExpense = maxExpense;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public Income getLatestIncome() {
        return latestIncome;
    }

    public void setLatestIncome(Income latestIncome) {
        this.latestIncome = latestIncome;
    }

    public Expense getLatestExpense() {
        return latestExpense;
    }

    public void setLatestExpense(Expense latestExpense) {
        this.latestExpense = latestExpense;
    }

    @Override
    public String toString() {
        return "StatDTO{" +
                "income=" + income +
                ", expense=" + expense +
                ", latestIncome=" + latestIncome +
                ", latestExpense=" + latestExpense +
                ", minIncome=" + minIncome +
                ", maxIncome=" + maxIncome +
                ", minExpense=" + minExpense +
                ", maxExpense=" + maxExpense +
                ", balance=" + balance +
                '}';
    }

}
