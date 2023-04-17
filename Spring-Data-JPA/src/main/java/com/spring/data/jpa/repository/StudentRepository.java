package com.spring.data.jpa.repository;

import com.spring.data.jpa.entity.Guardian;
import com.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByFirstName(String student);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    Student findByFirstNameAndLastName(String firstName, String lastName);

    //for more information about JPQl then refer 'spring data jpa'
    //JPQL Query
    @Query( "select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    //JPQL Query
    @Query( "select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

//    Native Query
    @Query(value = "select * from student_tbl s where s.guardian_name = ?1",nativeQuery = true)
    Student getStudentByGuardianName(String guardianName);
//Native Named Param
    @Query(value = "SELECT * FROM STUDENT_TBL S WHERE S.EMAIL_ADDRESS = :emailId",nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(value = "update student_tbl set first_name = ?1 where email_address = ?2", nativeQuery = true)
    int updateStudentNameByEmailId(String firstName, String emailId);
}
