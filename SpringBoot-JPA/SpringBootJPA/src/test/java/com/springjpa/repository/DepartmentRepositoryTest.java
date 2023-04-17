package com.springjpa.repository;

import com.springjpa.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Civil Engineering")
                        .departmentCode("CV-025")
                        .departmentAddress("Raichur")
                        .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {

        Department department = departmentRepository.findById(2L).get();
        assertEquals(department.getDepartmentName(),"Civil Engineering");
    }
}