package com.springbootbasic.service;


import com.springbootbasic.entity.Employee;
import com.springbootbasic.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();
    @Override
    public Employee save(Employee employee) {

        if (employee.getEmployeeId() == null || employee.getEmailId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return employees
                .stream()
                .filter(employee -> employee.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElseThrow(() -> new /*EmployeeNotFoundException*/ RuntimeException(" "+
                        "Employee Not Found with Id:"+employeeId));
//        "status": "NOT_FOUND",
//    "message": " Employee Not Found with Id:24412a1b-ac82-46f1-b6d1-4bdc6d6c74432"
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee employee = employees
                .stream()
                .filter(employee1 -> employee1.getEmployeeId().equalsIgnoreCase(id))
                .findFirst()
                .get();
        employees.remove(employee);

        return "Employee Deleted With The ID:"+id;
    }
}
