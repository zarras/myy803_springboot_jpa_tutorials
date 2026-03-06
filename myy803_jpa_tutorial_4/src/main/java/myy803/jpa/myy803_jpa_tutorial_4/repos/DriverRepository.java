package myy803.jpa.myy803_jpa_tutorial_4.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myy803.jpa.myy803_jpa_tutorial_4.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
	Driver findById(int id);
}
