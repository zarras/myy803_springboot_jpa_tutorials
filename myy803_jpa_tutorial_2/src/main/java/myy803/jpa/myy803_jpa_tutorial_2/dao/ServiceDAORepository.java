package myy803.jpa.myy803_jpa_tutorial_2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myy803.jpa.myy803_jpa_tutorial_2.model.Route;
import myy803.jpa.myy803_jpa_tutorial_2.model.Service;
import myy803.jpa.myy803_jpa_tutorial_2.model.Stop;

@Repository
public interface ServiceDAORepository extends JpaRepository<Service, Integer> {
	
}
