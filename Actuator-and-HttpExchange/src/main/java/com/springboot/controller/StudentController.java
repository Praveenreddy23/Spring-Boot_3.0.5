package com.springboot.controller;

import com.springboot.model.Student;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);

    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();

    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id){
        return studentService.getStudentById(id);
    }


}
