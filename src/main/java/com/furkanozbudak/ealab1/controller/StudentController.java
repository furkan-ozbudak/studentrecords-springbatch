package com.furkanozbudak.ealab1.controller;

import com.furkanozbudak.ealab1.model.Role;
import com.furkanozbudak.ealab1.model.Student;
import com.furkanozbudak.ealab1.model.UserEntity;
import com.furkanozbudak.ealab1.service.RoleService;
import com.furkanozbudak.ealab1.service.StudentService;
import com.furkanozbudak.ealab1.service.UserEntityService;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.batch.operations.JobRestartException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @Autowired
    StudentService studentService;

    @Autowired
    UserEntityService userEntityService;

    @Autowired
    RoleService roleService;


    @GetMapping("/hello")
    public String hello() {
        return "Hello everybody!";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/adminHello")
    public String securedHello() {
        return "Hello admin!";
    }

    @GetMapping("/secured/userHello")
    public String alternate() {
        return "Hello user!";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "You are not authorized to access this page.";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/students")
    public List<Student> loadAndDisplayStudents() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, org.springframework.batch.core.repository.JobRestartException {


        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println("JobExecution: " + jobExecution.getStatus());

        while (jobExecution.isRunning()) {
            System.out.println("...");
        }

        return studentService.findAll();
    }
}




