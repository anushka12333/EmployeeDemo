package com.example.demo.service;


import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class BonusService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public List<Employee> getEligibleEmployees(LocalDate date) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getJoiningDate().isBefore(date) &&
                        (employee.getExitDate() == null || employee.getExitDate().isAfter(date)))
                .collect(Collectors.toList());
    }
}