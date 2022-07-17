package com.bici_u.management;

public class User {

    private String DNI;
    private String name;
    private int age;
    private String role;
    private String id;

    public User(String DNI, String name, int age, String role) {
        this.DNI = DNI;
        this.name = name;
        this.age = age;
        this.role = role;
        this.id = this.role + "-" + this.DNI;
    }

}
