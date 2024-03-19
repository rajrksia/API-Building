package com.rks.employeeMS;

public class EmployeeTax extends Employee{

private static final long serialVersionUID = 45787358592745823L;

private Double yearlySal ;
private Double taxAmt;
private Double cessAmt;

public Double getYearlySal(){return yearlySal;}
public void setYearlySal(Double yearlySal){this.yearlySal=yearlySal;}

public Double getTaxAmt(){return taxAmt;}
public void setTaxAmt(Double taxAmt){this.taxAmt=taxAmt;}

public Double getCessAmt(){return cessAmt;}
public void setCessAmt(Double cessAmt){this.cessAmt=cessAmt;}

}