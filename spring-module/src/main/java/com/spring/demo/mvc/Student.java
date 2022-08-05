package com.spring.demo.mvc;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String LastName;
    private String country;
    private LinkedHashMap<String,String> countryOptions;
    private String favouriteLanguage;
    private String[] operatingSystems;

    public Student(){
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("IN","India");
        countryOptions.put("DE","Germany");
        countryOptions.put("CAN","Canada");
        countryOptions.put("FR","France");
        countryOptions.put("BR","Brazil");

    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getCountry() {
        return country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}
