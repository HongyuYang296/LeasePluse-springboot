package com.leasepluse.backend.model;

import lombok.Data;

@Data
public class Employee {
    private String companyType;
    private String employmentType;
    private double salary;
    private int hoursWorked; // Only for part-time
    private boolean educated;
}
