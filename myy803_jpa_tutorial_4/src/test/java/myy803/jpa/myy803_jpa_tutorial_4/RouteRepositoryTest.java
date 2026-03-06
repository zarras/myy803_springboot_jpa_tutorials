package myy803.jpa.myy803_jpa_tutorial_4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import myy803.jpa.myy803_jpa_tutorial_4.model.*;
import myy803.jpa.myy803_jpa_tutorial_4.repos.DriverRepository;
import myy803.jpa.myy803_jpa_tutorial_4.repos.RouteRepository;
import myy803.jpa.myy803_jpa_tutorial_4.repos.ServiceRepository;
import myy803.jpa.myy803_jpa_tutorial_4.repos.StopRepository;

@DataJpaTest
class RouteRepositoryTest {

    @Autowired
    private RouteRepository routeRepository;
    
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private StopRepository stopRepository;

    @Test
    void shouldSaveRouteWithDriverServiceAndStops() {

        Service service = new Service();
        service.setName("City Bus");

        Driver driver = new Driver();
        driver.setName("John");

        Route route = new Route("Route A", service, driver);

        Stop stop1 = new Stop();
        stop1.setName("Stop 1");

        Stop stop2 = new Stop();
        stop2.setName("Stop 2");

        route.addStop(stop1);
        route.addStop(stop2);

        Route savedRoute = routeRepository.save(route);

        assertThat(savedRoute.getId()).isGreaterThan(0);
        assertThat(savedRoute.getStops()).hasSize(2);
        assertThat(savedRoute.getDriver()).isNotNull();
        assertThat(savedRoute.getService()).isNotNull();
    }

    @Test
    void shouldFindRouteByName() {

        Service service = new Service();
        service.setName("Metro");

        Driver driver = new Driver();
        driver.setName("Alice");

        Route route = new Route("Route B", service, driver);

        routeRepository.save(route);

        List<Route> result = routeRepository.findByName("Route B");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("Route B");
    }

    @Test
    void shouldDeleteRoute() {

        Service service = new Service();
        service.setName("Intercity");

        Driver driver = new Driver();
        driver.setName("Mike");

        Route route = new Route("Route C", service, driver);

        Route saved = routeRepository.save(route);

        routeRepository.delete(saved);

        Route result = routeRepository.findById(saved.getId());

        assertNull(result);
    }
    
    @Test
    void shouldCascadePersistDriverAndService() {

        Service service = new Service();
        service.setName("Bus Service");

        Driver driver = new Driver();
        driver.setName("John");

        Route route = new Route("Route A", service, driver);

        Route saved = routeRepository.save(route);

        assertThat(saved.getId()).isGreaterThan(0);
        assertThat(saved.getDriver().getId()).isGreaterThan(0);
        assertThat(saved.getService().getId()).isGreaterThan(0);
    }
    
    @Test
    void shouldCascadePersistStops() {

        Service service = new Service();
        service.setName("City");

        Driver driver = new Driver();
        driver.setName("Alex");

        Route route = new Route("Route B", service, driver);

        Stop stop1 = new Stop();
        stop1.setName("Station 1");

        Stop stop2 = new Stop();
        stop2.setName("Station 2");

        route.addStop(stop1);
        route.addStop(stop2);

        Route saved = routeRepository.save(route);

        assertThat(saved.getStops()).hasSize(2);
        assertThat(saved.getStops().get(0).getId()).isGreaterThan(0);
    }
    
    @Test
    void shouldCascadeDeleteDriverAndStopsButNotService() {

        Service service = new Service();
        service.setName("Regional");

        Driver driver = new Driver();
        driver.setName("Tom");

        Route route = new Route("Route C", service, driver);

        Stop stop = new Stop();
        stop.setName("Central");

        route.addStop(stop);

        Route saved = routeRepository.save(route);

        int driverId = saved.getDriver().getId();
        int serviceId = saved.getService().getId();
        int stopId = saved.getStops().get(0).getId();

        routeRepository.delete(saved);

        boolean driverExists = driverRepository.existsById(driverId);
        boolean stopExists = stopRepository.existsById(stopId);
        boolean serviceExists = serviceRepository.existsById(serviceId);

        assertThat(driverExists).isFalse();   // cascaded delete
        assertThat(stopExists).isFalse();     // cascaded delete
        assertThat(serviceExists).isTrue();   // should NOT be deleted
    }  
}