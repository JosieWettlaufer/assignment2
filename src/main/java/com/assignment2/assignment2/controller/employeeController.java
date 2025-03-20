package com.assignment2.assignment2.controller;

import com.assignment2.assignment2.model.Salary;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.assignment2.assignment2.model.Employee;
import com.assignment2.assignment2.service.DepartmentService;
import com.assignment2.assignment2.service.SalaryService;

@Controller
@RequestMapping("/employees")
public class employeeController {

    //Store Service instances
    private final SalaryService salaryService;
    private final DepartmentService departmentService;

    // Service constructor dependency injection
    public employeeController(SalaryService salaryService, DepartmentService departmentService) {
        this.salaryService = salaryService;
        this.departmentService = departmentService;
    }


    //Displays the employee registration form.
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

        // Add an empty employee object to bind form data
        model.addAttribute("employee", new Employee());

        // Fetch all departments and add them to the model
        model.addAttribute("departments", departmentService.getAllDepartments());

        // Fetch valid designations and add them to the model
        model.addAttribute("designations", Employee.getValidDesignations());

        return "employeeForm"; // Return the registration form view
    }


    //Handles form submission for employee registration.
    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute("employee") Employee employee,
                                      BindingResult result, Model model) {

        // If validation errors exist, return to form with necessary attributes
        if (result.hasErrors()) {
            model.addAttribute("departments", departmentService.getAllDepartments());
            model.addAttribute("designations", Employee.getValidDesignations());
            return "employeeForm"; // Return form with errors
        }

        // Calculate and set salary based on employee's designation
        Salary salary = salaryService.calculateSalary(employee.getDesignation());
        employee.setSalary(salary);

        // Add employee object to the model for display on confirmation page
        model.addAttribute("employee", employee);

        return "confirmation"; // Return confirmation page
    }

    //API endpoint to fetch salary based on designation (AJAX request).
    @GetMapping("/getSalary")
    @ResponseBody // Returns raw data instead of a view
    public String getSalaryForDesignation(@RequestParam("designation") String designation) {

        // Calculate salary based on the designation
        Salary salary = salaryService.calculateSalary(designation);
        //valueOf prevents null pointer exceptions
        return String.valueOf(salary.getAmount()); // Return salary as a plain text response
    }
}
