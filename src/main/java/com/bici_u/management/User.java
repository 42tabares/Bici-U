package com.bici_u.management;

public class User {

    private String DNI;
    private String name;
    private int age;
    private String role;
    private String ID;

    public User(String DNI, String name, int age, String role) {
        this.DNI = DNI;
        this.name = name;
        this.age = age;
        this.role = role;
        this.ID = this.role + "-" + this.DNI;
    }

    public User(String DNI, String name, int age, String role, String id) {
        this.DNI = DNI;
        this.name = name;
        this.age = age;
        this.role = role;
        this.ID = id;
    }

    @Override
    public String toString() {
        return "USER INFO:        \n" +
                "NAME:" + name + '\n' +
                "USER ID:"   + ID  + '\n' +
                "AGE:"  + age   + '\n';
    }

    public String getID() {
        return ID;
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

}
