package com.example.expensemanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.expensemanager.DTO.expenseDTO;
import com.example.expensemanager.entity.expense;
import com.example.expensemanager.service.service;

@RestController
@CrossOrigin
public class expenseController {
	
	@Autowired
	service ei;
	
	@PostMapping("/expense")
	public ResponseEntity<expense> createExpense(@RequestBody @Valid expenseDTO ed)
	{	
		expense e = ei.createExpense(ed);
		
		if(e!=null)
			return new ResponseEntity<expense>(e, HttpStatus.CREATED);
		return new ResponseEntity<expense>(e, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/expense/{id}")
	public ResponseEntity<expense> getExpense(@PathVariable int id)
	{
		try {
			expense e = ei.getExpense(id);
			if(e!=null)
				return new ResponseEntity<expense>(e, HttpStatus.OK);
		}catch(Exception e)
		{		
//	       throw new UserNotFoundException("user not found");
			e.printStackTrace();		}
		 return new ResponseEntity<expense>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/expenses")
	public ResponseEntity<List<expense>> getAllExpenses()
	{
		try {
			List<expense> elist=ei.getAllExpenses();
			if(elist!=null)
				return new ResponseEntity<List<expense>>(elist, HttpStatus.OK);
			}catch(Exception e)
			{		
		       e.printStackTrace();
			}
			 return new ResponseEntity<List<expense>>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/expense/{id}")
	public ResponseEntity<expense> updateExpense(@PathVariable("id") int id,@RequestBody @Valid expenseDTO ed)
	{
		expense e = ei.updateExpense(id, ed);
			if(e!=null)
				return new ResponseEntity<expense>(e, HttpStatus.OK);
			return new ResponseEntity<expense>(e, HttpStatus.BAD_REQUEST);

	}
	
	@DeleteMapping("/expense/{id}")
	public ResponseEntity<String> deleteExpense(@PathVariable("id") int id)
	{
		String e = ei.deleteExpense(id);
		if(e!=null)
			return new ResponseEntity<String>(e, HttpStatus.OK);
		return new ResponseEntity<String>(e, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("expenses")
	public ResponseEntity<String> deleteAllExpenses()
	{
		String e = ei.deleteAllExpenses();
		if(e!=null)
			return new ResponseEntity<String>(e, HttpStatus.OK);
		return new ResponseEntity<String>(e, HttpStatus.BAD_REQUEST);
	}
}

