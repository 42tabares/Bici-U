package com.bici_u.tools;

import java.util.Scanner;

public class Input {

        public String Str(String string){
            System.out.println(string);
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }

        public Integer Int(String string){
            System.out.println(string);
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        }
}

