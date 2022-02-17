package com.second.secondproject.service;

import com.second.secondproject.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployeeById(Employee employee, Long id);
    String deleteEmployeeById(Long id);
}
