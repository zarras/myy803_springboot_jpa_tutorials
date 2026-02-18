package myy803.jpa.myy803_jpa_tutorial_0.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stops")
public class Stop {

	public static final double EARTH_RADIUS = 6371;

	@Id
	@Column(name = "id")
	// With IDENΤITY generation is a responsibility of the DBMS, ids are unique at table level 
	// AUTO is another alternative for letting the framework JPA provider be in charge, by default all ids will be UNIQUE at db level
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;

	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "latitude")
	private double latitude;

	@Column(name = "longtitude")
	private double longtitude;
	
	public Stop() {
		super();
	}

	public Stop(String name, double latitude, double longtitude) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longtitude = longtitude;
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

	/**
	 * Implementation from https://www.baeldung.com/java-find-distance-between-points
	 * @param other
	 * @return
	 */
	public double distanceFrom(Stop other){
		double lat1Rad = Math.toRadians(latitude);
		double lat2Rad = Math.toRadians(other.latitude);
		double lon1Rad = Math.toRadians(longtitude);
		double lon2Rad = Math.toRadians(other.longtitude);

		double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
		double y = (lat2Rad - lat1Rad);
		double distance = Math.sqrt(x * x + y * y) * EARTH_RADIUS;

		return distance;
	}

	@Override
	public String toString() {
		return "Stop [id=" + id + ", name=" + name + ", latitude=" + latitude + ", longtitude=" + longtitude + "]";
	}
}
