package com.assignment2.assignment2.service;

import com.assignment2.assignment2.model.Salary;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    public Salary calculateSalary(String designation) {
        //switch expression assigns salary based on designation
        return switch (designation) {
            case "Software Engineer" -> new Salary(60000.0);
            case "Senior Engineer" -> new Salary(80000.0);
            case "Tech Lead" -> new Salary(90000.0);
            case "Project Manager" -> new Salary(100000.0);
            case "Director" -> new Salary(120000.0);
            default -> new Salary(0.0);
        };
    }
}
