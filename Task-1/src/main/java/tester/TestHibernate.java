package tester;
import java.util.Scanner;

import pojos.Employee;
import pojos.EmployeeInfo;
import utils.EmployeeUtil;

public class TestHibernate {
	
	public static void main(String[] args) {
		boolean flag=true;
		int choice;
		Scanner sc= new Scanner(System.in);
		while(flag) {
		
		System.out.println("Choose what to do\n 1.Add Employee\n 2.update Employee\n "
				+ "3.delete Employee\n 4.Fetch Employee\n 5.Exit");
		
		choice= sc.nextInt();
		
			switch (choice) {
			case 1:
				//add employee
				Employee employee= getNewEmployee();
				int id=EmployeeUtil.addEmployeee(employee);
				System.out.println("Added Employee having id:"+id);
				
				break;

			case 2:
				// update
				System.out.println("Enter Employee Id to Update");
				int Id=sc.nextInt();
				Employee employeeDB= EmployeeUtil.getEmployeeById(Id);
				if(employeeDB!=null) {
					System.out.println("Found Employee:"+employeeDB);
				}
				Employee employeeUpdate= getNewEmployee();
				EmployeeUtil.updateEmployeeById(Id, employeeUpdate);
				break;
			case 3:
				// delete
				System.out.println("Enter Employee Id to Delete");
				EmployeeUtil.deleteEmployeeById(sc.nextInt());
				break;
			case 4:
				// fetch
				System.out.println("Enter Employee Id to fetch");
				
				Employee employee2= EmployeeUtil.getEmployeeById(sc.nextInt());
				if(employee2!=null) {
					System.out.println("Found Employee:"+employee2);
				}
				break;
			case 5:
				//exit
				flag=false;
				break;
			}
		
		}
		
		
	}
	public static Employee getNewEmployee() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Details of Employee");
		System.out.println("Enter Name");
		String name=sc.next();
		System.out.println("Enter PhoneNumber");
		String phone= sc.next();
		System.out.println("Enter Email");
		String email= sc.next();
		System.out.println("Enter Location");
		String location= sc.next();
		EmployeeInfo employeeInfo= new EmployeeInfo(name, phone, email, location);
		System.out.println("Enter Departmenet");
		
		String dept= sc.next();
		System.out.println("Enter Salary");
		double salary= sc.nextDouble();
		
		Employee employee= new Employee();
		employee.setEmployeeDepartment(dept);
		employee.setEmployeeInfo(employeeInfo);
		employee.setSalary(salary);
		return employee;
	}

}
