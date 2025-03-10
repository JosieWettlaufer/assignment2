package com.assignment2.assignment2.controller;

import com.assignment2.assignment2.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class employeeController {

    @GetMapping("/Employee")
    public String index() {
        return "index";
    }

    @PostMapping("/processform")
    public String processForm(@RequestParam("Employee") Employee employee, Model model) {

        model.addAttribute("designation", employee.getDesignation);

        // SET UP CRUD OPERATIONS
        model.addAttribute("selectedDepartments", employee.getDepartment());

        //Get designation from form
        String theDesignation = employee.getDesignation();

        //declare salary variable (String to avoid unnecessary type conversions)
        String strSalary = switch (theDesignation) {
            //match salary based on designation
            case "Manager" -> "60000";
            case "Team Lead" -> "45000";
            case "Developer" -> "50000";
            case "Designer" -> "30000";
            case "Analyst" -> "100000";
            default -> "";
        };

        //add salary to model
        model.addAttribute("salary", strSalary);

        //return view
        return "post";
    }

}
