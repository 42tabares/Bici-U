package com.bici_u.management;


import java.time.LocalDateTime;

public class Ticket {

    static int generalID = 0;
    private String ID;
    private String bicycleID;
    private String username;
    private String userID;
    private String date;
    private String startHour;
    private String endHour;
    private Boolean hasHelmet;
    private Boolean inGoodState;

    public String generateID(int currentID) {

        generalID += 1;
        int Num = generalID;
        return ("T-" + String.format("%03d", Num));
    }

    public Ticket(String bicycleID, String username, String userID) {
        this.ID = generateID(generalID);
        this.bicycleID = bicycleID;
        this.username = username;
        this.userID = userID;
        this.date = LocalDateTime.now().toString().split("T")[0];
        this.startHour = LocalDateTime.now().toString();
        this.endHour = null;
        this.hasHelmet = true;
        this.inGoodState = true;
    }

    public Ticket(String ID, String bicycleID,String username, String userID, String date, String startHour, String endHour, Boolean hasHelmet, Boolean inGoodState) {
        this.ID = ID;
        this.bicycleID = bicycleID;
        this.username = username;
        this.userID = userID;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
        this.hasHelmet = hasHelmet;
        this.inGoodState = inGoodState;
    }

    public static int getGeneralID() {
        return generalID;
    }

    public String getID() {
        return ID;
    }

    public String getBicycleID() {
        return bicycleID;
    }

    public String getUsername() {
        return username;
    }

    public String getUserID() {
        return userID;
    }

    public String getDate() {
        return date;
    }

    public String getStartHour() {
        return startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public Boolean getHasHelmet() {
        return hasHelmet;
    }

    public Boolean getInGoodState() {
        return inGoodState;
    }

}

