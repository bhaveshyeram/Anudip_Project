package com.example.expensemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expensemanager.entity.expense;

public interface expenseRepository extends JpaRepository<expense, Integer>{

	

}
