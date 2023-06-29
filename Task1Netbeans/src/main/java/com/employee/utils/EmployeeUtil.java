package com.employee.utils;

import com.employee.helper.FactoryProvider;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.employee.pojos.Employee;
import com.employee.pojos.EmployeeInfo;
import com.employee.tester.ConverterClass;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;
import org.hibernate.query.Query;


@SuppressWarnings("deprecation")
public class EmployeeUtil {
    

	public static int addEmployeee(Employee empl) {
		SessionFactory sessionFactory= FactoryProvider.getFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
                int id;
                String email=empl.getEmployeeInfo().getEmail();
                //System.out.println("email got as input:"+email);
                Employee employee= getEmployeeByEmail(email);
                //System.out.println("fetchedd Employee as:"+employee);
                if(employee==null){
                   id=(int) session.save(empl);
                }
                else{
                    return -1;
                }
		
		transaction.commit();
		session.close();
		return id;
	}
	
	
	public static Employee getEmployeeById(int id) {
		SessionFactory sessionFactory= FactoryProvider.getFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Criteria criteria= session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", id));
		Employee employee=(Employee)criteria.uniqueResult();
		if(employee!=null) {
			return employee;
		}
		else {
			System.out.println("Employee not Found");
			return null;
		}
		
	}
        
        public static Employee getEmployeeByEmail(String email) {
    Employee employee = null;
    SessionFactory sessionFactory = FactoryProvider.getFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = null;

    try {
        transaction = session.beginTransaction();

        // Prepare the SQL statement with a parameterized query
        String sql = "SELECT * FROM employee WHERE employee_info LIKE CONCAT('%', :email, '%')";

        Query query = session.createSQLQuery(sql);
        query.setParameter("email", email);
        //System.out.println("Sql query :"+query);
        List<Object[]> result = query.getResultList();
        //System.out.println("fetched result:"+result);
        // Execute the query and retrieve the result
        if (result.isEmpty()) {
            return null;
        } else {
            for (Object[] row : result) {
                int id = (Integer) row[0];
                String department = (String) row[1];
                EmployeeInfo employeeInfo =  null;  //(EmployeeInfo) row[2];
                
                // Assuming row[2] is the byte array representing the EmployeeInfo object
                 byte[] byteArray = (byte[]) row[2];
                 try {
                     ByteArrayInputStream byteStream = new ByteArrayInputStream(byteArray);
                     ObjectInputStream objectStream = new ObjectInputStream(byteStream);
                     employeeInfo = (EmployeeInfo) objectStream.readObject();
                     objectStream.close();
                     byteStream.close();
                 } catch (IOException | ClassNotFoundException e) {
                     e.printStackTrace();
                 }

                //System.out.println("fetched row[2] :"+employeeInfo);
                double salary = (Double) row[3];
                employee = new Employee(id, ConverterClass.convertToBlob(employeeInfo), department, salary);
               
            }
        }

        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        session.close();
    }
     return employee;
}

	
	public static void updateEmployeeById(int id, Employee employee) {
		SessionFactory sessionFactory= FactoryProvider.getFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Employee employeeToUpdate= session.get(Employee.class, id); // getting Employee By ID
		employeeToUpdate.setEmployeeDepartment(employee.getEmployeeDepartment());

		employeeToUpdate.setSalary(employee.getSalary());
		employeeToUpdate.setEmployeeDepartment(employee.getEmployeeDepartment());
                System.err.println("Employee from DB :"+employeeToUpdate);
                System.err.println("Employee from Input :"+employee);
//                
//                employeeToUpdate.getEmployeeInfo().setName(employee.getEmployeeInfo().getName());
//                employeeToUpdate.getEmployeeInfo().setPhone(employee.getEmployeeInfo().getPhone());
//                employeeToUpdate.getEmployeeInfo().setEmail(employee.getEmployeeInfo().getEmail());
//                employeeToUpdate.getEmployeeInfo().setAddress(employee.getEmployeeInfo().getAddress());
               
//                employeeToUpdate.setEmployeeInfo(null);
                employeeToUpdate.setEmployeeInfo(employee.getEmployeeInfo());
                
		session.saveOrUpdate(employeeToUpdate);
		transaction.commit();
		session.close();
	}
	
	public static boolean deleteEmployeeById(int id) {
		SessionFactory sessionFactory= FactoryProvider.getFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
                boolean flag=false;
	
		Criteria criteria= session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", id));
		Employee employeeToDelete=(Employee)criteria.uniqueResult();
		
		if(employeeToDelete!=null) {
			session.delete(employeeToDelete);
			System.out.println("Employee Deleted");
                        flag=true;
		}
                else{
                    System.out.println("Employee not found");                    
                }
			
		
		transaction.commit();
		session.close();
                return flag;
	}
}
