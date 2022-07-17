package com.bici_u.management;

import com.bici_u.tools.IO;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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
        int Num = currentID+1;
        return ("T-" + String.format("%03d", Num));
    }

    public Ticket(String bicycleID, String username, String userID) {
        this.ID = generateID(IO.ImportTickets().size());
        this.bicycleID = bicycleID;
        this.username = username;
        this.userID = userID;
        this.date = LocalDateTime.now().toString().split("T")[0];
        this.startHour = LocalDateTime.now().toString();
        this.endHour = "yyyy-mm-ddTPending...";
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

    public String getStatus() {
        return status;
    }

    public Integer getCost() {
        return cost;
    }

    public void setHasHelmet(Boolean hasHelmet) {
        this.hasHelmet = hasHelmet;
    }

    public void setInGoodState(Boolean inGoodState) {
        this.inGoodState = inGoodState;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "TICKET INFO:"        + '\n' + '\n' +
                "Ticket ID: "        + ID + '\n' +
                "Bicycle ID: "       + bicycleID + '\n' +
                "User's name: "      + username + '\n' +
                "User's ID: "        + userID + '\n' +
                "Date: "             + date + '\n' +
                "Start Hour: "       + startHour.split("T")[1] + '\n' +
                "End Hour: "         + endHour.split("T")[1] + '\n' +
                "Helmet: "           + hasHelmet + '\n' +
                "in Good State: "    + inGoodState + '\n'+
                "Status: "           + status + '\n' +
                "cost: "             + cost + '\n';
    }

    public void updateCost() {
        Integer cost = 0;

        LocalDateTime startHour = LocalDateTime.parse(this.startHour);
        this.endHour = LocalDateTime.now().toString();
        LocalDateTime endHour   = LocalDateTime.now();
        Long minutesLong = ChronoUnit.MINUTES.between(startHour,endHour);
        Integer minutes = (int) (long) minutesLong;
        double halfHours = Math.floor(minutes/30);
        Integer costTime = (int) (double) halfHours*3;

        this.cost += costTime;

        if (!this.hasHelmet){
            this.cost += 5;
        }
        if (!this.inGoodState){
            this.cost += 5;
        }
    }

    public void displayTicket(){
        System.out.println(this.ID + "\t\t" + this.userID + "\t\t" + this.username + "\t\t" + this.cost + "\t\t" + this.status);
    }
}

