package com.rks.employeeMS;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;


//@Entity
//@Table(name="t_employee_det") 
public class Employee {

private static final long serialVersionUID = 45787358592745823L;

//@Column(name="emp_id")
private String empID;
//@Column(name="first_name")
private String firstName;
//@Column(name="last_name")
private String lastName;
//@Column(name="email")
private String email;
//@Column(name="phone_number")
private String phoneNumber;
//@Column(name="doj")
private String doj;
//@Column(name="salary")
private Double salary;

public Employee()
{
	super();
}
public Employee(String empID,String firstName,String lastName, String email, String phoneNumber, String doj, Double salary)
{
	super();
	this.empID=empID;
	this.firstName=firstName;
	this.lastName=lastName;
	this.email=email;
	this.phoneNumber=phoneNumber;
	this.doj=doj;
	this.salary=salary;
}


public String getEmpID(){return empID;}
public void setEmpID(String empID){this.empID=empID;}

public String getFirstName(){return firstName;}
public void setFirstName(String firstName){this.firstName=firstName;}

public String getLastName(){return lastName;}
public void setLastName(String lastName){this.lastName=lastName;}

public String getEmail(){return email;}
public void setEmail(String email){this.email=email;}

public String getPhoneNumber(){return phoneNumber;}
public void setPhoneNumber(String phoneNumber){this.phoneNumber=phoneNumber;}

public String getDoj(){return doj;}
public void setDoj(String doj){this.doj=doj;}

public Double getSalary(){return salary;}
public void setSalary(Double salary){this.salary=salary;}

public String toString(){
	return "EmployeeDB[empID="+empID+",firstName="+firstName+",lastName="+lastName+",email="+email+",phoneNumber="+phoneNumber+",doj="+doj+",salary="+salary+"]";
}
}