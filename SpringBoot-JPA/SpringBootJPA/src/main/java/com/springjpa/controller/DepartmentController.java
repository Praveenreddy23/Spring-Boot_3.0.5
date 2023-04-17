package com.springjpa.controller;

import com.springjpa.entity.Department;
import com.springjpa.exception.DepartmentNotFoundException;
import com.springjpa.service.DepartmentService;
import jakarta.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department){

       return departmentService.saveDepartment(department);

    }
    @GetMapping("/department")
    public List<Department>  fetchDepartmentList(){
        return departmentService.fetchDepartmentList();

    }
    @GetMapping("/department/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

        return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department Delete Successfully!!!";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId ,@RequestBody Department department ){

        return departmentService.updateDepartment(departmentId,department);
    }
    @GetMapping("department/name/{departmentName}")
    public Department fetchDepartmentByName(@PathVariable String departmentName){

        return departmentService.fetchDepartmentByName(departmentName);
    }


}
