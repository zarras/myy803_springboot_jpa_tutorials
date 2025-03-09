package myy803.jpa.myy803_jpa_tutorial_4.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "routes")
public class Route {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="driver_id")
	private Driver driver;
	
	// In general, CascadeType tells spring what to do with the references entities 
	// when a respective operation is called on a Route object
	// Since the relation with Service is many to one it is not correct 
	// to propagate remove operation to the Service object 
	@ManyToOne(fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="service_id")
	private Service service;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="route_id")
	private List<Stop> stops;
	
	public Route() {
		super();
		this.stops = new ArrayList<Stop>();
	}

	public Route(String name, Service service, Driver driver) {
		super();
		this.name = name;
		this.service = service;
		this.driver = driver;
		this.stops = new ArrayList<Stop>();
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

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public List<Stop> getStops() {
		return stops;
	}

	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}
	
	public void addStop(Stop stop) {
		stops.add(stop);
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", name=" + name + ", service=" + service + stops + "]";
	}
}
