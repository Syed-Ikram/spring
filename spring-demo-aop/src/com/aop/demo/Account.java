package com.aop.demo;

public class Account {
    private String name;
    private String level;
    public Account(){}

    public Account(String name, String level){
        this.name= name;
        this.level= level;
    }

    @Override
    public String toString() {
        return "AccountDAO{" +
                "name='" + name + '\'' +
                ", serviceCode='" + level + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }
}
