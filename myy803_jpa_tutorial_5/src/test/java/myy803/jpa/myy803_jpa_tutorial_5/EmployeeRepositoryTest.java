package myy803.jpa.myy803_jpa_tutorial_5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import myy803.jpa.myy803_jpa_tutorial_5.model.ActiveEmployee;
import myy803.jpa.myy803_jpa_tutorial_5.model.Employee;
import myy803.jpa.myy803_jpa_tutorial_5.model.RetiredEmployee;
import myy803.jpa.myy803_jpa_tutorial_5.repos.EmployeeRepository;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void shouldSaveActiveEmployee() {
        ActiveEmployee emp = new ActiveEmployee(1, "John", 5000);

        Employee saved = employeeRepository.save(emp);

        assertThat(saved).isNotNull();
        assertThat(saved.getEid()).isEqualTo(1);
        assertThat(saved).isInstanceOf(ActiveEmployee.class);
    }

    @Test
    void shouldSaveRetiredEmployee() {
        RetiredEmployee emp = new RetiredEmployee(2, "Mike", 2000);

        Employee saved = employeeRepository.save(emp);

        assertThat(saved).isNotNull();
        assertThat(saved.getEid()).isEqualTo(2);
        assertThat(saved).isInstanceOf(RetiredEmployee.class);
    }

    @Test
    void shouldFindEmployeeById() {
        ActiveEmployee emp = new ActiveEmployee(3, "Anna", 6000);
        employeeRepository.save(emp);

        Optional<Employee> found = employeeRepository.findById(3);

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Anna");
        assertThat(found.get()).isInstanceOf(ActiveEmployee.class);
    }

    @Test
    void shouldFindAllEmployees() {
        ActiveEmployee active = new ActiveEmployee(4, "Chris", 7000);
        RetiredEmployee retired = new RetiredEmployee(5, "George", 2500);

        employeeRepository.save(active);
        employeeRepository.save(retired);

        List<Employee> employees = employeeRepository.findAll();

        assertThat(employees).hasSize(2);
    }

    @Test
    void shouldDeleteEmployee() {
        ActiveEmployee emp = new ActiveEmployee(6, "Nick", 8000);
        employeeRepository.save(emp);

        employeeRepository.deleteById(6);

        Optional<Employee> deleted = employeeRepository.findById(6);

        assertThat(deleted).isEmpty();
    }
}
