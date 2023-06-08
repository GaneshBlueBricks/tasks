package com.example.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.example.classes.ConverterClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
}
