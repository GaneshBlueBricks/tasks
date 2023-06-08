package utils;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pojos.Employee;

@SuppressWarnings("deprecation")
public class EmployeeUtil {

	public static int addEmployeee(Employee empl) {
		SessionFactory sessionFactory= HibernateUtils.getFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		int id=(int) session.save(empl);
		transaction.commit();
		session.close();
		return id;
	}
	
	
	public static Employee getEmployeeById(int id) {
		SessionFactory sessionFactory= HibernateUtils.getFactory();
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
	
	public static void updateEmployeeById(int id, Employee employee) {
		SessionFactory sessionFactory= HibernateUtils.getFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Employee employeeToUpdate= session.get(Employee.class, id); // getting Employee By ID
		employeeToUpdate.setEmployeeDepartment(employee.getEmployeeDepartment());

		employeeToUpdate.setSalary(employee.getSalary());
		
		session.update(employeeToUpdate);
		transaction.commit();
		session.close();
	}
	
	public static void deleteEmployeeById(int id) {
		SessionFactory sessionFactory= HibernateUtils.getFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
	
		Criteria criteria= session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", id));
		Employee employeeToDelete=(Employee)criteria.uniqueResult();
		
		if(employeeToDelete!=null) {
			session.delete(employeeToDelete);
			System.out.println("Employee Deleted");
		}
		else
			System.out.println("Employee not found");
		
		transaction.commit();
		session.close();
	}
}
