package com.bici_u.menu;

import com.bici_u.management.Bicycle;
import com.bici_u.management.Ticket;
import com.bici_u.management.User;
import com.bici_u.tools.IO;
import com.bici_u.tools.Input;
import com.bici_u.tools.Query;

import java.util.List;

public class MainMenu {

    private static Input input = new Input();
    private static List bicycles = IO.ImportBicycles();
    private static List users = IO.ImportUsers();
    private static List tickets = IO.ImportTickets();
    public static void createUser(){
        System.out.println("CREATE USER");

        String usertype = "";
        while (!usertype.equals("S") && !usertype.equals("P")) {
            usertype = input.Str("Your type of user Student (S) or Professor(P)");
        }
        String DNI = input.Str("Your DNI:");
        String name = input.Str("Your Name:");
        Integer age = input.Int("Your Age:");

        if (age >= 18){
            User user = new User(DNI,name,age,usertype);
            users.add(user);
            IO.export(users);
        } else {
            System.out.println("You must be 18 years or older to create an user");
        }
    }

    public static void borrowBicycle() {
        System.out.println("BORROW BICYCLE");
        String ID = input.Str("Your ID (ex: P-1234 or S-5678):");
        List userTickets = Query.byStringAttribute(ID,"getUserID",tickets);
        System.out.println(userTickets.toString());
    }

    public static void returnBicycle() {
        List userTickets = Query.byStringAttribute("Road","getBikeType",bicycles);
        System.out.println(userTickets.toString());
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
