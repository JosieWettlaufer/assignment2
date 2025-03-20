package com.assignment2.assignment2.service;

import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    public double calculateSalary(String designation) {
        //switch expression assigns salary based on designation
        return switch (designation) {
            case "Software Engineer" -> 60000;
            case "Senior Engineer" -> 80000;
            case "Tech Lead" -> 90000;
            case "Project Manager" -> 100000;
            case "Director" -> 125000;
            default -> 30000;
        };
    }
}
