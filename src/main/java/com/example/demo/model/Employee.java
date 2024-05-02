package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String empName;
    private String department;
    private int amount;
    private String currency;
    private LocalDate joiningDate;
    private LocalDate exitDate;
    @Override
    public String toString() {
        return "Employee [id=" + id + ", empName=" + empName + ", department=" + department + ", amount=" + amount
                + ", currency=" + currency + ", joiningDate=" + joiningDate + ", exitDate=" + exitDate + "]";
    }

    
}
