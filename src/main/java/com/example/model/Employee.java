package com.example.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;


import lombok.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
