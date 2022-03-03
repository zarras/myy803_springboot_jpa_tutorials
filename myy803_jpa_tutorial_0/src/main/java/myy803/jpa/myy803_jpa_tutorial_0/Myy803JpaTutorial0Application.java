package myy803.jpa.myy803_jpa_tutorial_0;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import myy803.jpa.myy803_jpa_tutorial_0.dao.StopDAORepository;
import myy803.jpa.myy803_jpa_tutorial_0.model.Stop;


// To create a simple command line springboot application have to implement CommandLineRunner 
@SpringBootApplication
public class Myy803JpaTutorial0Application implements CommandLineRunner {
	
	@Autowired
	private StopDAORepository stopDAORepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Myy803JpaTutorial0Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			
		//stopDAORepository.deleteAll();
		
		System.out.println("Creating Stops");
		Stop stop1 = new Stop("Stop1", 1000.0, 200.0);
		Stop stop2 = new Stop("Stop2", 3000.0, 250.0);
		Stop stop3 = new Stop("Stop3", 4000.0, 260.0);
		Stop stop4 = new Stop("Stop4", 4000.0, 260.0);

		System.out.println("\n\nSaving Stops");
		stopDAORepository.save(stop1);
		stopDAORepository.save(stop2);
		stopDAORepository.save(stop3);
		stopDAORepository.save(stop4);

		System.out.println("\n\nFinding Stops by id");
		Stop stop = stopDAORepository.findById(17);
		if (stop != null)
			System.out.println("Found stop: " + stop.toString());
		else
			System.out.println("Required stop not found");
		
		System.out.println("\n\nFinding Stops by latitude");
		List<Stop> someStops = 	stopDAORepository.findByLatitude(4000);
		for(Stop foundStop : someStops)
			System.out.println("Found stop: " + foundStop.toString());

		System.out.println("\n\nFinding all Stops");

		List<Stop> allStops = stopDAORepository.findAll();
		for(Stop foundStop : allStops)
			System.out.println("Found stop: " + foundStop.toString());

		System.out.println("\n\nAll Done!!");

		//logger.info("All Done !!");
	}

}
