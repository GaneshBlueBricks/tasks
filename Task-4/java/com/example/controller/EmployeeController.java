package com.example.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Employee;
import com.example.entity.EmployeeInfo;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@RequestMapping("/addemployee&image")
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Employee> SaveEmployeeWithImage(
			@RequestPart Employee employee , @RequestPart("file") MultipartFile file ) throws IOException {
//		System.out.println(employee);
//		System.out.println(file);
		if(file.isEmpty()) {
		ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image required");
		}
		else {
			EmployeeInfo employeeInfo= employee.getEmployeeInfo();
			employeeInfo.setImage(file.getBytes());
			employee.setEmployeeInfo(employeeInfo);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeRepo.save(employee));
	}
	
	@PostMapping("/addemployee")
	public ResponseEntity<Employee> SaveEmployee(
			@RequestBody Employee employee) throws IOException {
		System.out.println(employee);
		EmployeeInfo employeeInfo= employee.getEmployeeInfo();
		employee.setEmployeeInfo(employeeInfo);
			
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeRepo.save(employee));
	}
	
	@GetMapping("/fetchEmployee/{id}")
	public ResponseEntity<?> fetchEmployeeById(@PathVariable int id){
		return ResponseEntity.ok(employeeRepo.findById(id));
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable int id){
		try {
			employeeRepo.deleteById(id);
			return ResponseEntity.ok("Removed Employee of Id "+id);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with id:"+id+ " Not found");
		}
	}

	
	@PutMapping(value="/updateemployee/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> updateEmployeeById(@PathVariable int id, @RequestPart Employee employee, 
														@RequestPart("file") MultipartFile file) throws IOException{
		Employee employeeFromDB=employeeRepo.getEmployeeById(id);
		if(employeeFromDB != null) {
			employeeFromDB.setEmployeeDepartment(employee.getEmployeeDepartment());
			employeeFromDB.setSalary(employee.getSalary());
			
//			if(!file.isEmpty())
			{
				EmployeeInfo employeeInfofromDB=employeeFromDB.getEmployeeInfo();
				
				employeeInfofromDB.setImage(file.getBytes());
				employeeFromDB.setEmployeeInfo((employeeInfofromDB));
			}
			
			return ResponseEntity.ok(employeeRepo.save(employeeFromDB));
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with id:"+id+ " Not found");

	}
	
//	@PutMapping("/updateEmployee/{id}")
//	public ResponseEntity<?> updateEmployeeById(@PathVariable int id, @RequestBody Employee employee){
//		Employee employeeFromDB=employeeRepo.getEmployeeById(id);
//		if(employeeFromDB != null) {
//			employeeFromDB.setEmployeeDepartment(employee.getEmployeeDepartment());
//			employeeFromDB.setEmployeeInfo((employee.getEmployeeInfo()));
//			employeeFromDB.setSalary(employee.getSalary());
//			return ResponseEntity.ok(employeeRepo.save(employeeFromDB));
//		}
//		else
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with id:"+id+ " Not found");
//
//	}
}
