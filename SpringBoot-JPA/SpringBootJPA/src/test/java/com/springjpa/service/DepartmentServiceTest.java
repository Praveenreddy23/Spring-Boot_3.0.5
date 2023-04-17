package com.springjpa.service;

import com.springjpa.entity.Department;
import com.springjpa.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @Mock
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder().
                        departmentName("Civil")
                        .departmentAddress("Mysore")
                        .departmentCode("CV-023")
                        .departmentId(2l)
                        .build();


        Mockito.when(departmentRepository.findByDepartmentName("Civil")).thenReturn(department);
    }

    @Test
    @DisplayName("Test Passed Successfully!!! Tests On Service Layer | And getting Data Based Valid Department Name")
    public void whenValidDepartmentName_ThenValidDepartmentShouldFound(){
        String departmentName ="Civil";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());

    }
}