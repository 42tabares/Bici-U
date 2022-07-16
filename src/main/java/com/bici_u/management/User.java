package com.bici_u.management;

public class User {

    private String DNI;
    private String name;
    private int age;
    private UserRole role;
    private String id;

    public User(String DNI, String name, int age, UserRole role, String id) {
        this.DNI = DNI;
        this.name = name;
        this.age = age;
        this.role = role;
        this.id = this.role.roleID + "-" + this.DNI;
    }

}
