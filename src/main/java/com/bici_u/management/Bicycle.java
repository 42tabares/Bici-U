package com.bici_u.management;

public class Bicycle {

    private String ID;
    private String bikeType;
    private String color;

    private Boolean available;

    public Bicycle(String code, String bikeType, String color, boolean isAvailable) {
        this.ID = code;
        this.bikeType = bikeType;
        this.color = color;
        this.available = isAvailable;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "code='" + ID + '\'' +
                ", bikeType='" + bikeType + '\'' +
                ", color='" + color + '\'' +
                ", isAvailable=" + available +
                '}';
    }

    public String getID() {
        return ID;
    }

    public String getBikeType() {
        return bikeType;
    }

    public String getColor() {
        return color;
    }

    public Boolean getAvailable() {
        return available;
    }


    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
