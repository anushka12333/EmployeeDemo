package com.example.demo.controllerTest;

 import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.BonusService;



@SpringBootTest
@WebMvcTest(EmployeeControllerTest.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

      @MockBean
    private EmployeeRepository employeeRepository;
    
    @MockBean
    private BonusService bonusService;
    
    @Test
    public void testStoreEmployees() throws Exception {
        // Mock the repository call
        when(employeeRepository.saveAll(anyList())).thenReturn(new ArrayList<>());
        
        // Perform POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/tci/employee-bonus")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"employees\": [{...}] }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Employees stored successfully"));
    }
    
    
    @Test
    public void testGetEligibleEmployees() throws Exception {
        // Mock the service call
        LocalDate date = LocalDate.of(2022, Month.MAY, 27);
        when(bonusService.getEligibleEmployees(date)).thenReturn(new ArrayList<>());
        
        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/tci/employee-bonus?date=may-27-2022"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}



