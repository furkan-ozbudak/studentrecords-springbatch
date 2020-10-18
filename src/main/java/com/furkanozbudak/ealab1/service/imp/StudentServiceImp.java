package com.furkanozbudak.ealab1.service.imp;

import com.furkanozbudak.ealab1.model.Student;
import com.furkanozbudak.ealab1.repository.StudentRepository;
import com.furkanozbudak.ealab1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
