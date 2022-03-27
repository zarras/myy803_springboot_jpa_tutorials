package myy803.jpa.myy803_jpa_tutorial_2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import myy803.jpa.myy803_jpa_tutorial_2.dao.RouteDAORepository;
import myy803.jpa.myy803_jpa_tutorial_2.dao.ServiceDAORepository;
import myy803.jpa.myy803_jpa_tutorial_2.model.*;


// To create a simple command line springboot application have to implement CommandLineRunner 
@SpringBootApplication
public class Myy803JpaTutorial2Application implements CommandLineRunner {
	
	@Autowired
	private RouteDAORepository routeDAORepository;
	
	@Autowired
	private ServiceDAORepository serviceDAORepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Myy803JpaTutorial2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		routeDAORepository.deleteAll();
		
		System.out.println("Creating Routes");
		
		Service serviceA = new Service(1, "ServiceA");
		
		Route routeA = new Route(1, "RouteA", serviceA);
		
		routeA.addStop(new Stop(1, "StopA", 0, 0));
		routeA.addStop(new Stop(2, "StopB", 100, 50));
		routeA.addStop(new Stop(3, "StopC", 78, 500));
		
		
		Service serviceB = new Service(2, "ServiceB");
		Route routeB = new Route(2, "RouteB", serviceB);
		
		routeB.addStop(new Stop(4, "StopD", 0, 0));
		routeB.addStop(new Stop(5, "StopE", 100, 50));
		routeB.addStop(new Stop(6, "StopF", 78, 500));
		
		//serviceDAORepository.save(serviceA);
		//serviceDAORepository.save(serviceB);

		System.out.println("\n\nSaving Routes");
		routeDAORepository.save(routeA);
		routeDAORepository.save(routeB);

		System.out.println("\n\nFinding all Routes");

		List<Route> allRoutes = routeDAORepository.findAll();
		for(Route foundRoute : allRoutes) {
			System.out.println("Found route: " + foundRoute.toString());
			//System.out.println("Number of stops: " + foundRoute.getStops().size());
		}

		System.out.println("\n\nFinding Routes by id");
		Route route = routeDAORepository.findById(1);
		if (route != null) {
			System.out.println("Found route: " + route.toString());
			
			System.out.println("Adding one more route: " + route.toString());
			Route routeC = new Route(3, "RouteC", route.getService());
			
			routeC.addStop(new Stop(7, "StopD", 0, 0));
			routeC.addStop(new Stop(8, "StopE", 100, 50));
			routeC.addStop(new Stop(9, "StopF", 78, 500));
			
			System.out.println("\n\nSaving Extra Route");
			routeDAORepository.save(routeC);			
		} else
			System.out.println("Required route not found");
		
		//routeDAORepository.deleteAll();
		

		//serviceDAORepository.delete(serviceA);
		// serviceDAORepository.delete(serviceB);

		
		System.out.println("\n\nAll Done!!");

		//logger.info("All Done !!");
	}

}
