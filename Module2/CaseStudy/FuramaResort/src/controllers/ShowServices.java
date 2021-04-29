package controllers;

import data.IOFile;
import models.House;
import models.Room;
import models.Services;
import models.Villa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowServices {
    static Scanner scanner = new Scanner(System.in);

    public static void showServices() {

        int choice;
        do {
            System.out.println("Please choose 1 option!");
            System.out.println("1. Show All Villa");
            System.out.println("2. Show All House");
            System.out.println("3. Show All Room");
            System.out.println("4. Show All Name Villa Not Duplicate");
            System.out.println("5. Show All Name House Not Duplicate");
            System.out.println("6. Show All Name Name Not Duplicate");
            System.out.println("7. Back To Menu");
            System.out.println("8. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    IOFile.showAllVilla();
                    break;
                case 2:
                    IOFile.showAllHouse();
                    break;
                case 3:
                    IOFile.showAllRoom();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    MainControllers.displayMainMenu();
                    break;
                case 8:
                    System.exit(0);
            }
        } while (choice != 8);
    }
}