package com.hibernate.jdbcCRUD.demo;

import com.hibernate.jdbcCRUD.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();
            List<Student> theStudents = session.createQuery("from Student").list();
            displayStudents(theStudents);

            System.out.println("\n Last name with Doe");
            theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();
            displayStudents(theStudents);

            System.out.println("\n Last name with Doe or first name daffy");
            theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").list();
            displayStudents(theStudents);

            System.out.println("\n email like luv2code.com");
            theStudents = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").list();
            displayStudents(theStudents);

            System.out.println("\n email like gmail.com");
            theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
            displayStudents(theStudents);
            session.getTransaction().commit();


            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student tempStudent:theStudents){
            System.out.println(tempStudent);
        }
    }
}
