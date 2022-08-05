package com.spring.demo.mvc;

import com.spring.demo.mvc.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {
    private String firstName;

    @NotNull(message = "is requried")
    @Size(min=1,message = "is requried")
    private String lastName;

    @NotNull(message = "is requried")
    @Min(value=1,message = "less than 1")
    @Max(value =10,message = "greater than 10")
    private Integer freePasses;

    @Pattern(regexp="^[a-zA-Z0-9]{5}",message="only 5 char/digits")
    private String postalCode;

    @CourseCode(value = "CSE",message = "must start with CSE")
    private String courseCode;

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public String getFirstName() {
        return firstName;
    }
}
