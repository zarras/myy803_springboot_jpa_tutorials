package myy803.jpa.myy803_jpa_tutorial_7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "retired_employees")
public class RetiredEmployee extends Employee {
	@Column(name = "pension")
	private double pension;
	
	public RetiredEmployee() {
		super();
	}

	public RetiredEmployee(int eid, String name, double pension) {
		super(eid, name);
		this.pension = pension;
	}

	public double getPension() {
		return pension;
	}

	public void setPension(double pension) {
		this.pension = pension;
	}

	@Override
	public String toString() {
		return super.toString() + "RetiredEmployee [pension=" + pension + "]";
	}
	
}
