package com.bici_u.management;

public class Bicycle {

    private String code;
    private String bikeType;
    private String color;

    private Boolean isAvailable;

    public Bicycle(String code, String bikeType, String color, boolean isAvailable) {
        this.code = code;
        this.bikeType = bikeType;
        this.color = color;
        this.isAvailable = isAvailable;
    }

    public String toOutputFormat(){
        return this.code + ";" + this.bikeType + ";" + this.color + ";" + this.isAvailable + "\n" ;
    }
}
