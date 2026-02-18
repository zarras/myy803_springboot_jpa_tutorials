package myy803.jpa.myy803_jpa_tutorial_0.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the domain logic
 */
public class StopTest {


    private Stop syntagma;

    @BeforeEach
    void setup(){

        syntagma = new Stop("Syntagma", 37.97569448870225, 23.73471989313159);

    }

    @Test
    void ensure_distance_from_self_is_zero(){

        Stop other = new Stop("Syntagma", 37.97569448870225, 23.73471989313159);
        double distance = syntagma.distanceFrom(other);

        assertEquals(0.0, distance);

    }

    @Test
    void ensure_distance_from_approximates_fairly(){

        Stop oaka = new Stop("OAKA", 38.03605314932543, 23.786941787128843);
        // ~ 8.14km
        double distance = oaka.distanceFrom(syntagma);

        assertTrue(distance > 8.1);
        assertTrue(distance < 8.2);
    }


}
