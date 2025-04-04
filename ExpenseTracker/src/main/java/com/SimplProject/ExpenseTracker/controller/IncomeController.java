package com.SimplProject.ExpenseTracker.controller;


import com.SimplProject.ExpenseTracker.DTO.IncomeDTO;
import com.SimplProject.ExpenseTracker.entity.Income;
import com.SimplProject.ExpenseTracker.service.income.IncomeService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    private final IncomeService incomeService;

    @Autowired
    public IncomeController(IncomeService incomeService){
        this.incomeService=incomeService;
    }


    @PostMapping
    public ResponseEntity<?>postIncome(@RequestBody IncomeDTO dto){
        Income tempIncome=incomeService.postIncome(dto);
        if(tempIncome==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.CREATED).body(tempIncome);
        }
    }


    @GetMapping("/all")
    public ResponseEntity<?>getAllIncome(){
        return ResponseEntity.ok(incomeService.getAllIncome());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getIncomeById(@PathVariable Long id){
        Optional<Income>income=incomeService.getIncomeById(id);
        if(income.isPresent()){
            return ResponseEntity.ok(income.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Id you Entered Not Exist");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?>updateIncome(@PathVariable Long id,@RequestBody IncomeDTO incomeDTO){

        Income updateIncome=incomeService.updateIncome(id,incomeDTO);
        if(updateIncome==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Id you Entered Not Exist");
        }
        else{
            return ResponseEntity.ok(updateIncome);
        }

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteIncome(@PathVariable Long id){
        Optional<Income>deleteIncome=incomeService.getIncomeById(id);
        if(deleteIncome.isPresent()){
            incomeService.deleteIncome(id);
            return ResponseEntity.ok().body("Expense Deleted Successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Id you Entered Not Exist");
    }




}
