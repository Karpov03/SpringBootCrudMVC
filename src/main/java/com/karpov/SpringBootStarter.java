package com.karpov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.karpov.commom.Employee;
import com.karpov.commom.EmployeeRepository;

@SpringBootApplication
public class SpringBootStarter implements CommandLineRunner {
	
	@Autowired
	EmployeeRepository empr;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarter.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		Employee emp1=new Employee("Karpov", "Karpov@gmail.com", "Karaikal", "9940444604");
		Employee emp2=new Employee("Gowri", "Gowri@gmail.com", "Tvm", "9787527337");
		Employee emp3=new Employee("Priya", "Priya@gmail.com", "Tvm", "9486380336");
		Employee emp4=new Employee("Arthi", "Arthi@gmail.com", "Arthi", "9787527336");
		
		empr.save(emp1);
		empr.save(emp2);
		empr.save(emp3);
		empr.save(emp4);
		
		
		
	}

}
