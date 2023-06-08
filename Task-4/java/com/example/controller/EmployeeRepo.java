package com.example.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	Employee save(Employee employee);

	@Query("select e from Employee e where e.id=?1")
	Employee getEmployeeById(int id);

}
