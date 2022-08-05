package com.hibernate.hb02OneToOneBi.demo;

import com.hibernate.hb02OneToOneBi.demo.entity.Instructor;
import com.hibernate.hb02OneToOneBi.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorDetailDemo {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();
            int id = 2;
            InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class,id);
            System.out.println("Instructor:"+tempInstructorDetail);

            System.out.println("Instructor:"+tempInstructorDetail.getInstructor());

            session.getTransaction().commit();
            System.out.println("Done");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
