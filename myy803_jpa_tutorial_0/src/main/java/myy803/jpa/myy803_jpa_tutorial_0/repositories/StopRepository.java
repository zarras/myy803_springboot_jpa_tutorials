package myy803.jpa.myy803_jpa_tutorial_0.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myy803.jpa.myy803_jpa_tutorial_0.model.Stop;

@Repository
public interface StopRepository extends JpaRepository<Stop, Integer> {
	
	Stop findById(int id);
	// findAll(), count(), delete(), save(), .... derived from base interface
	// https://www.tutorialspoint.com/spring_boot_jpa/spring_boot_jpa_repository_methods.htm
	
	Stop findByName(String name);

    List<Stop> findByNameContaining(String keyword);

    List<Stop> findByLatitudeGreaterThan(double latitude);

    List<Stop> findByLatitudeBetween(double start, double end);

    List<Stop> findByLatitudeGreaterThanAndLongtitudeLessThan(double lat, double lon);

    List<Stop> findByNameOrderByLatitudeAsc(String name);
}
