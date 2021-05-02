package controllers;

import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean exit = false;
    public static void displayMainMenu() {
        int choice = 0;
        System.out.println("1.\t Add New Services\n" +
                "2.\tShow Services\n" +
                "3.\tAdd New Customer\n" +
                "4.\tShow Information of Customer\n" +
                "5.\tAdd New Booking\n" +
                "6.\tShow Information of Employee\n" +
                "7.\tExit\n");
        System.out.println("Please choose one option above:");
        choice = scanner.nextInt();
        do {
            switch (choice) {
                case 1:
                    addNewService();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomer();
                    break;
                case 4:
                    showInformationOfCustomer();
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInformationOfEmployee();
                    break;
                case 7:
                    exit = true;
            }
            if (exit) {
                break;
            }
        } while (choice >=1 && choice <=7);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void addNewService() {
    }

    private static void showServices() {
    }

    private static void addNewCustomer() {
    }

    private static void showInformationOfCustomer() {
    }

    private static void addNewBooking() {
    }

    private static void showInformationOfEmployee() {
    }
}