package com.hibernate.jdbcCRUD.demo;

import com.hibernate.jdbcCRUD.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            int studentId =1;
            //1
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting student of id:"+ studentId);
            Student myStudent =session.get(Student.class,studentId);
            System.out.println("UPdate student ..");
            myStudent.setFirstName("Scooby");
            myStudent.setLastName("Wall");
            session.getTransaction().commit();
            //2
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("update email for all students");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }
}
