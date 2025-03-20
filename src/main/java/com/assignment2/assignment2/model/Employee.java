package com.assignment2.assignment2.model;

import jakarta.validation.Valid;
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
    private String name;

    @Setter(AccessLevel.NONE) //override lombok setter
    @Valid
    @NotEmpty(message = "Please select a designation")
    private String designation; //dropdown menu

    private Salary salary = new Salary(999.0); //default value

    private boolean fullTime; //boolean chkbox, part-time/full-time

    // multiple selection via chkboxes
    private List<String> departments;

}
