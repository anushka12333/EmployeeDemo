package com.example.demo.model;

import java.util.List;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BonusResponse {
    private String currency;
    private List<Employee> employees;
    
}
