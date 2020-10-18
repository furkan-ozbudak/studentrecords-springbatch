package com.furkanozbudak.ealab1;

import com.furkanozbudak.ealab1.model.Role;
import com.furkanozbudak.ealab1.model.UserEntity;
import com.furkanozbudak.ealab1.service.RoleService;
import com.furkanozbudak.ealab1.service.StudentService;
import com.furkanozbudak.ealab1.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EaLab1Application implements CommandLineRunner {
    @Autowired
    StudentService studentService;

    @Autowired
    UserEntityService userEntityService;

    @Autowired
    RoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(EaLab1Application.class, args);
    }

    /** Initialize on boot*/
    @Override
    public void run(String... args) throws Exception {
        /** Create authorizations */
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        Role employeeRole = new Role();
        employeeRole.setRole("EMPLOYEE");

        /** Create admin */
        UserEntity admin = new UserEntity();
        admin.setName("adminFirst");
        admin.setLastName("adminLast");
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin");
        admin.addRole(adminRole);
        admin.setActive(1);
        userEntityService.save(admin);

        /** Create regular user */
        UserEntity employee = new UserEntity();
        employee.setName("employeeFirst");
        employee.setLastName("employeeLast");
        employee.setEmail("employee@gmail.com");
        employee.setPassword("employee");
        employee.addRole(employeeRole);
        employee.setActive(1);
        userEntityService.save(employee);

    }
}
