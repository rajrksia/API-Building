package com.rks.employeeMS;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
//@Transactional
public class EmpServiceImpl implements EmpService {

//Storing data in EmployeeDB

	public String registerEmp(Employee employee)
	{
		EmployeeDB.storeEmpToDB(employee);
		//System.out.println("List of Emp:"+ EmployeeDB.getEmployeeData());
		
		return employee.getEmpID();
	}
	public Boolean validateEmpData(Employee employee)
	{
		//Do all employee data related validation
		//All Mandatory field values are received or not
		//DOJ is with proper date format or not : Prerequisite 'yyyy-mm-dd'
		//Fail in any condition, return false and throw respective error message.
		
		return true;
	}
	public List<EmployeeTax> calculateTax()
	{
		List<Employee> employees=EmployeeDB.getEmployeeData();
		List<EmployeeTax> employeesTax= new ArrayList<EmployeeTax>();
		for( Employee e : employees)
		{
			try
			{
			EmployeeTax et= new EmployeeTax();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
			String startDate="";
			startDate = (simpleDateFormat.parse(e.getDoj()).before(simpleDateFormat.parse("2023-04-01"))) ? "2023-04-01" : e.getDoj() ;
			Period diff = Period.between(LocalDate.parse(startDate), LocalDate.parse("2024-03-31"));
			System.out.println("Months :: "+diff.getMonths());
			et.setEmpID(e.getEmpID());et.setFirstName(e.getFirstName());et.setLastName(e.getLastName());et.setEmail(e.getEmail());
			et.setPhoneNumber(e.getPhoneNumber());et.setDoj(e.getDoj());et.setSalary(e.getSalary());
			Double totalIncome = diff.getMonths()*e.getSalary();
			et.setYearlySal(totalIncome); 
			et.setTaxAmt(totalIncome <= 250000 ? 0 : totalIncome<=500000 ? (0.05*(totalIncome-250000)) : totalIncome<=1000000 ? ((0.1*(totalIncome-500000))+(0.05*250000)) : (0.2*( totalIncome-1000000)+(0.1*500000)+(0.05*250000)));
			
			employeesTax.add(et);
			}catch(Exception ex){ex.printStackTrace();}
		}	
		//System.out.println("List of Employees with calculated Tax :"+ employeesTax);		
		return employeesTax;
	}
	

}