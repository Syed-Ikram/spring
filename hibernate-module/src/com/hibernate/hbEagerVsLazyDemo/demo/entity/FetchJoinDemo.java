package com.hibernate.hbEagerVsLazyDemo.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchJoinDemo {
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
            Query query = session.createQuery("select i from Instructor i JOIN FETCH " +
                    "i.courses where i.id = :theInstructorId",Instructor.class);
            query.setParameter("theInstructorId",id);
            //Instructor tempInstructor = query.getSingleResult();
            //System.out.println("Instructor:"+tempInstructor);
            //System.out.println("Course:"+tempInstructor.getCourses());

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
