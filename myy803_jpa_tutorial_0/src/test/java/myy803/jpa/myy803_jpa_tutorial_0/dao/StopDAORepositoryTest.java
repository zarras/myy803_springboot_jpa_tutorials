package myy803.jpa.myy803_jpa_tutorial_0.dao;

import myy803.jpa.myy803_jpa_tutorial_0.model.Stop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
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


    @Test
    void findAll_returns_all_stops(){
        assertEquals(5, stopDAORepository.findAll().size());
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

    @Test
    void deny_saving_stops_with_same_name(){

        Stop stop = new Stop("OAKA", 10.0, 10.0);

        assertThrows(DataIntegrityViolationException.class, () -> {
                stopDAORepository.save(stop);
        });

    }

}
