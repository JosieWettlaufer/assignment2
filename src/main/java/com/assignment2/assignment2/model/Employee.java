package com.assignment2.assignment2.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
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

    @Valid
    @NotEmpty(message= "Please enter a name")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;        //text, required

    @Valid
    @NotEmpty(message = "Please select a designation")
    private String designation; //dropdown menu, required

    private Salary salary;

    private boolean fullTime;   //checkbox -> full-time

    // stores collection of multiple selection checkboxes
    private List<String> departments;

}
