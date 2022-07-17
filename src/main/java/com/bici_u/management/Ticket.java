package com.bici_u.management;

import com.bici_u.tools.IO;
import java.time.LocalDateTime;

public class Ticket {

    private String ID;
    private String bicycleID;
    private String username;
    private String userID;
    private String date;
    private String startHour;
    private String endHour;
    private Boolean hasHelmet;
    private Boolean inGoodState;
    private String status;
    private Integer cost;

    public String generateID(int currentID) {
        currentID += 1;
        int Num = currentID;
        return ("T-" + String.format("%03d", Num));
    }

    public Ticket(String bicycleID, String username, String userID) {
        this.ID = generateID(IO.ImportUsers().size());
        this.bicycleID = bicycleID;
        this.username = username;
        this.userID = userID;
        this.date = LocalDateTime.now().toString().split("T")[0];
        this.startHour = LocalDateTime.now().toString();
        this.endHour = null;
        this.hasHelmet = true;
        this.inGoodState = true;
        this.status = "Active";
        this.cost = 0;
    }

    public Ticket(String ID, String bicycleID,String username, String userID, String date, String startHour, String endHour, Boolean hasHelmet, Boolean inGoodState,String status, Integer cost) {
        this.ID = ID;
        this.bicycleID = bicycleID;
        this.username = username;
        this.userID = userID;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
        this.hasHelmet = hasHelmet;
        this.inGoodState = inGoodState;
        this.status = status;
        this.cost = cost;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "ID='" + ID + '\'' +
                ", bicycleID='" + bicycleID + '\'' +
                ", username='" + username + '\'' +
                ", userID='" + userID + '\'' +
                ", date='" + date + '\'' +
                ", startHour='" + startHour + '\'' +
                ", endHour='" + endHour + '\'' +
                ", hasHelmet=" + hasHelmet +
                ", inGoodState=" + inGoodState +
                ", status='" + status + '\'' +
                ", cost=" + cost +
                '}';
    }
}

