package com.assignment2.assignment2.model;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @NotEmpty(message= "Please enter a name")
    private String name;

    @NotEmpty(message = "Please enter a designation")
    private String designation; //dropdown menu

    private String salary; //selected automatically based on designation

    private boolean employmentType; //boolean chkbox, part-time/full-time

    // multiple selection via chkboxes
    private List<String> departments; //make foreign key for emps with multiple depts.

}
