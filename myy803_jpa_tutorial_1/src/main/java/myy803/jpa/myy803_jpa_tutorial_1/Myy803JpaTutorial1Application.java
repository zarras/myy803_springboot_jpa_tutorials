package myy803.jpa.myy803_jpa_tutorial_1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import myy803.jpa.myy803_jpa_tutorial_1.dao.RouteDAORepository;
import myy803.jpa.myy803_jpa_tutorial_1.model.*;


// To create a simple command line springboot application have to implement CommandLineRunner 
@SpringBootApplication
public class Myy803JpaTutorial1Application implements CommandLineRunner {
	
	@Autowired
	private RouteDAORepository routeDAORepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Myy803JpaTutorial1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Creating Routes");
		Route routeA = new Route("RouteA", new Service("ServiceA"));
		
		routeA.addStop(new Stop("StopA", 0, 0));
		routeA.addStop(new Stop("StopB", 100, 50));
		routeA.addStop(new Stop("StopC", 78, 500));
		
		
		Route routeB = new Route("RouteB", new Service("ServiceB"));
		
		routeB.addStop(new Stop("StopD", 0, 0));
		routeB.addStop(new Stop("StopE", 100, 50));
		routeB.addStop(new Stop("StopF", 78, 500));
		
		System.out.println("\n\nSaving Routes");
		routeDAORepository.save(routeA);
		routeDAORepository.save(routeB);

		System.out.println("\n\nFinding Routes by id");
		Route route = routeDAORepository.findById(1);
		if (route != null)
			System.out.println("Found route: " + route.toString());
		else
			System.out.println("Required route not found");
		
		System.out.println("\n\nFinding Routes by name");
		List<Route> someRoutes = 	routeDAORepository.findByName("RouteA");
		for(Route foundRoute : someRoutes)
			System.out.println("Found route: " + foundRoute.toString());

		System.out.println("\n\nFinding all Routes");

		List<Route> allRoutes = routeDAORepository.findAll();
		for(Route foundRoute : allRoutes) {
			System.out.println("Found route: " + foundRoute.toString());
			//System.out.println("Number of stops: " + foundRoute.getStops().size());
		}

		System.out.println("\n\nAll Done!!");

		//logger.info("All Done !!");
	}

}
