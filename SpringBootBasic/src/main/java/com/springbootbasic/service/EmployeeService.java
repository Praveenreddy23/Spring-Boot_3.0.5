package com.springbootbasic.service;

import com.springbootbasic.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String employeeId);

    String deleteEmployeeById(String id);
}
