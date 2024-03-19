package myy803.jpa.myy803_jpa_tutorial_4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import myy803.jpa.myy803_jpa_tutorial_4.dao.RouteDAORepository;
import myy803.jpa.myy803_jpa_tutorial_4.dao.StopDAORepository;
import myy803.jpa.myy803_jpa_tutorial_4.model.*;


// To create a simple command line springboot application have to implement CommandLineRunner 
@SpringBootApplication
public class Myy803JpaTutorial1Application implements CommandLineRunner {
	
	@Autowired
	private RouteDAORepository routeDAORepository;
	@Autowired
	private StopDAORepository stopDAORepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Myy803JpaTutorial1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Creating Routes");
		Route routeA = new Route("RouteA", new Service("ServiceA"), new Driver("Driver name"));
		
		
		Stop stopA = new Stop("StopA", 0, 0, routeA);
		Stop stopB = new Stop("StopB", 100, 50, routeA);
		Stop stopC = new Stop("StopC", 78, 500, routeA);
		
		List<Stop> assignedStops = new ArrayList<Stop>();
		assignedStops.add(stopA); 
		assignedStops.add(stopB); 
		assignedStops.add(stopC); 

		TicketControlAgent agentA = new TicketControlAgent("AgentA", assignedStops);
		TicketControlAgent agentB = new TicketControlAgent("AgentB", assignedStops);

		List<TicketControlAgent> agents = new ArrayList<TicketControlAgent>();
		agents.add(agentA);
		agents.add(agentB);
		
		stopA.setTicketControlAgents(agents);
		stopB.setTicketControlAgents(agents);
		stopC.setTicketControlAgents(agents);

		routeA.addStop(stopA);
		routeA.addStop(stopB);
		routeA.addStop(stopC);
		
		
		System.out.println("\n\nSaving Routes");
		routeDAORepository.save(routeA);
//
		System.out.println("\n\nFinding Routes by id");
		Route route = routeDAORepository.findById(1);
		if (route != null)
			System.out.println("Found route: " + route.toString());
		else
			System.out.println("Required route not found");
		
		System.out.println("\n\nFinding Routes by name");
		List<Route> someRoutes = routeDAORepository.findByName("RouteA");
		for(Route foundRoute : someRoutes)
			System.out.println("Found route: " + foundRoute.toString());

		System.out.println("\n\nFinding all Routes");

		List<Route> allRoutes = routeDAORepository.findAll();
		for(Route foundRoute : allRoutes) {
			System.out.println("Found route: " + foundRoute.toString());
			System.out.println("Number of stops: " + foundRoute.getStops().size());
		}

		System.out.println("\n\nAll Done!!");
	}

}
