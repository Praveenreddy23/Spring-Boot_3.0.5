package com.springboot.service;

import com.springboot.model.Student;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    List<Student> studentList = new ArrayList<>();

    @Autowired
    private ObservationRegistry observationRegistry;



    public Student addStudent(Student student) {
        studentList.add(student);
       // return student;
        return Observation.createNotStarted("addStudents",observationRegistry).observe(() -> student);

    }

    public List<Student> getAllStudent() {
       // return studentList;
        return Observation.createNotStarted("getAllStudent",observationRegistry).observe(() -> studentList);
    }

    public Student getStudentById(String id) {
       /* return studentList
                .stream()
                .filter(student -> student.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student is not available:"+id));*/
        return Observation.createNotStarted("get StudentById",observationRegistry).observe(() -> studentList
                .stream()
                .filter(student -> student.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student is not available:"+id)));
    }
}
