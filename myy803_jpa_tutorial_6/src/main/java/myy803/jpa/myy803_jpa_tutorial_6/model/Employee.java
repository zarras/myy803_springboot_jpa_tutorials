package myy803.jpa.myy803_jpa_tutorial_6.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
   @Id
   @Column(name = "eid")
   private int eid;
  
   @Column(name = "name")
   private String name;

   public Employee() {
	   super();
   }
   
   public Employee(int eid, String name) {
	   super();
	   this.eid = eid;
	   this.name = name;
   }

   public int getEid() {
	   return eid;
   }

   public void setEid(int eid) {
	   this.eid = eid;
   }

   public String getName() {
	   return name;
   }

   public void setName(String name) {
	   this.name = name;
   }

   @Override
   public String toString() {
	   return "Employee [eid=" + eid + ", name=" + name + "]";
   }
}