package myy803.jpa.myy803_jpa_tutorial_2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stop")
public class Stop {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "latitude")
	private double latitude;
	@Column(name = "longtitude")
	private double longtitude;
	
	public Stop() {
		super();
	}

	public Stop(int id, String name, double latitude, double longtitude) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return "Stop [id=" + id + ", name=" + name + ", latitude=" + latitude + ", longtitude=" + longtitude + "]";
	}
}
