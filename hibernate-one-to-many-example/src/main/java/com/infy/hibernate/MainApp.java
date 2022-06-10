package com.infy.hibernate;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infy.hibernate.entity.Department;
import com.infy.hibernate.entity.Employee;


public class MainApp {
   public static void main(String[] args) {
      Session session = null;
      
      // Logger to avoid unnecessary messeges on console
      Logger log = Logger.getLogger("org.hibernate");
      log.setLevel(Level.SEVERE); 
      
      Transaction transaction = null;
      try {
         session = HibernateUtil.getSessionFactory().openSession();
         transaction = session.getTransaction();
         transaction.begin();

			/*
			 * Department department = new Department();
			 * department.setName("IT Department");
			 * 
			 * Employee employee1 = new Employee(); employee1.setName("Adam");
			 * employee1.setDesignation("Manager"); employee1.setDepartment(department);
			 * 
			 * Employee employee2 = new Employee(); employee2.setName("Miller");
			 * employee2.setDesignation("Software Engineer");
			 * employee2.setDepartment(department);
			 * 
			 * Employee employee3 = new Employee(); employee3.setName("Smith");
			 * employee3.setDesignation("Associate  Engineer");
			 * employee3.setDepartment(department);
			 */

			/*
			 * department.getEmployees().add(employee1);
			 * department.getEmployees().add(employee2);
			 * department.getEmployees().add(employee3);
			 */
         
         
         
         Department department1 = new Department();
         department1.setName("Finance Department");

         Employee employee11 = new Employee();
         employee11.setName("Mihir");
         employee11.setDesignation("Employee");
         employee11.setDepartment(department1);

         Employee employee22 = new Employee();
         employee22.setName("Varun");
         employee22.setDesignation("Finance Emp");
         employee22.setDepartment(department1);

       

         department1.getEmployees().add(employee11);
         department1.getEmployees().add(employee22);

         session.persist(department1);

         transaction.commit();
      } catch (Exception e) {
         if (transaction != null) {
            transaction.rollback();
         }
         e.printStackTrace();
      } finally {
         if (session != null) {
            session.close();
         }
      }

      HibernateUtil.shutdown();
   }
}
