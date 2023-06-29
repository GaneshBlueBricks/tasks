/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author Ganesh
 */
public class Employee {
    
    private int id;
    private String name;
    private String email;
    private String address;
    private double salary;
    private String department;

    public Employee(int id, String name, String email, String address, double salary, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.department = department;
    }

    public Employee(String name, String email, String address, double salary, String department) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.department = department;
    }

    public Employee() {
    }
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", salary=" + salary + ", department=" + department + '}';
    }
    
    
}
