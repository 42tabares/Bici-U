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

    public User(String DNI, String name, int age, String role, String id) {
        this.DNI = DNI;
        this.name = name;
        this.age = age;
        this.role = role;
        this.id = id;
    }

    @Override
    public String toString() {
        return "USER INFO:        \n" +
                "NAME:" + name + '\n' +
                "ID:"   + age  + '\n' +
                "AGE:"  + id   + '\n';
    }

    public String getDNI() {
        return DNI;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }

    public String getId() {
        return id;
    }
}
