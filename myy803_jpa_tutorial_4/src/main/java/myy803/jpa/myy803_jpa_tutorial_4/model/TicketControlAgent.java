package myy803.jpa.myy803_jpa_tutorial_4.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_control_agents")
public class TicketControlAgent {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "ticketControlAgents")
	private List<Stop> assignedStops;
	
	public TicketControlAgent() {
		super();
	}

	public TicketControlAgent(String name, List<Stop> assignedStops) {
		super();
		this.name = name;
		this.assignedStops = assignedStops;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Stop> getAssignedStops() {
		return assignedStops;
	}

	public void setAssignedStops(List<Stop> assignedStops) {
		this.assignedStops = assignedStops;
	}
	
}
