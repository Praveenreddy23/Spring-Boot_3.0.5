package com.spring.data.jpa.repository;

import com.spring.data.jpa.entity.Guardian;
import com.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .firstName("Mani")
                .lastName("Kantha")
                .emailId("mani@gmail.com").build();
                /*.guardianName("Reddy")
                .guardianEmail("reddy@gmail.com")
                .guardianMobile("8123456789").build();*/
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWthGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Prabhas")
                .email("prabha@gmail.com")
                .mobileNo("943451387")
                .build();

        Student student = Student.builder()
                .firstName("Praveen")
                .lastName("Reddy")
                .emailId("Da@gmail.com")
                .guardian(guardian).build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudent(){
        List<Student> studentRecord = studentRepository.findAll();
        System.out.println("Student Record = "+studentRecord);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("akshay");
        System.out.println("Students Record = "+students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("ma");
        System.out.println("First Name Contain = "+students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("reddy");
        System.out.println("Guardian Name = "+students);
    }

    @Test
    public void printStudentFirstNameAndLastName(){
        Student students = studentRepository.findByFirstNameAndLastName("joshi","patil");
        System.out.println("First Name And Last Name = "+students);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("akshi@gmail.com");
        System.out.println("Email Address = "+student);
    }

    @Test
    public void printStudentFirstNameByEmailId(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("mani@gmail.com");
        System.out.println("Email Address: "+firstName);
    }

    @Test
    public void printGetStudentNameByGuardianName(){
        Student student = studentRepository.getStudentByGuardianName("reddy");
        System.out.println("Name is: "+student);

    }
    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("patel@gmail.com");
        System.out.println("Email is: "+student);
    }

    @Test
    public  void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("MD Patel","patel@gmail.com");
    }
}