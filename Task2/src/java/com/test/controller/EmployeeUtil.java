/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controller;

import com.test.Entity.Employee;
import com.test.util.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ganesh
 */
public class EmployeeUtil {
    
    
    //fetching All Employees
    public ArrayList<Employee> getAllEmployee(){
        ArrayList<Employee> employeeList=new ArrayList<>();
        
       try{
            Connection connection= getConnection.getConnection();
            Statement statement=connection.createStatement();
            String sql= "select * from employee";
            ResultSet resultSet=statement.executeQuery(sql);
        while(resultSet.next()){
            Employee employee=new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setEmail(resultSet.getString("email"));
            employee.setDepartment(resultSet.getString("department"));
            employee.setSalary(resultSet.getDouble("salary"));
            
            employeeList.add(employee);
         }
       }catch(Exception e){
           e.printStackTrace();
       
        }
        return employeeList;
    }

    public Employee getEmployeeByID(int id) {
        Employee employee=new Employee();
         try{
            Connection connection= getConnection.getConnection();
           
            String sql= "select * from employee where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id); // Assuming 1 is the value you want to substitute for the parameter

            ResultSet resultSet = preparedStatement.executeQuery();             
        while(resultSet.next()){
            
            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setEmail(resultSet.getString("email"));
            employee.setDepartment(resultSet.getString("department"));
            employee.setSalary(resultSet.getDouble("salary"));
            
         }
       }catch(Exception e){
           e.printStackTrace();
       
        }
         return employee;
    }

    public Employee getEmployeeByEmail(String email) {
       Employee employee=new Employee();
         try{
            Connection connection= getConnection.getConnection();
           
            String sql= "select * from employee where email=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,email); // Assuming 1 is the value you want to substitute for the parameter

            ResultSet resultSet = preparedStatement.executeQuery();
             
        while(resultSet.next()){
           
            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setEmail(resultSet.getString("email"));
            employee.setDepartment(resultSet.getString("department"));
            employee.setSalary(resultSet.getDouble("salary"));
            employee.setAddress(resultSet.getString("address"));
            
         }
       }catch(Exception e){
           e.printStackTrace();
       
        }
         return employee;
    }

    public int save(Employee employee) {
        int id=0;
          try{
            Connection connection= getConnection.getConnection();
            String sql= "INSERT INTO employee( name ,email ,salary,department, address) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getEmail());
            preparedStatement.setDouble(3,employee.getSalary());
            preparedStatement.setString(4,employee.getDepartment());
            preparedStatement.setString(5,employee.getAddress());
            

            id = preparedStatement.executeUpdate();
           
             //connection.commit();
         
       }catch(Exception e){
           e.printStackTrace();
       
        }
          return id;
    }

    boolean update(String email, Employee employee) {
        boolean flag=false;
        int id=0;
           Connection connection= getConnection.getConnection();
           
           Employee employeeFromDB= getEmployeeByEmail(email);
           System.out.println("employee from DB :"+employeeFromDB);
           if(employeeFromDB==null){
               return false;
           }
           else{
               try{
                    String sql= "update employee set name=?, email=?, salary=?, department=?, address=? where email=?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 
                    if(employee.getName()!=null){
                        preparedStatement.setString(1, employee.getName());
                    }else{
                        preparedStatement.setString(1, employeeFromDB.getName());
                    }
                    
                    if(employee.getEmail()!=null){
                        preparedStatement.setString(2, employee.getEmail());
                    }else{
                        preparedStatement.setString(2, employeeFromDB.getEmail());
                    }
                    
                    if(employee.getDepartment()!=null){
                        preparedStatement.setString(4, employee.getDepartment());
                    }else{
                        preparedStatement.setString(4, employeeFromDB.getDepartment());
                    }
                   
                        preparedStatement.setDouble(3, employee.getSalary());
                   
                    if(employee.getAddress()!=null){
                        preparedStatement.setString(5, employee.getAddress());
                    }else{
                        preparedStatement.setString(5, employeeFromDB.getAddress());
                    }
                    preparedStatement.setString(6,email);
                   
                 id=   preparedStatement.executeUpdate();
            
               }
               catch(Exception e){
               }
           }
           if(id<1)
            return false;
           else
               return true;
           
           
    }

    public boolean deleteEmployeeByEmail(String email) {
    boolean flag = false;
    int rowsAffected = 0;
    Employee employee = getEmployeeByEmail(email);
    if (employee == null) {
        return false;
    } else {
        try {
            Connection connection = getConnection.getConnection();
            String sql = "DELETE FROM employee WHERE email=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, email);

            rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return flag;
}

}
