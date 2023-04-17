package com.spring.data.jpa.repository;

import com.spring.data.jpa.entity.Course;
import com.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseSB = Course.builder()
                .title("Spring Boot")
                .credit(9)
                .build();
        Course courseDSA = Course.builder()
                .title("DSA")
                .credit(8)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Uday")
                .lastName("Power")
               // .courses(List.of(courseSB,courseDSA))
                .build();
         teacherRepository.save(teacher);

    }

}