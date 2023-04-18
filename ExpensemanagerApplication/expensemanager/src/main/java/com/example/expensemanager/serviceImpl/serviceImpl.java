package com.example.expensemanager.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.expensemanager.DTO.expenseDTO;
import com.example.expensemanager.entity.expense;
import com.example.expensemanager.repository.expenseRepository;
import com.example.expensemanager.service.service;

@Component
public class serviceImpl implements service {
	
	@Autowired
	expenseRepository er;

	@Override
	public expense createExpense(expenseDTO ex) {
		expense e = expense.builder().particular(ex.getParticular()).date(ex.getDate()).item(ex.getItem())
					.rate(ex.getRate()).total(ex.getRate() * ex.getItem()).build();
		return er.save(e);
	}

	@Override
	public expense getExpense(@PathVariable int id) {
		return er.findById(id).get();
	}

	@Override
	public List<expense> getAllExpenses() {
		return er.findAll();
	}

	@Override
	public expense updateExpense(int id,expenseDTO ex) {
		expense e = er.findById(id).get();
		
		expense e1 = expense.builder().particular(ex.getParticular()).date(ex.getDate()).item(ex.getItem())
				.rate(ex.getRate()).total(ex.getRate() * ex.getItem()).build();
		
		e.setParticular(e1.getParticular());
		e.setDate(e1.getDate());
		e.setItem(e1.getItem());
		e.setRate(e1.getRate());
		e.setTotal(e1.getTotal());
		
		er.deleteById(id);
		return er.save(e1);
	}

	@Override
	public String deleteExpense(int id) {
		er.deleteById(id);
		return "Deleted Successfully.";
	}

	@Override
	public String deleteAllExpenses() {
		er.deleteAll(getAllExpenses());
		return "All Deleted Successfully.";
	}

}
