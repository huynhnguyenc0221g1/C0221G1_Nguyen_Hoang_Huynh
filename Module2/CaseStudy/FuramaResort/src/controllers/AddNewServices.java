package controllers;

import data.IOFile;
import models.*;

import java.io.*;
import java.util.*;

public class AddNewServices {
    static List<Services> villaList = new ArrayList<>();
    static List<Services> houseList = new ArrayList<>();
    static List<Services> roomList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addNewService() {
        int choice;
        do {
            System.out.println("Please choose 1 option!");
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back To Menu");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addNewVilla();
                    break;
                case 2:
                    addNewHouse();
                    break;
                case 3:
                    addNewRoom();
                    break;
                case 4:
                    MainControllers.displayMainMenu();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (choice != 5);
    }

    public static void addNewVilla() {
        System.out.println("Villa's Area Usage:");
        double villaAreaUsage = scanner.nextDouble();
        System.out.println("Villa's rent price:");
        double villaRentPrice = scanner.nextDouble();
        System.out.println("Villa's maximum guests:");
        int villaMaximumGuests = scanner.nextInt();
        System.out.println("Renting Option:");
        String villaRentingOption = scanner.next();
        System.out.println("Villa's ID");
        String villaID = scanner.next();
        System.out.println("Villa's standard:");
        String villaStandard = scanner.next();
        System.out.println("Villa's other amenities");
        String villaAmenities = scanner.next();
        System.out.println("Villa's pool size:");
        double villaPoolSize = scanner.nextDouble();
        System.out.println("Number of Villa's floors:");
        int villaFloors = scanner.nextInt();
        Services villa = new Villa("Villa", villaAreaUsage, villaRentPrice, villaMaximumGuests,
                villaRentingOption, villaID, villaStandard, villaAmenities, villaPoolSize, villaFloors);
        villaList.add(villa);
        IOFile.writeAllVillaToFile(villaList);
    }

    public static void addNewHouse() {
        System.out.println("House's Area Usage:");
        double houseAreaUsage = scanner.nextDouble();
        System.out.println("House's rent price:");
        double houseRentPrice = scanner.nextDouble();
        System.out.println("House's maximum guests:");
        int houseMaximumGuests = scanner.nextInt();
        System.out.println("Renting Option:");
        String houseRentingOption = scanner.next();
        System.out.println("House's ID");
        String houseID = scanner.next();
        System.out.println("House's standard:");
        String houseStandard = scanner.next();
        System.out.println("House's other amenities");
        String houseAmenities = scanner.next();
        System.out.println("Number of House's floors:");
        int houseFloors = scanner.nextInt();
        Services house = new House("House", houseAreaUsage, houseRentPrice, houseMaximumGuests
                , houseRentingOption, houseID, houseStandard, houseAmenities, houseFloors);
        houseList.add(house);
        IOFile.writeAllHouseToFile(houseList);
    }

    public static void addNewRoom() {
        System.out.println("Room's Area Usage:");
        double roomAreaUsage = scanner.nextDouble();
        System.out.println("Room's rent price:");
        double roomRentPrice = scanner.nextDouble();
        System.out.println("Room's maximum guests:");
        int roomMaximumGuests = scanner.nextInt();
        System.out.println("Renting Option:");
        String roomRentingOption = scanner.next();
        System.out.println("Room's ID");
        String roomID = scanner.next();
        System.out.println("Room's free amenities");
        String roomAmenities = scanner.next();
        Services room = new Room("Room", roomAreaUsage, roomRentPrice, roomMaximumGuests,
                roomRentingOption, roomID, roomAmenities);
        roomList.add(room);
        IOFile.writeAllRoomToFile(roomList);
    }

}
