package com.assignment2.assignment2.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.assignment2.assignment2.model.Employee;
import com.assignment2.assignment2.service.DepartmentService;
import com.assignment2.assignment2.service.SalaryService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/employees")
public class employeeController {

    private final SalaryService salaryService;
    private final DepartmentService departmentService;

    //constructor injection
    public employeeController(SalaryService salaryService,
                          DepartmentService departmentService) {
        this.salaryService = salaryService;
        this.departmentService = departmentService;
    }

    //Display employee registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

        //Add empty employee object to the model
        model.addAttribute("employee", new Employee());

        //Add departments list to the model
        model.addAttribute("departments", departmentService.getAllDepartments());

        //Add designations to the model
        model.addAttribute("designations", Employee.getValidDesignations());

        return "employeeForm";
    }

    //Process Form submission
    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute("employee") Employee employee,
                                      BindingResult result, Model model) {
        if (result.hasErrors()) {
            //If validation errors occur, add necessary attrs. back to model
            model.addAttribute("departments", departmentService.getAllDepartments());
            model.addAttribute("designations", Employee.getValidDesignations());

            return "confirmation";
        }

        //calculate and set salary bsaed on designation
        double salary = salaryService.calculateSalary(employee.getDesignation());
        employee.setSalary(salary);

        //add employee to model for confirmation page
        model.addAttribute("employee", employee);



        return "confirmation";
    }

    //Get salary value based on designation
    @GetMapping("/getSalary")
    @ResponseBody
    public String getSalaryForDesignation(@RequestParam("designation") String designation) {
        //gets salary based on designation from URL
        double salary = salaryService.calculateSalary(designation);
        return String.valueOf(salary); //return in response body (plaintext)
    }
}
