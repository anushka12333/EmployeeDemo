package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BonusResponse;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.BonusService;





@RestController
@RequestMapping("/tci")
public class EmployeeController {
  @Autowired
   EmployeeRepository employeeRepository;

     @Autowired
    private BonusService bonusService;

    @PostMapping("/employee-bonus")
    public ResponseEntity<String> saveEmployees(@RequestBody List<Employee> employee){
      employeeRepository.saveAll(employee);
      return ResponseEntity.ok("Employee saved successfully");
    }

     @GetMapping("/employee-bonus")
    public ResponseEntity<List<BonusResponse>> getEligibleEmployees(@RequestParam("date") @DateTimeFormat(pattern = "MMM-dd-yyyy") LocalDate date) {
        List<Employee> eligibleEmployees = bonusService.getEligibleEmployees(date);
        List<BonusResponse> bonusResponses = new ArrayList<>();
        
        Map<String, List<Employee>> employeesByCurrency = eligibleEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getCurrency));
        
        for (Map.Entry<String, List<Employee>> entry : employeesByCurrency.entrySet()) {
            BonusResponse bonusResponse = new BonusResponse();
            bonusResponse.setCurrency(entry.getKey());
            bonusResponse.setEmployees(entry.getValue());
            bonusResponses.add(bonusResponse);
        }
        
        return ResponseEntity.ok(bonusResponses);
    }


    

}
