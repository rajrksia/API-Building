package com.rks.employeeMS;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDB {

	public static List<Employee> employeeList =new ArrayList<Employee>();
	
	public static void storeEmpToDB(Employee employee)
	{	
		employeeList.add(employee);
	}
	public static List<Employee> getEmployeeData()
	{		
		return employeeList;
	}
	
	

	
}