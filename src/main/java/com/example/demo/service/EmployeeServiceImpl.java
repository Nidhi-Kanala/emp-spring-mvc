package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public List<Employee> listAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee findById(long empId)  {
        return this.employeeRepository.findById(empId).get();
    }

    @Override
    @Transactional
    public void deleteEmployee(long empId) {
        this.employeeRepository.delete(this.employeeRepository.findById(empId).get());
    }
}
