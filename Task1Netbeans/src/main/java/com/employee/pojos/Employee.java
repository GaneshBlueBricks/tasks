package com.employee.pojos;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


import com.employee.tester.ConverterClass;

@Entity
//@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "employee_id", length = 11)
	private int id;
	
	@Lob
	@Column(name="employee_info", columnDefinition = "BLOB")
	private Blob employeeInfo;
	
	@Column(name="employee_department", length = 64)
	private String employeeDepartment;
	
	@Column(name="employee_salary")
	private double salary;
	
	public void setEmployeeInfo(EmployeeInfo emplInfo) {
		this.employeeInfo=ConverterClass.convertToBlob(emplInfo);
	}
	
	public EmployeeInfo getEmployeeInfo() {
		return ConverterClass.convertToSource(this.employeeInfo);
	}

                public Employee(int id, Blob employeeInfo, String employeeDepartment, double salary) {
                    this.id = id;
                    this.employeeInfo = employeeInfo;
                    this.employeeDepartment = employeeDepartment;
                    this.salary = salary;
                }

                public Employee(Blob employeeInfo, String employeeDepartment, double salary) {
                    this.employeeInfo = employeeInfo;
                    this.employeeDepartment = employeeDepartment;
                    this.salary = salary;
                }

                public Employee() {
                }

                public int getId() {
                    return id;
                }

                public String getEmployeeDepartment() {
                    return employeeDepartment;
                }

                public double getSalary() {
                    return salary;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setEmployeeDepartment(String employeeDepartment) {
                    this.employeeDepartment = employeeDepartment;
                }

                public void setSalary(double salary) {
                    this.salary = salary;
                }

                @Override
                public String toString() {
                    return "Employee{" + "id=" + id + ", employeeInfo=" + ConverterClass.convertToSource(employeeInfo) + ", employeeDepartment=" + employeeDepartment + ", salary=" + salary + '}';
                }


}
