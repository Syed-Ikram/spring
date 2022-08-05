package com.hibernate.jdbcCRUD.demo;

import com.hibernate.jdbcCRUD.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {
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
            System.out.println("delete student ..  "+ myStudent);
            session.delete(myStudent);
            System.out.println("delete student id with 2");
            session.createQuery("delete from Student where id=2 ").executeUpdate();
            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }
}
