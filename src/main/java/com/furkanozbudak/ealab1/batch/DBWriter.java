package com.furkanozbudak.ealab1.batch;

import com.furkanozbudak.ealab1.model.Student;
import com.furkanozbudak.ealab1.service.StudentService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Student> {

    @Autowired
    private StudentService studentService;

    @Override
    public void write(List<? extends Student> students) throws Exception {

        System.out.println("Data Saved for Users: " + students);
        for(Student student : students) {
            studentService.save(student);
        }
    }
}