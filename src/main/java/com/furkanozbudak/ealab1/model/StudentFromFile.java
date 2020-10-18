package com.furkanozbudak.ealab1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentFromFile {
    private String firstName;
    private String lastName;
    private double gpa;
    private int age;
}
