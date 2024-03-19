package com.rks.employeeMS;

import java.util.List;

public interface EmpService {

public String registerEmp(Employee employee);
public Boolean validateEmpData(Employee employee);
public List<EmployeeTax> calculateTax();
}