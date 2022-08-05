package com.hibernate.hb03OneToMany.demo;

import com.hibernate.hb03OneToMany.demo.entity.Instructor;
import com.hibernate.hb03OneToMany.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailDemo {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();
            int id = 3;
            InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class,id);
            System.out.println("Instructor:"+tempInstructorDetail);

            System.out.println("Instructor:"+tempInstructorDetail.getInstructor());

            tempInstructorDetail.getInstructor().setInstructorDetail(null);
            System.out.println("Deleting");
            session.delete(tempInstructorDetail);
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
