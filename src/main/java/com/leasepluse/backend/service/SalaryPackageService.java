package com.leasepluse.backend.service;

import com.leasepluse.backend.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class SalaryPackageService {

    public double calculateLimit(Employee employee) {
        double limit;
        switch (employee.getCompanyType()) {
            case "Corporate":
                if (employee.getEmploymentType().equals("Casual")) {
                    limit = 0;
                } else {
                    if (employee.getSalary() <= 100000) {
                        limit = employee.getSalary() * 0.01;
                    } else {
                        limit = 1000 + (employee.getSalary() - 100000) * 0.001; // 1% of first 100,000 and 0.1% of the rest
                    }
                    if (employee.getEmploymentType().equals("Part-time")) {
                        limit *= (double) employee.getHoursWorked() / 38;
                    }
                }
                break;
            case "Hospital":
                limit = Math.max(10000, employee.getSalary() * 0.2);
                if (limit > 30000) limit = 30000; // Limit to 30000 max for 20%
                if (employee.isEducated()) {
                    limit += 5000;
                }
                if (employee.getEmploymentType().equals("Full-time")) {
                    limit *= 1.095; // Increase by 9.5%
                    limit += employee.getSalary() * 0.012; // Additional 1.2% of salary
                }
                break;
            case "PBI":
                double calculated = Math.min(50000, employee.getSalary() * 0.3255);
                if (employee.getEmploymentType().equals("Casual")) {
                    calculated = employee.getSalary() * 0.1;
                }
                limit = calculated;
                if (employee.isEducated()) {
                    limit += 2000 + employee.getSalary() * 0.01;
                }
                if (employee.getEmploymentType().equals("Part-time")) {
                    limit *= 0.8; // 80% for part-time
                }
                break;
            default:
                // Default case to handle unexpected company types
                limit = 0;
                break;
        }
        return limit;
    }
}
