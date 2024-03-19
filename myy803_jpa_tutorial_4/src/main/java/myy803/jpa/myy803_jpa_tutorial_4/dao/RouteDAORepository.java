package myy803.jpa.myy803_jpa_tutorial_4.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myy803.jpa.myy803_jpa_tutorial_4.model.Route;
import myy803.jpa.myy803_jpa_tutorial_4.model.Stop;

@Repository
public interface RouteDAORepository extends JpaRepository<Route, Integer> {
	Route findById(int id);
	List<Route> findByName(String name);
}
