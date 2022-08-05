package com.hibernate.hb05ManyToMany.demo;


import com.hibernate.hb05ManyToMany.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCoursesForMaryDemo {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();

            int id=2;
            Student theStudent = session.get(Student.class, id);
            System.out.println("student:"+theStudent);
            System.out.println("Course :"+theStudent.getCourses());

            Course tempCourse1= new Course("Rubik's Cude - How To speed");
            Course tempCourse2= new Course("Valorant - Play like a Pro");

            tempCourse1.addStudent(theStudent);
            tempCourse2.addStudent(theStudent);

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
