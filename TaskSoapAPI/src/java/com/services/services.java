/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.entity.Employee;
import com.helper.EmployeeUtil;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Ganesh
 */
@WebService
public class services {
    
    @WebMethod
    public Employee getEmployeeById(int id){
        Employee employee =EmployeeUtil.getEmployeeByID(id);
        return employee;
    }
    
    @WebMethod
    public Employee getEmployeeByEmail(String email){
        Employee employee =EmployeeUtil.getEmployeeByEmail(email);
        return employee;
    }
    
    @WebMethod
    public int createEmployee(Employee employee){
        int id=EmployeeUtil.save(employee);
        return id;
    }
    
    @WebMethod
    public boolean deleteEmployeeById(String email){
        boolean flag=EmployeeUtil.deleteEmployeeByEmail(email);
        return flag;
    }
    
    @WebMethod
    public void updateEmployeeById(String email,Employee employee){
        EmployeeUtil.update(email,employee);
        
    }
    
}
