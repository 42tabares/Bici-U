package com.bici_u.tools;
import com.bici_u.management.Bicycle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IO {

    public static List ImportBicycles(){
        List Bikes = new ArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/bicycle.txt"))) {
            String[] items = reader.readLine().split(";");
            Bicycle bike = new Bicycle(items[0],items[1],items[2],Boolean.valueOf(items[3]));
            Bikes.add(bike);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return Bikes;
    }
}
