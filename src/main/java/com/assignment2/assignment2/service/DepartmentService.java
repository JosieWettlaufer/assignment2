package com.assignment2.assignment2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.assignment2.assignment2.model.Department;

@Service
public class DepartmentService {

    //Returns List of Department Objects
    public List<Department> getAllDepartments() {
        return List.of(
                new Department("dev", "Development"),
                new Department("qa", "Quality Assurance"),
                new Department("ops", "Operations"),
                new Department("hr", "Human Resources"),
                new Department("fin", "Finance"),
                new Department("mkt", "Marketing")
        );
    }
}
