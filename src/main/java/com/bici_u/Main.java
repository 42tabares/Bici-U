package com.bici_u;

import com.bici_u.tools.Input;
import com.bici_u.menu.MainMenu;

public class Main {
    public static void main(String[] args) {

        Input input = new Input();
        boolean execute = true;

        do {
            System.out.println("-- BICI U --");
            System.out.println("Main Menu \n");
            System.out.println(
                    """
                    1. Register User.
                    2. Borrow Bicycle.
                    3. Return Bicycle.
                    4. Pay Tickets.
                    5. Tickets History.
                    6. Exit.
                    """);

            int option = input.Int("Select an option:");

            switch (option) {
                case (1) -> MainMenu.createUser();
                case (2) -> MainMenu.borrowBicycle();
                case (3) -> MainMenu.returnBycicle();
                case (4) -> MainMenu.payTicket();
                case (5) -> MainMenu.ticketHistory();
                case (6) -> execute = false;
                default -> System.out.println("Not a valid option");
            }
        } while(execute);

    }
}
