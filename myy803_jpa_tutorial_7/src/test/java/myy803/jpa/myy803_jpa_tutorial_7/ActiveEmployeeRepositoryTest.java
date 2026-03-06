package myy803.jpa.myy803_jpa_tutorial_7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import myy803.jpa.myy803_jpa_tutorial_7.model.ActiveEmployee;
import myy803.jpa.myy803_jpa_tutorial_7.repos.ActiveEmployeeRepository;

@DataJpaTest
class ActiveEmployeeRepositoryTest {

    @Autowired
    private ActiveEmployeeRepository activeEmployeeRepository;

    @Test
    void shouldSaveActiveEmployee() {
        ActiveEmployee employee = new ActiveEmployee(1, "John", 5000);

        ActiveEmployee saved = activeEmployeeRepository.save(employee);

        assertThat(saved).isNotNull();
        assertThat(saved.getEid()).isEqualTo(1);
        assertThat(saved.getName()).isEqualTo("John");
        assertThat(saved.getSalary()).isEqualTo(5000);
    }

    @Test
    void shouldFindActiveEmployeeById() {
        ActiveEmployee employee = new ActiveEmployee(2, "Anna", 6500);
        activeEmployeeRepository.save(employee);

        Optional<ActiveEmployee> found = activeEmployeeRepository.findById(2);

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Anna");
        assertThat(found.get().getSalary()).isEqualTo(6500);
    }

    @Test
    void shouldFindAllActiveEmployees() {
        ActiveEmployee e1 = new ActiveEmployee(3, "Mike", 4000);
        ActiveEmployee e2 = new ActiveEmployee(4, "Chris", 5500);

        activeEmployeeRepository.save(e1);
        activeEmployeeRepository.save(e2);

        List<ActiveEmployee> employees = activeEmployeeRepository.findAll();

        assertThat(employees).hasSize(2);
    }

    @Test
    void shouldDeleteActiveEmployee() {
        ActiveEmployee employee = new ActiveEmployee(5, "Nick", 7000);
        activeEmployeeRepository.save(employee);

        activeEmployeeRepository.deleteById(5);

        Optional<ActiveEmployee> deleted = activeEmployeeRepository.findById(5);

        assertThat(deleted).isEmpty();
    }
}
