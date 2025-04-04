package com.SimplProject.ExpenseTracker.service.income;

import com.SimplProject.ExpenseTracker.DTO.ExpenseDTO;
import com.SimplProject.ExpenseTracker.DTO.IncomeDTO;
import com.SimplProject.ExpenseTracker.entity.Expense;
import com.SimplProject.ExpenseTracker.entity.Income;
import com.SimplProject.ExpenseTracker.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IncomeServiceImpl implements IncomeService{
    private final IncomeRepository incomeRepository;

    @Autowired
    public IncomeServiceImpl(IncomeRepository incomeRepository){
        this.incomeRepository=incomeRepository;
    }

    @Override
    public Income postIncome(IncomeDTO incomeDTO) {

        Income income=new Income();

        income.setAmount(incomeDTO.getAmount());
        income.setId(incomeDTO.getId());
        income.setCategory(incomeDTO.getCategory());
        income.setDescription(incomeDTO.getDescription());
        income.setTitle(incomeDTO.getTitle());
        income.setDate(incomeDTO.getDate());


        return incomeRepository.save(income);

    }

    @Override
    public List<Income> getAllIncome() {

        return incomeRepository.findAll().stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Income> getIncomeById(Long theId) {
        return incomeRepository.findById(theId);
    }

    @Override
    public Income updateIncome(Long id, IncomeDTO incomeDTO) {
        Optional<Income> tempIncome = incomeRepository.findById(id);

        if (tempIncome.isPresent()) {
            Income income = tempIncome.get();
            income.setTitle(incomeDTO.getTitle());
            income.setAmount(incomeDTO.getAmount());
            income.setCategory(incomeDTO.getCategory());
            income.setDescription(incomeDTO.getDescription());
            income.setDate(incomeDTO.getDate());

            return incomeRepository.save(income);
        } else {
            return null;
        }
    }

    @Override
    public void deleteIncome(Long theId) {
        Optional<Income> tempIncome= incomeRepository.findById(theId);
        if(tempIncome.isPresent()){
            incomeRepository.delete(tempIncome.get());
        }
    }


}
