package com.furkanozbudak.ealab1.service;

import com.furkanozbudak.ealab1.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student save(Student student);
}
