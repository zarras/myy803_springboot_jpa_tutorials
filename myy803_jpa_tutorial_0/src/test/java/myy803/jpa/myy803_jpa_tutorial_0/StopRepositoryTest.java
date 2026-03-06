package myy803.jpa.myy803_jpa_tutorial_0;

//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.jdbc.Sql;
//
//import myy803.jpa.myy803_jpa_tutorial_0.model.Stop;
//import myy803.jpa.myy803_jpa_tutorial_0.repositories.StopRepository;
//
//@SpringBootTest
//@TestPropertySource(
//		  locations = "classpath:test.properties")
//class StopRepositoryTest {
//	
//	@Autowired
//    private StopRepository stopRepository;
//
//	@Test
//	void shouldSaveStop() {
//		Stop stop = new Stop("Central Station", 40.6401, 22.9444);
//
//	    Stop saved = stopRepository.save(stop);
//
//	    assertThat(saved.getId()).isGreaterThan(0);
//	    assertThat(saved.getName()).isEqualTo("Central Station");
//	}
//}



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import myy803.jpa.myy803_jpa_tutorial_0.model.Stop;
import myy803.jpa.myy803_jpa_tutorial_0.repositories.StopRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@SpringBootTest
//@TestPropertySource(
//		  locations = "classpath:test2.properties")
@DataJpaTest
class StopRepositoryTest {

    @Autowired
    private StopRepository stopRepository;

    @BeforeEach
    void setUp() {
        stopRepository.save(new Stop("Athens Center", 37.9838, 23.7275));
        stopRepository.save(new Stop("Thessaloniki Port", 40.6401, 22.9444));
        stopRepository.save(new Stop("Patra Station", 38.2466, 21.7346));
        stopRepository.save(new Stop("Athens Airport", 37.9364, 23.9475));
    }

    @Test
    void shouldFindByName() {
        Stop stop = stopRepository.findByName("Athens Center");

        assertNotNull(stop);
        assertThat(stop.getLatitude()).isEqualTo(37.9838);
    }

    @Test
    void shouldFindByNameContaining() {
        List<Stop> stops = stopRepository.findByNameContaining("Athens");

        assertThat(stops).hasSize(2);
    }

    @Test
    void shouldFindByLatitudeGreaterThan() {
        List<Stop> stops = stopRepository.findByLatitudeGreaterThan(39.0);

        assertThat(stops).hasSize(1);
        assertThat(stops.get(0).getName()).isEqualTo("Thessaloniki Port");
    }

    @Test
    void shouldFindByLatitudeBetween() {
        List<Stop> stops = stopRepository.findByLatitudeBetween(37.9, 38.3);

        assertThat(stops).hasSize(3);
    }

    @Test
    void shouldFindByLatitudeGreaterThanAndLongtitudeLessThan() {
        List<Stop> stops =
                stopRepository.findByLatitudeGreaterThanAndLongtitudeLessThan(38.0, 23.0);

        assertThat(stops).hasSize(2);
    }

    @Test
    void shouldFindByNameOrderedByLatitude() {
        stopRepository.save(new Stop("Athens Center", 36.0000, 22.0000));

        List<Stop> stops =
                stopRepository.findByNameOrderByLatitudeAsc("Athens Center");

        assertThat(stops).hasSize(2);
        assertThat(stops.get(0).getLatitude()).isLessThan(stops.get(1).getLatitude());
    }
}
