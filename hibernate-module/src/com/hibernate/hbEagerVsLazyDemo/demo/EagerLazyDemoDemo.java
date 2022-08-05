package com.hibernate.hbEagerVsLazyDemo.demo;

import com.hibernate.hbEagerVsLazyDemo.demo.entity.Course;
import com.hibernate.hbEagerVsLazyDemo.demo.entity.Instructor;
import com.hibernate.hbEagerVsLazyDemo.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EagerLazyDemoDemo {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();
            int id = 1;
            Instructor tempInstructor = session.get(Instructor.class,id);
            System.out.println("Instructor:"+tempInstructor);
            System.out.println("Course:"+tempInstructor.getCourses());

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
