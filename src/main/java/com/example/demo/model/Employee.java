package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
