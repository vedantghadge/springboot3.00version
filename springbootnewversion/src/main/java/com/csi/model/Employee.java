package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {


    @Id
    @GeneratedValue
    private int empId;

    @Size(min=2,message = "Employee Name Should be atleast 2 charactor ")
    private String empName;

    private String empAddress;

    private double empSalary;

    private long empContactNumber;


    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;

    @Email(message = "Email Id MUst Be VAlid")
    private String empEmailId;
}
