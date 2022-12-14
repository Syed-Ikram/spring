package com.hibernate.hb03OneToMany.demo;

import com.hibernate.hb03OneToMany.demo.entity.Course;
import com.hibernate.hb03OneToMany.demo.entity.Instructor;
import com.hibernate.hb03OneToMany.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {
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

            Course tempCourse1= new Course("The Air Guitar- the Ultimate Guide");
            Course tempCourse2= new Course("the PinBall Master");
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            session.save(tempCourse1);
            session.save(tempCourse2);

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
