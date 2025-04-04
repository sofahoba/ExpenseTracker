package com.SimplProject.ExpenseTracker.controller;


import com.SimplProject.ExpenseTracker.DTO.ExpenseDTO;
import com.SimplProject.ExpenseTracker.entity.Expense;
import com.SimplProject.ExpenseTracker.service.expense.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/expense")
@CrossOrigin("*")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired ExpenseController(ExpenseService expenseService){
        this.expenseService=expenseService;
    }



    @PostMapping
    public ResponseEntity<?> postExpense(@RequestBody ExpenseDTO dto) {
        Expense tempExpense = expenseService.postExpense(dto);
        if(tempExpense!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(tempExpense);
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }





    @GetMapping("/all")
    public ResponseEntity<?>getAllExpenses(){
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?>getOperationById(@PathVariable Long id){

        Optional<Expense>expense=expenseService.getExpenseById(id);

        if(expense.isPresent()){
            return ResponseEntity.ok(expense.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense Not Found");
        }
    }




    @PutMapping("/{id}")
    public ResponseEntity<?>updateExpense(@PathVariable Long id, @RequestBody ExpenseDTO expenseDTO){
        Expense updateExpense=expenseService.updateExpense(id,expenseDTO);
        if(updateExpense==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Id you Entered Not exist");
        }
        else{
            return ResponseEntity.ok(updateExpense);
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteExpense(@PathVariable Long id){
        Optional<Expense> deletedExpense = expenseService.getExpenseById(id);
        if(deletedExpense.isPresent()){
            expenseService.deleteExpense(id);
            return ResponseEntity.ok().body("Expense Deleted Successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense not found.");
        }
    }


}
