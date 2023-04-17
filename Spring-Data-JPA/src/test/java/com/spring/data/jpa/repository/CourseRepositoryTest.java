package com.spring.data.jpa.repository;

import com.spring.data.jpa.entity.Course;
import com.spring.data.jpa.entity.Student;
import com.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courseList = courseRepository.findAll();
        System.out.println("courseList :"+ courseList);
    }
    @Test//@ManyToOne
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Darshan")
                .lastName("patil")
                .build();

        Course course = Course.builder()
                .title(".net")
                .credit(8)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public  void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                           PageRequest.of(0,3);

        Pageable secondPageWithTwoRecords =
                           PageRequest.of(1,2);

       /*List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();*/

        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();

        long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();

        long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("Total Elements: "+totalElements);
        System.out.println("Total Pages: "+totalPages);
        System.out.println("Courses: "+courses);

    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(0,2, Sort.by("title"));

        Pageable sortByCreditDesc =
                PageRequest.of(0,2,Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDec =
                PageRequest.of(0,2, Sort.by("credit").descending()
                                .and(Sort.by("title"))
                              );
        List<Course> courses =
//                 courseRepository.findAll(sortByTitle).getContent();
//                 courseRepository.findAll(sortByTitleAndCreditDec).getContent();
                 courseRepository.findAll(sortByCreditDesc).getContent();

        System.out.println("Courses: "+courses);

        }

        @Test
        public void printFindByTitleContaining(){
               Pageable firstPageTenRecords =
                        PageRequest.of(0,10);

               List<Course> courses =
                       courseRepository.findByTitleContaining("s",firstPageTenRecords).getContent();

            System.out.println("Courses: "+courses);
        }

        @Test
        public void saveCourseWithStudentAndTeacher(){
            Teacher teacher = Teacher.builder()
                    .firstName("Shweta")
                    .lastName("Gouda")
                    .build();

            Student student = Student.builder()
                    .firstName("Kiran")
                    .lastName("Kumar")
                    .emailId("kiran@gmail.com")
                    .build();

            Course course = Course.builder()
                    .title("Git Hub")
                    .credit(9)
                    .teacher(teacher)
                    .build();

          course.addStudents(student);

          courseRepository.save(course);

        }


    }
