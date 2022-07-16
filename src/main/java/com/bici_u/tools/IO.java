package com.bici_u.tools;

import java.io.*;


public class IO {

    public static String importBicycles(String fileName, String identifier){

        String result = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String testLine;
            while ((testLine = reader.readLine()) != null) {

            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static void overwrite(String fileName, String identifier, String newText){


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Lorem Ipsum");
        }
        catch(IOException e){
            System.out.println("No text found to overwrite");
        }
    }
}
