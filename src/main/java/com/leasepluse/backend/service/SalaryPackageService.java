package com.leasepluse.backend.service;


import com.leasepluse.backend.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class SalaryPackageService {

    public double calculateLimit(Employee employee) {
        // I will add the real logic here later stage
        // For demonstration, return a fixed value
        return 5000.0;
    }
}
