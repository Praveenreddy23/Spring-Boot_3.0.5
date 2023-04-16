package com.springboot.service;

import com.springboot.model.Student;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/students")
public interface StudentDepartmentService {

    @GetExchange
    List<Student> getAllStudents();
}
