package myy803.jpa.myy803_jpa_tutorial_7;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import myy803.jpa.myy803_jpa_tutorial_7.model.*;
import myy803.jpa.myy803_jpa_tutorial_7.repos.ActiveEmployeeRepository;
import myy803.jpa.myy803_jpa_tutorial_7.repos.RetiredEmployeeRepository;


@SpringBootApplication
public class Myy803JpaTutorial7Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Myy803JpaTutorial7Application.class, args);
	}
}
