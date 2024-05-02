package com.example.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findAllByJoiningDateBeforeAndExitDateAfter(LocalDate date1,LocalDate date2);
}
