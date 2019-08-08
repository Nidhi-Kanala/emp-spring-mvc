package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public List<Employee> listAll(){
        System.out.println("Inside the list all method....");
        return this.employeeService.listAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable("id") long id){
        return this.employeeService.findById(id);
    }

    @PostMapping("/employees")
    public void saveEmployee(@Valid @RequestBody Employee employee){
        this.employeeService.saveEmployee(employee);
    }
}