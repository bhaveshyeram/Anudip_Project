package com.example.expensemanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.expensemanager.DTO.expenseDTO;
import com.example.expensemanager.entity.expense;

@Service
public interface service {
	public expense createExpense(expenseDTO ex);
	public expense getExpense(int id);
	public List<expense> getAllExpenses();
	public expense updateExpense(int id,expenseDTO ex);
	public String deleteExpense(int id);
	public String deleteAllExpenses();
	
	
}
