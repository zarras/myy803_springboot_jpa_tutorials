package myy803.jpa.myy803_jpa_tutorial_5.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myy803.jpa.myy803_jpa_tutorial_5.model.RetiredEmployee;


@Repository
public interface RetiredEmployeeRepository extends JpaRepository<RetiredEmployee, Integer> {
}
