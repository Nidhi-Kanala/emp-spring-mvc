package com.example.demo.controller;

import com.example.demo.model.Dependent;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;


@Controller
@RequestMapping("/users")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/login")
    public String login(Model model){
        System.out.println("Came inside the login method ");
        List<Employee> listOfAllEmployees  = employeeService.listAll();
        listOfAllEmployees.forEach(employee ->  System.out.println(employee));
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam("username")String username,
            @RequestParam("password") String password,
            Model model){
        System.out.println("Inside the POST method of login user");
        System.out.println("Username is "+username + " password is "+ password);
        if(username.equalsIgnoreCase(password)){
            model.addAttribute("user", username);
            return "success";
        }
        return "login";
    }

    @GetMapping("/listAll")
    public String listAllEmployees(Model model){
        List<Employee> employees = this.employeeService.listAll();
        model.addAttribute("employees", employees);
        return "list";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("employee", new Employee());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser( @Valid @ModelAttribute("employee") Employee employee,
                                BindingResult bindingResult) throws IOException {
        if(bindingResult.hasErrors()){
            System.out.println("Error "+bindingResult.toString());
            return "register";
            //throw  new ArithmeticException("Exception occurred");
        }

        Dependent dependent=new Dependent();
        dependent.setName("");
        dependent.setAge(13);
        
        employee.addDependent(dependent);
        
        this.employeeService.saveEmployee(employee);
        return "dashboard";
    }

    @ExceptionHandler(IOException.class)
    public String handleException(HttpServletRequest request, Exception ex){
        return "error";
    }
}