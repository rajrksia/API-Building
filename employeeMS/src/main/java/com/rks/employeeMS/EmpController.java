package com.rks.employeeMS;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmpController {
	
@Autowired
private EmpService empService;	

private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

//API endpoint to store employee details
@PostMapping("/emp")
public ResponseEntity<String> registerEmp(@RequestBody Employee employee)
{
	String empId="";
	//Validate the data and throw the errors on invalid data
	if (!empService.validateEmpData(employee)){
		return new ResponseEntity<>(empId, HttpStatus.BAD_REQUEST) ;
	}
		empId=empService.registerEmp(employee);
		//System.out.println("Employee Registration Successful. EmpID is : "+empId);
		return new ResponseEntity<>(empId, HttpStatus.CREATED) ;
}

//API endpoint to return employees tax deduction for the current financial year
@GetMapping("/employees/tax")
public ResponseEntity<List<EmployeeTax>> calculateTax()
{
	List<EmployeeTax> employeesTax;
	employeesTax = empService.calculateTax();
	return new ResponseEntity<>(employeesTax, HttpStatus.OK) ;
}




/*@GetMapping("/rolldice")
public String index(@RequestParam("player") Optional<String> player)
{
	logger.info("Microservice Rolling the Dice");
		int result = 1;
		try{
			result = this.getRandomNumber(1,6);
			logger.info("Rolled the Dice for "+result);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	return "Micro Service Returns : "+Integer.toString(result);
}
public int getRandomNumber(int min,int max)
{
	return ThreadLocalRandom.current().nextInt(min,max+1);
}*/

}