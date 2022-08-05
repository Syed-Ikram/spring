package com.hibernate.hbEagerVsLazyDemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args){
        String jdbcURL = "jdbc:sql://localhost:3306/hb_student_tracker?useSSL=false";
        String user="hbstudent";
        String pass = "hbstudent";
        Connection connection = null;
        try{
            //Class.forName("com.mysql.jdbc.cj.Driver");

            System.out.println("connecting to :"+jdbcURL);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hb-03-one-to-many?user=hbstudent",user,pass);
            System.out.println("successfull connection");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
