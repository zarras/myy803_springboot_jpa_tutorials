package myy803.jpa.myy803_jpa_tutorial_4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import myy803.jpa.myy803_jpa_tutorial_4.model.*;
import myy803.jpa.myy803_jpa_tutorial_4.repos.RouteRepository;
import myy803.jpa.myy803_jpa_tutorial_4.repos.StopRepository;


@SpringBootApplication
public class Myy803JpaTutorial4Application {

	public static void main(String[] args) {
		SpringApplication.run(Myy803JpaTutorial4Application.class, args);
	}
}
