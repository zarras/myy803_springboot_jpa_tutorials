package myy803.jpa.myy803_jpa_tutorial_5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import myy803.jpa.myy803_jpa_tutorial_5.model.*;
import myy803.jpa.myy803_jpa_tutorial_5.repos.ActiveEmployeeRepository;
import myy803.jpa.myy803_jpa_tutorial_5.repos.EmployeeRepository;
import myy803.jpa.myy803_jpa_tutorial_5.repos.RetiredEmployeeRepository;


@SpringBootApplication
public class Myy803JpaTutorial5Application {
	public static void main(String[] args) {
		SpringApplication.run(Myy803JpaTutorial5Application.class, args);
	}

}
