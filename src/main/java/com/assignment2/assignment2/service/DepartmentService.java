package com.assignment2.assignment2.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.assignment2.assignment2.model.Department;

@Service
public class DepartmentService {

    //Returns List of Department Objects
    public List<Department> getAllDepartments() {
        return List.of(
                new Department("Development"),
                new Department("Quality Assurance"),
                new Department("Operations"),
                new Department("Human Resources"),
                new Department("Finance"),
                new Department("Marketing")
        );
    }
}
