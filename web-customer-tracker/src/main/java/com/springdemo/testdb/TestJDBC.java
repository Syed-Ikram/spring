package com.springdemo.testdb;

import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args){
        String jdbcURL = "jdbc:mysql://localhost:3306/web-customer-tracker?user=springstudent";
        String user="springstudent";
        String pass = "springstudent";
        Connection connection = null;
        try{
            //Class.forName("com.mysql.jdbc.cj.Driver");

            System.out.println("connecting to :"+jdbcURL);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_customer_tracker?user=springstudent",user,pass);
            // jdbc:mysql://localhost:3306/web_customer_tracker?user=springstudent
            System.out.println("successfull connection");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
