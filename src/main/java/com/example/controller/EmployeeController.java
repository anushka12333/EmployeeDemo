package com.example.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/tci")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee-bonus")
    public ResponseEntity<String> saveEmployees(@RequestBody List<Employee> employee){
      employeeService.saveEmployee(employee);
      return ResponseEntity.ok("Employee saved successfully");
    }

    @GetMapping("/employee-bonus")   
    public ResponseEntity<Map<String, List<Map<String,Object>>>> getEligibleEmployees(@RequestParam("date") @DateTimeFormat (pattern = "MM-DD-YYYY") LocalDate date){
         List<Employee> eligibleEmployees= employeeService.getEligiblEmployees(date);
         Map<String,List<Map<String,Object>>> response= new HashMap<>();
         
          eligibleEmployees.forEach(employee -> {
        response.computeIfAbsent(employee.getCurrency(), k-> new ArrayList<>()).add(Map.of("empName",employee.getEmpName(),"amount",employee.getAmount()));
         });
         return ResponseEntity.ok(response);
    
    }


    

}
