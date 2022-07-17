package com.bici_u.menu;

import com.bici_u.management.Bicycle;
import com.bici_u.tools.IO;

import java.util.List;

public class MainMenu {

    public static void createUser(){
        System.out.println("Create User");

    }

    public static void borrowBicycle() {
        System.out.println("Borrow Bicycle");
    }

    public static void returnBicycle() {
        System.out.println("Return Bicycle");
    }

    public static void payTicket() {
        System.out.println("Pay Ticket");
    }

    public static void ticketHistory() {
        List bicyclesList = IO.ImportBicycles();
        for (Object bike: bicyclesList) {
            System.out.println(bike);
        }
    }
}
