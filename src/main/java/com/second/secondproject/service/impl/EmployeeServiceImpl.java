package com.second.secondproject.service.impl;

import com.second.secondproject.exception.ResourceNotFoundException;
import com.second.secondproject.model.Employee;
import com.second.secondproject.repository.EmployeeRepository;
import com.second.secondproject.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        // 1) way
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if (employee.isPresent()) {
//            return employee.get();
//        } else {
//            throw new ResourceNotFoundException("Employee", "id", id);
//        }

        // 2) way lambda expression
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "id", id));
    }

    @Override
    public Employee updateEmployeeById(Employee employee, Long id) {
        // Check if Employee exists, if NOt an Exception will be thrown and the code will not continue
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "id", id));
        // Update Employee
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        // Save new data
        employeeRepository.save(existingEmployee);
        // Return updated Employee
        return existingEmployee;
    }

    @Override
    public String deleteEmployeeById(Long id) {
        // Check if employee exists
        employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "id", id));
        // Delete employee
        employeeRepository.deleteById(id);
        return "";
    }
}
