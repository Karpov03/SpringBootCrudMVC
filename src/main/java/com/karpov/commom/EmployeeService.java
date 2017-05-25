package com.karpov.commom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public  Iterable<Employee> getAllEmployees(){
    	
    	return employeeRepository.findAll();
    };

}
