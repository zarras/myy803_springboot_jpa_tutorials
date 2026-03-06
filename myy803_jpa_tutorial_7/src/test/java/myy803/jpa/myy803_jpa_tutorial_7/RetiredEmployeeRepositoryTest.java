package myy803.jpa.myy803_jpa_tutorial_7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import myy803.jpa.myy803_jpa_tutorial_7.model.RetiredEmployee;
import myy803.jpa.myy803_jpa_tutorial_7.repos.RetiredEmployeeRepository;

@DataJpaTest
class RetiredEmployeeRepositoryTest {

    @Autowired
    private RetiredEmployeeRepository retiredEmployeeRepository;

    @Test
    void shouldSaveRetiredEmployee() {
        RetiredEmployee employee = new RetiredEmployee(10, "George", 2000);

        RetiredEmployee saved = retiredEmployeeRepository.save(employee);

        assertThat(saved).isNotNull();
        assertThat(saved.getEid()).isEqualTo(10);
        assertThat(saved.getName()).isEqualTo("George");
        assertThat(saved.getPension()).isEqualTo(2000);
    }

    @Test
    void shouldFindRetiredEmployeeById() {
        RetiredEmployee employee = new RetiredEmployee(11, "Helen", 1800);
        retiredEmployeeRepository.save(employee);

        Optional<RetiredEmployee> found = retiredEmployeeRepository.findById(11);

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Helen");
        assertThat(found.get().getPension()).isEqualTo(1800);
    }

    @Test
    void shouldFindAllRetiredEmployees() {
        RetiredEmployee r1 = new RetiredEmployee(12, "Bob", 1500);
        RetiredEmployee r2 = new RetiredEmployee(13, "Alice", 2200);

        retiredEmployeeRepository.save(r1);
        retiredEmployeeRepository.save(r2);

        List<RetiredEmployee> employees = retiredEmployeeRepository.findAll();

        assertThat(employees).hasSize(2);
    }

    @Test
    void shouldDeleteRetiredEmployee() {
        RetiredEmployee employee = new RetiredEmployee(14, "Tom", 1700);
        retiredEmployeeRepository.save(employee);

        retiredEmployeeRepository.deleteById(14);

        Optional<RetiredEmployee> deleted = retiredEmployeeRepository.findById(14);

        assertThat(deleted).isEmpty();
    }
}
