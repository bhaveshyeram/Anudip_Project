package com.example.expensemanager.entity;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class expense {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String particular;
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date date;
	private int item;
	private int rate;
	private int total;
	
}
