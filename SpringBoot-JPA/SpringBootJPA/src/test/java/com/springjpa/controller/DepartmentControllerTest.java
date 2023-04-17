package com.springjpa.controller;

import com.springjpa.entity.Department;
import com.springjpa.exception.DepartmentNotFoundException;
import com.springjpa.service.DepartmentService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp(){
        department = Department.builder()
                .departmentName("CS")
                .departmentCode("CS-29")
                .departmentAddress("Mangalore")
                .departmentId(1L)
                .build();
    }


    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("CS")
                .departmentCode("CS-29")
                .departmentAddress("Mangalore")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);


        mockMvc.perform(post("/department").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\n" +
                        "\t\"departmentName\": \"CS\",\n" +
                        "\t\"departmentCode\": \"CS-29\",\n" +
                        "\t\"departmentAddress\": \"Mangalore\"\n" +
                        "\t\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);
        mockMvc.perform(get("/department/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }
}