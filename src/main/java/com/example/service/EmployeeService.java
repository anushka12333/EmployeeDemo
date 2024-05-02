package com.example.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(List<Employee> employee){
        employeeRepository.saveAll(employee);
    }
    public List<Employee> getEligiblEmployees(LocalDate date){
        LocalDate startDate = date.minusYears(1);
        LocalDate endDate= date;
        return employeeRepository.findAllByJoiningDateBeforeAndExitDateAfter(startDate, endDate);
    }

}
