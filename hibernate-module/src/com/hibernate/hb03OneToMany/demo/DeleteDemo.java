package com.hibernate.hb03OneToMany.demo;

import com.hibernate.hb03OneToMany.demo.entity.Instructor;
import com.hibernate.hb03OneToMany.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();
            int id = 1;
            Instructor tempInstructor=session.get(Instructor.class,id);
            System.out.println("Instructor:"+tempInstructor);

            if(tempInstructor != null){
                System.out.println("deleting");
                session.delete(tempInstructor);
            }

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }
}
