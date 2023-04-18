package com.example.expensemanager.DTO;

import java.sql.Date;

import javax.persistence.Entity;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.expensemanager.entity.expense;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class expenseDTO {
	
	@NotNull(message = "particular must not be null.")
	@NotBlank(message = "particular should not be blank.")
	@Size(min = 2, max = 25, message = "Size of particular must be between 2-25.")
	String particular;
	
	@NotNull(message = "Date can't be null.")
	Date date;
	
	@Digits(fraction = 0,integer = 4)
	@DecimalMax(value="9999.00")
	@DecimalMin(value="0.00")
	int item;
	
	@Digits(fraction = 0,integer = 5)
	@DecimalMax(value="99999.00")
	@DecimalMin(value="0.00")
	int rate;
	
//	@Digits(fraction = 0,integer = 10)
//	@DecimalMax(value="9999999999.00")
//	@DecimalMin(value="0.00")
//	int total;
}
