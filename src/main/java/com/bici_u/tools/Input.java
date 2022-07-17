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

        public Boolean boolYN(String string){
            System.out.println(string);
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            if (str.equals("Y")){
                return true;
            } else {
                return false;
            }
        }
}

