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
    private static List<Ticket> tickets = IO.ImportTickets();
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
            System.out.println("User Created!\n" + user);
            users.add(user);
            IO.export(users);
        } else {
            System.out.println("You must be 18 years or older to create an user");
        }
    }

    public static void borrowBicycle() {

        System.out.println("BORROW BICYCLE");
        String ID = input.Str("Your user ID (ex: P-1234 or S-5678):");
        User user;
        try {
            user = (User) Query.byAttribute(ID, "getID", users).get(0);
        } catch (IndexOutOfBoundsException e){
            System.out.println("No user with that ID was found, make sure to check if you're registered!");
            return;
        }

        List<Ticket> userTickets = Query.byAttribute(ID,"getUserID",tickets);
        List<Ticket> pendingTickets = Query.byAttribute("Pending","getStatus",userTickets);

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
            System.out.println("You have tickets pending for payment... please pay them before borrowing!\n");
            pendingTickets.forEach(ticket -> System.out.println(ticket.toString()));
        }
    }

    public static void returnBicycle() {
        String ticketID = input.Str("Input your ticket ID:");
        List<Ticket> ticketQuery = Query.byAttribute(ticketID,"getID",tickets);
        Ticket ticket;
        if (!ticketQuery.isEmpty()){
            ticket = ticketQuery.get(0);
            boolean hasHelmet = input.boolYN("Do you have the helmet in good state? (Y/N):");
            ticket.setHasHelmet(hasHelmet);
            boolean inGoodState = input.boolYN("Is the bicycle in good state? (Y/N):");
            ticket.setInGoodState(inGoodState);
            ticket.updateCost();
            if (ticket.getCost() > 0){
                ticket.setStatus("Pending");
            } else {
                ticket.setStatus("OK");
            }

            Bicycle bike = (Bicycle) Query.byAttribute(ticket.getBicycleID(),"getID",bicycles).get(0);
            int indexOfBike = bicycles.indexOf(bike);
            bike.setAvailable(true);
            bicycles.set(indexOfBike,bike);
            IO.export(bicycles);

            int indexOfTicket = tickets.indexOf(ticket);
            tickets.set(indexOfTicket,ticket);
            IO.export(tickets);

            System.out.println("Ticket updated!\n\n" + ticket);
        } else {
            System.out.println("No ticket with that ID was found!");
        }
    }

    public static void payTicket() {
        System.out.println("Pay Ticket");
        String ID = input.Str("Input the ticket ID to pay:");
        Ticket ticket;
        try {
            ticket = Query.byAttribute(ID, "getID", tickets).get(0);
        } catch (IndexOutOfBoundsException e){
            System.out.println("No Ticket with that ID was found, please check your Ticket ID!");
            return;
        }

        if (ticket.getStatus().equals("OK")){
            System.out.println("This Ticket has not debt or has been already payed out!\n");
            return;
        } else if (ticket.getStatus().equals("Active")){
            System.out.println("This Ticket is Active, please, return the bicycle first!\n");
            return;
        } else {
            System.out.println(ticket);
            Boolean proceed = input.boolYN("Proceed with payment? (Y/N)");
            if (proceed){
                System.out.println("Ticket payed!\n");
                int indexOfTicket = tickets.indexOf(ticket);
                ticket.setCost(0);
                ticket.setStatus("OK");
                tickets.set(indexOfTicket,ticket);
                IO.export(tickets);
            }
            else {
                System.out.println("Payment wasn't saved! \n");
            }
        }
    }

    public static void ticketHistory() {
        Integer option = 0;
        while (option <= 0 || option > 4){
            System.out.println(
                    """
                    1. Show all tickets
                    2. Show by User ID
                    3. Show by Status
                    4. return to menu
                    """);
            option = input.Int("Select an option:");
        }
        switch (option){
            case(1):
                for (Ticket ticket: tickets){
                    ticket.displayTicket();
                }
                break;
            case(2):
                String userID = input.Str("UserID for query:");
                List<Ticket> userTickets = Query.byAttribute(userID,"getUserID",tickets);
                for (Ticket ticket: userTickets){
                    ticket.displayTicket();
                }
                break;
            case(3):
                String status = input.Str("status for query:");
                List<Ticket> statusTickets = Query.byAttribute(status,"getStatus",tickets);
                for (Ticket ticket: statusTickets){
                    ticket.displayTicket();
                }
                break;
            default:
                break;
        }
    }
}
