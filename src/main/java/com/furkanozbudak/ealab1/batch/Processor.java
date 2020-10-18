package com.furkanozbudak.ealab1.batch;

import com.furkanozbudak.ealab1.model.Student;
import com.furkanozbudak.ealab1.model.StudentFromFile;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<StudentFromFile, Student> {


    @Override
    public Student process(StudentFromFile studentFromFile) throws Exception {
        Student student = new Student();
        student.setFirstName(studentFromFile.getFirstName());
        student.setLastName(studentFromFile.getLastName());
        student.setGpa(studentFromFile.getGpa());
        LocalDate dateOfBirth = LocalDate.now().minusYears(studentFromFile.getAge());
        dateOfBirth = dateOfBirth.withMonth(1).withDayOfYear(1);
        student.setDateOfBirth(dateOfBirth);

        System.out.println("In process student:" + student);
        return student;
    }

}