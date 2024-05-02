package com.example.controllerTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@WebMvcTest(EmployeeControllerTest.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

     @Autowired
    private EmployeeService employeeService;
    
    @Test
    public void testSaveEmployees() throws Exception{
        List<Employee> employees= Arrays.asList(new Employee(),new Employee());
        mockMvc.perform(MockMvcRequestBuilders.post("/tci/employee-bonus")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(employees))).andExpect(MockMvcResultMatchers.status().isOk());
        verify(employeeService,times(1)).saveEmployee(employees);
    }
    @Test
    public void testGetEligibleEmployee() throws Exception{
        LocalDate date = LocalDate.of(2022,5,27);
        List<Employee> eligibleEmployees= Arrays.asList(new Employee(),new Employee() );
      when(employeeService.getEligiblEmployees(date)).thenReturn(eligibleEmployees);
        mockMvc.perform(MockMvcRequestBuilders.get("/tci/employee-bonus?date=may-27-2022")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.jsonPath("$.data.length()").value(2));
    }
}
