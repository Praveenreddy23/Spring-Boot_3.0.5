package com.springboot.controller;

import com.springboot.model.Student;
import com.springboot.service.StudentDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department/students")
public class StudentDepartmentController {

    @Autowired
    private StudentDepartmentService studentDepartmentService;

    @GetMapping
    List<Student> getAllStudents(){
        return studentDepartmentService.getAllStudents();

    }
}
