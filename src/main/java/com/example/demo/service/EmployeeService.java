package com.example.demo.service;

import com.example.demo.model.Employee;
import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> listAll();

    Employee findById(long empId);

    void deleteEmployee(long empId);
}