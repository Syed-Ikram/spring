package com.hibernate.hb05ManyToMany.demo;


import com.hibernate.hb05ManyToMany.demo.entity.Course;
import com.hibernate.hb05ManyToMany.demo.entity.Instructor;
import com.hibernate.hb05ManyToMany.demo.entity.InstructorDetail;
import com.hibernate.hb05ManyToMany.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateAndReviewsCoursesDemo {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();


            Course tempCourse= new Course("PacMan - How to score 1 million points");

            tempCourse.addReview(new Review("Great Course !!"));
            tempCourse.addReview(new Review("Cool Course ,great job"));
            tempCourse.addReview(new Review("Dumb course"));

            System.out.println("saving ..");
            session.save(tempCourse);



            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
