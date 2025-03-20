package com.assignment2.assignment2.model;

import lombok.*;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    //List of valid designations
    public static List<String> getValidDesignations() {
        return List.of(
            "Software Engineer", "Senior Engineer",
            "Tech Lead", "Project Manager", "Director"
        );
    }

    @NotEmpty(message= "Please enter a name")
    private String name;

    @Setter(AccessLevel.NONE) //override lombok setter
    @NotEmpty(message = "Please select a designation")
    private String designation; //dropdown menu

    private double salary; //selected automatically based on designation

    private boolean fullTime; //boolean chkbox, part-time/full-time

    // multiple selection via chkboxes
    private List<String> departments; //make foreign key for emps with multiple depts.

    //Checks if chosen designation is valid
    public void setDesignation(String designation) {
        if (getValidDesignations().contains(designation)) {
            this.designation = designation;
        } else {
            throw new IllegalArgumentException("Invalid designation: " + designation); //stop method, returns error message
        }
    }
}
