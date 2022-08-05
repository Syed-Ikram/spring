package com.hibernate.jdbcCRUD.demo;

import com.hibernate.jdbcCRUD.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            System.out.println("creating student..");
            Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.com");
            session.beginTransaction();
            System.out.println("saving the student...");
            session.save(tempStudent);
            System.out.println(tempStudent);
            session.getTransaction().commit();

            System.out.println("Student id auto generated:"+tempStudent.getId());
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting student of id:"+tempStudent.getId() );
            Student myStudent =session.get(Student.class,tempStudent.getId());
            System.out.println("Get Complete:"+myStudent);
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }
}
