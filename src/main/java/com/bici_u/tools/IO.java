package com.bici_u.tools;
import com.bici_u.management.Bicycle;
import com.bici_u.management.Ticket;
import com.bici_u.management.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class IO {

    public static List ImportBicycles(){
        List bikes = new ArrayList();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("data/bicycles.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(";");
                Bicycle bike = new Bicycle(items[0], items[1], items[2], Boolean.valueOf(items[3]));
                bikes.add(bike);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return bikes;
    }
    public static List ImportUsers(){
        List users = new ArrayList();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("data/users.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(";");
                User user = new User(items[0],items[1],Integer.valueOf(items[2]),items[3],items[4]);
                users.add(user);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return users;
    }
    public static List ImportTickets(){
        List tickets = new ArrayList();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("data/tickets.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(";");
                Ticket ticket = new Ticket(items[0],items[1],items[2],items[3],items[4],items[5],items[6],Boolean.valueOf(items[7]),Boolean.valueOf(items[8]),items[9],Integer.valueOf(items[10]));
                tickets.add(ticket);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return tickets;
    }

    public static void export(List list){
        Object object = list.get(0);
        String objectType = object.getClass().toString();
        String path = switch (objectType) {
            case ("class com.bici_u.management.Bicycle") -> "data/bicycles.txt";
            case ("class com.bici_u.management.Ticket") -> "data/tickets.txt";
            case ("class com.bici_u.management.User") -> "data/users.txt";
            default -> "data/";
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for(Object item : list){
                writer.write(StringUtils.toOutputFormat(item) + "\n");
            }
        }
        catch(IOException e){
            System.out.println(e);
        }catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
