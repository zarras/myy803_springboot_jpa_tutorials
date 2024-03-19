package myy803.jpa.myy803_jpa_tutorial_7.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myy803.jpa.myy803_jpa_tutorial_7.model.ActiveEmployee;


@Repository
public interface ActiveEmployeeRepository extends JpaRepository<ActiveEmployee, Integer> {
}
