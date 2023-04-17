package com.spring.data.jpa.repository;

import com.spring.data.jpa.entity.Course;
import com.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder()
                .title("Python")
                .credit(7)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.Jspidar.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);

    }
//    Fetch type -> fetching data lazy and eager
    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }

}