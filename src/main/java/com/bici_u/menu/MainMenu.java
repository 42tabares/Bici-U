package com.bici_u.menu;

import com.bici_u.management.Bicycle;
import com.bici_u.management.Ticket;
import com.bici_u.management.User;
import com.bici_u.tools.IO;
import com.bici_u.tools.Input;
import com.bici_u.tools.Query;

import java.util.ArrayList;
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
        String ID = input.Str("Your user ID (ex: P-1234 or S-5678):");

        List<User> queryUser = Query.byAttribute(ID,"getID",users);
        User user = null;
        try{
            user = queryUser.get(0);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("No user found with that ID! make sure you're registered!");
        }

        List<Ticket> userTickets = Query.byAttribute(ID,"getID",tickets);
        List<Ticket> pendingTickets = new ArrayList<>();
        for (Ticket ticket: userTickets) {
            if (ticket.getCost() > 0) {
                pendingTickets.add(ticket);
            }
        }

        if (pendingTickets.isEmpty()){
            String requiredType = input.Str("What type of Bicycle do you want? (Mountain or Road)");
            List<Bicycle> availableTypes = Query.byAttribute(requiredType,"getBikeType",bicycles);
            List<Bicycle> availableBikes = Query.byAttribute(true,"getAvailable",availableTypes);
            if (!availableBikes.isEmpty()){

                Bicycle selectedBike = availableBikes.get(0);
                Integer indexOfBike = bicycles.indexOf(selectedBike);
                selectedBike.setAvailable(false);
                bicycles.set(indexOfBike,selectedBike);
                IO.export(bicycles);

                Ticket newTicket = new Ticket(selectedBike.getID(),user.getName(),user.getID());
                tickets.add(newTicket);
                IO.export(tickets);

                System.out.println("Lending Successful!");
                System.out.println(newTicket);

            }
            else {
                System.out.println("Sorry! no " + requiredType + " Bikes are available, please check later!");
            }
        } else {
            System.out.println("You have tickets pending for payment...");
            pendingTickets.forEach(ticket -> System.out.println(ticket.toString()));
        }
    }

    public static void returnBicycle() {

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
