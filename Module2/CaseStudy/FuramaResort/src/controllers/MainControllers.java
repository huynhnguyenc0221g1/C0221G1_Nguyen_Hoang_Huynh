package controllers;

import java.io.FileNotFoundException;
import java.util.*;

public class MainControllers {
    public static void displayMainMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Please choose 1 option!");
            System.out.println("1. Add New Services");
            System.out.println("2. Show Services");
            System.out.println("3. Add New Customer");
            System.out.println("4. Show Information of Customer");
            System.out.println("5. Add New Booking");
            System.out.println("6. Show Information of Employee");
            System.out.println("7. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    AddNewServices.addNewService();
                    break;
                case 2:
                    ShowServices.showServices();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
            }
        } while (choice != 7);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
