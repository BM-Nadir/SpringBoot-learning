package com.second.secondproject.controller;

import com.second.secondproject.model.Employee;
import com.second.secondproject.service.EmployeeService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // employee rest API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // get all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    // Get Employee by id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    // Update Employee by id
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee, @PathVariable("id") Long employeeId) {
        return new ResponseEntity<Employee>(employeeService.updateEmployeeById(employee, employeeId), HttpStatus.OK);
    }

    // Delete Employee by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long employeeId) {
        return new ResponseEntity<String>(employeeService.deleteEmployeeById(employeeId), HttpStatus.OK);
    }
}