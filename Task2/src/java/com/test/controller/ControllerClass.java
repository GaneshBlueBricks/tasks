/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controller;

import com.test.Entity.Employee;
import com.test.util.getConnection;
import java.sql.Connection;
import java.util.ArrayList;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ganesh
 */
@Path("ControllerClass")
@Produces(MediaType.APPLICATION_JSON)
public class ControllerClass {
    EmployeeUtil util=new EmployeeUtil();
    
    @GET
    @Path("fetchAllEmployee")
    public ArrayList<Employee> fetchAllEmployees(){
        
        ArrayList<Employee> employeeList=util.getAllEmployee();
  
        return employeeList;
    }
    
    @GET
    @Path("fetchEmployee")
    public Employee fetchEmployeeById(@QueryParam("id") int id ){
        System.out.println("id :"+id);
        Employee employee=util.getEmployeeByID(id);
        return employee;
    }
    
    @GET
    @Path("fetchEmployeeByEmail")
    public Employee fetchEmployeeByEmail(@QueryParam("email") String email ){
        System.out.println("id :"+email);
        Employee employee=util.getEmployeeByEmail(email);
       
        return employee;
    }
    
    @POST
    @Path("createEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    public String creteEmplpoyee(Employee employee){
        
        System.err.println("employee got :"+employee);
        int id=util.save(employee);
        if(id>1)
        return "No. of Rows Affected :"+id;
        else
            return "record not created, plz check email (Email already present)";
                
    }
    
    @PUT
    @Path("updateEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateEmplpoyee(@QueryParam("email")String email, Employee employee){
        
        System.err.println("employee got :"+employee);
         System.err.println("email got :"+email);
        
        boolean id=util.update(email,employee);
        if(id==true)
        return "Rows Affected :"+id;
        else
        return "record not updated, plz check email or Id";
                
    }
    
    @DELETE
    @Path("deleteEmployee")
    public String deleteEmployee(@QueryParam("email") String email){
    
        boolean rowsAffected=util.deleteEmployeeByEmail(email);
        if(rowsAffected==true){
            return "Employee delete Successfully";
        }
        else{
            return "record not deleted, plz check email or Id";
        }
    }
}
