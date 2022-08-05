package com.hibernate.hb03OneToMany.demo;

import com.hibernate.hb03OneToMany.demo.entity.Course;
import com.hibernate.hb03OneToMany.demo.entity.Instructor;
import com.hibernate.hb03OneToMany.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            Instructor tempInstructor = new Instructor("Susan","Public","susan@luv2code.com");
            InstructorDetail tempInstructorDetial = new InstructorDetail(
                    "http://youtube.com/susan","Video Games !!"
            );
            tempInstructor.setInstructorDetail(tempInstructorDetial);
            session.beginTransaction();
            System.out.println("saving instrcutor");
            session.save(tempInstructor);

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
