package myy803.jpa.myy803_jpa_tutorial_4.dao;

import myy803.jpa.myy803_jpa_tutorial_4.model.Stop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for queries and persistence logic
 */
@Sql(
        scripts = "/import.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
@DataJpaTest
public class StopDAORepositoryTest {

    @Autowired
    private StopDAORepository stopDAORepository;

    @Autowired
    private RouteDAORepository routeDAORepository;


    @Test
    void findAll_returns_all_stops(){
        assertEquals(7, stopDAORepository.findAll().size());
    }

    @Test
    void findById_returns_existing_stop(){
        Stop stop = stopDAORepository.findById(1);
        assertNotNull(stop);
    }

    @Test
    void findById_returns_null_on_non_existing_stop(){
        Stop stop = stopDAORepository.findById(10);
        assertNull(stop);
    }


}
