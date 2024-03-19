	
package com.rks.employeeMS;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.Period;

public class Test{	
	
	public static void main(String args[])
	{
		
	Period diff = Period.between(LocalDate.parse("2023-05-25"), LocalDate.parse("2024-03-31"));
    System.out.println("Months :: "+diff.getMonths());
	}
}	