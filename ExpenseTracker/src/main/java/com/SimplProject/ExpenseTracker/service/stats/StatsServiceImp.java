package com.SimplProject.ExpenseTracker.service.stats;

import com.SimplProject.ExpenseTracker.DTO.GraphDTO;
import com.SimplProject.ExpenseTracker.DTO.StatDTO;
import com.SimplProject.ExpenseTracker.entity.Expense;
import com.SimplProject.ExpenseTracker.entity.Income;
import com.SimplProject.ExpenseTracker.repository.ExpenseRepository;
import com.SimplProject.ExpenseTracker.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

@Service
public class StatsServiceImp implements StatsService {

    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    public StatsServiceImp(IncomeRepository incomeRepository,ExpenseRepository expenseRepository){
        this.expenseRepository=expenseRepository;
        this.incomeRepository=incomeRepository;
    }

    public GraphDTO getChartData(){
        LocalDate endDate=LocalDate.now();
        LocalDate startDate=endDate.minusDays(27);

        GraphDTO graphDTO=new GraphDTO();
        graphDTO.setExpenseList(expenseRepository.findByDateBetween(startDate,endDate));
        graphDTO.setIncomeList(incomeRepository.findByDateBetween(startDate,endDate));
        return graphDTO;
    }

    public StatDTO getStats(){
        Double totalIncome=incomeRepository.sumAllAmounts();
        Double totalExpense=expenseRepository.sumAllAmounts();

        Optional<Income>optionalIncome=incomeRepository.findFirstByOrderByDateDesc();
        Optional<Expense>optionalExpense=expenseRepository.findFirstByOrderByDateDesc();

        StatDTO statDTO=new StatDTO();
        statDTO.setExpense(totalExpense);
        statDTO.setIncome(totalIncome);

        if(optionalIncome.isPresent()){
            statDTO.setLatestIncome(optionalIncome.get());
        }
        if(optionalExpense.isPresent()){
            statDTO.setLatestExpense(optionalExpense.get());
        }


        statDTO.setBalance(totalIncome-totalExpense);

        List<Income>incomeList=incomeRepository.findAll();
        List<Expense>expenseList=expenseRepository.findAll();


        OptionalDouble minIncome = incomeList.stream()
                .mapToDouble(Income::getAmount)
                .min();
        OptionalDouble maxIncome = incomeList.stream()
                .mapToDouble(Income::getAmount)
                .max();

        OptionalDouble minExpense = expenseList.stream()
                .mapToDouble(Expense::getAmount)
                .min();
        OptionalDouble maxExpense = expenseList.stream()
                .mapToDouble(Expense::getAmount)
                .max();


        if(maxExpense.isPresent()){
            statDTO.setMaxExpense(maxExpense.getAsDouble());
        }
        else if(!maxExpense.isPresent()){
            statDTO.setMaxExpense(null);
        }

        if(maxIncome.isPresent()){
            statDTO.setMaxIncome(maxIncome.getAsDouble());
        }
        else if(!maxIncome.isPresent()){
            statDTO.setMaxIncome(null);
        }

        if(minIncome.isPresent()){
            statDTO.setMinIncome(minIncome.getAsDouble());
        }
        else if(!minIncome.isPresent()){
            statDTO.setMinIncome(null);
        }

        if(minExpense.isPresent()){
            statDTO.setMinExpense(minExpense.getAsDouble());
        }
        else if(!minExpense.isPresent()){
            statDTO.setMinExpense(null);
        }




        return statDTO;
    }




}
