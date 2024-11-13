package com.leasepluse.backend.controller;


import com.leasepluse.backend.model.Employee;
import com.leasepluse.backend.service.SalaryPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SalaryCalculatorController {

    private final SalaryPackageService salaryPackageService;

    @Autowired
    public SalaryCalculatorController(SalaryPackageService salaryPackageService) {
        this.salaryPackageService = salaryPackageService;
    }

    @PostMapping("/calculate")
    public double calculateSalaryPackage(@RequestBody Employee employee) {
        return salaryPackageService.calculateLimit(employee);
    }
}

