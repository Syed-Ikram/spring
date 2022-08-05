package com.hibernate.hb05ManyToMany.demo;


import com.hibernate.hb05ManyToMany.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesAndStudentsDemo {
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


            Course tempCourse= new Course("PacMan - How to score 1 million points");

            System.out.println("saving  course..");
            session.save(tempCourse);

            Student tempStudent1 = new Student("Paul","Wall","paul@luv2code.com");
            Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");

            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            System.out.println("saving students..");
            session.save(tempStudent1);
            session.save(tempStudent2);





            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
