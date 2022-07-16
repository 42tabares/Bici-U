package com.bici_u.management;


import java.time.LocalDateTime;

public class Ticket {

    static int generalID = 0;
    private String ID;
    private String bicycleID;
    private User user;
    private String date;
    private LocalDateTime startHour;
    private LocalDateTime endHour;
    private Boolean hasHelmet;
    private Boolean inGoodState;

    public String generateID(int currentID) {

        generalID += 1;
        int Num = generalID;
        return ("T-" + String.format("%03d", Num));
    }

    public Ticket(String bicycleID, User user) {
        this.ID = generateID(generalID);
        this.bicycleID = bicycleID;
        this.user = user;
        this.date = LocalDateTime.now().toString().split("T")[0];
        this.startHour = LocalDateTime.now();
        this.endHour = null;


    }
}

