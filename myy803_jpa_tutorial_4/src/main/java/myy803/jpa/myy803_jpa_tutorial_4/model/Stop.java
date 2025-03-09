package myy803.jpa.myy803_jpa_tutorial_4.model;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "stops")
public class Stop {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "longtitude")
	private double longtitude;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="route_id")
	private Route route;
	
	@ManyToMany(fetch = FetchType.EAGER, 
			cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "stops_agents",
            joinColumns = @JoinColumn(
                    name = "stop_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "agent_id", referencedColumnName = "id"
            )
    )
	private List<TicketControlAgent> ticketControlAgents;
	
	
	public Stop() {
		super();
	}

	public Stop(String name, double latitude, double longtitude, Route route) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.route = route;
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


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongtitude() {
		return longtitude;
	}


	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}


	public Route getRoute() {
		return route;
	}


	public void setRoute(Route route) {
		this.route = route;
	}


	public List<TicketControlAgent> getTicketControlAgents() {
		return ticketControlAgents;
	}

	public void setTicketControlAgents(List<TicketControlAgent> ticketControlAgents) {
		this.ticketControlAgents = ticketControlAgents;
	}

	@Override
	public String toString() {
		return "Stop [id=" + id + ", name=" + name + ", latitude=" + latitude + ", longtitude=" + longtitude + "]";
	}
}
