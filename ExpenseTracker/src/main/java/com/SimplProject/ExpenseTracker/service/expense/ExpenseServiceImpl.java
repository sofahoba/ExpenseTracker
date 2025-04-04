package com.SimplProject.ExpenseTracker.service.expense;

import com.SimplProject.ExpenseTracker.DTO.ExpenseDTO;
import com.SimplProject.ExpenseTracker.entity.Expense;
import com.SimplProject.ExpenseTracker.repository.ExpenseRepository;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Service
public class ExpenseServiceImpl implements ExpenseService {


    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }





    @Override
    public Expense postExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense();
        expense.setTitle(expenseDTO.getTitle());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription(expenseDTO.getDescription());
        expense.setDate(expenseDTO.getDate());

        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll().stream()
                .sorted(Comparator.comparing(Expense::getDate).reversed())
                .collect(Collectors.toList());
    }




    @Override
    public Optional<Expense> getExpenseById(Long theId) {
        return expenseRepository.findById(theId);
    }




    @Override
    public Expense updateExpense(Long id, ExpenseDTO expenseDTO) {
        Optional<Expense> tempExpense = expenseRepository.findById(id);

        if (tempExpense.isPresent()) {
            Expense expense = tempExpense.get();
            expense.setTitle(expenseDTO.getTitle());
            expense.setAmount(expenseDTO.getAmount());
            expense.setCategory(expenseDTO.getCategory());
            expense.setDescription(expenseDTO.getDescription());
            expense.setDate(expenseDTO.getDate());

            return expenseRepository.save(expense);
        } else {
            return null;
        }
    }

    @Override
    public void deleteExpense(Long theId) {
        Optional<Expense> tempExpense= expenseRepository.findById(theId);
        if(tempExpense.isPresent()){
            expenseRepository.delete(tempExpense.get());
        }
    }

}
