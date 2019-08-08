package com.example.demo.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Employee {

    public Employee(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name cannot be null")
    @Column(name = "emp_name", nullable = false)
    private String name;

    @Range(min = 18, max = 58, message = "Employee age should be between 18 and 58")
    private int age;

    @Column(name = "dob", nullable = false)
    private LocalDate dateOfBirth;

    @Range(min = 25000, max = 75000)
    private double salary;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Dependent> dependents = new HashSet<>();

    public Employee(long id, String name){
        this.id = id;
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth){
       this.dateOfBirth =  LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    public String getDateOfBirth(){
        if(this.dateOfBirth != null) {
            return this.dateOfBirth.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        }
        return "";
    }

    public void addDependent(Dependent dependent){
        this.dependents.add(dependent);
        dependent.setEmployee(this);
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Set<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(Set<Dependent> dependents) {
		this.dependents = dependents;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
    
    
}