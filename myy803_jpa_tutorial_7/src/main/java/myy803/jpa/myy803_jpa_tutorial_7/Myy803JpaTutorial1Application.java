package myy803.jpa.myy803_jpa_tutorial_7;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import myy803.jpa.myy803_jpa_tutorial_7.dao.ActiveEmployeeRepository;
import myy803.jpa.myy803_jpa_tutorial_7.dao.RetiredEmployeeRepository;
import myy803.jpa.myy803_jpa_tutorial_7.model.*;


// To create a simple command line springboot application have to implement CommandLineRunner 
@SpringBootApplication
public class Myy803JpaTutorial1Application implements CommandLineRunner {
	@Autowired
	private ActiveEmployeeRepository actEmployeeRepository;
	
	@Autowired
	private RetiredEmployeeRepository retEmployeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Myy803JpaTutorial1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Creating Employees");
		ActiveEmployee activeEmployee = new ActiveEmployee(10, "Kokos", 1000);
		RetiredEmployee retiredEmployee = new RetiredEmployee(20, "Popos", 500);

		System.out.println("\n\nFinding Employees");
		
		List<ActiveEmployee> activeEmployees = actEmployeeRepository.findAll();

		for(Employee employee : activeEmployees)
			System.out.println(employee.toString());
		
		List<RetiredEmployee> retiredEmployees = retEmployeeRepository.findAll();

		for(Employee employee : retiredEmployees)
			System.out.println(employee.toString());
		
		System.out.println("\n\nAll Done!!");
	}

}
