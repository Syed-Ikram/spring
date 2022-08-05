package com.hibernate.hb03OneToMany.demo;

import com.hibernate.hb03OneToMany.demo.entity.Instructor;
import com.hibernate.hb03OneToMany.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            Instructor tempInstructor = new Instructor("Madhu","Patel","madhu@luv2code.com");
            InstructorDetail tempInstructorDetial = new InstructorDetail(
                    "http://youtube.com/madhu","Guitar !!"
            );
            tempInstructor.setInstructorDetail(tempInstructorDetial);
            session.beginTransaction();
            System.out.println("saving instrcutor");
            session.save(tempInstructor);

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }
}
