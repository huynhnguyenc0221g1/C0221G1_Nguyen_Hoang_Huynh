package controllers;

import input_output.IOFile;
import input_output.ReadService;
import models.Services;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean exit = false;
    private static String VILLA = "villa";
    private static String HOUSE = "house";
    private static String ROOM = "room";
    private static boolean back = false;

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
        } while (choice >= 1 && choice <= 7);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void addNewService() {
        int choice = 0;
        do {
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit\n");
            System.out.println("Please choose one option above:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addService(VILLA);
                    back = false;
                    break;
                case 2:
                    addService(HOUSE);
                    back = false;
                    break;
                case 3:
                    addService(ROOM);
                    back = false;
                    break;
                case 4:
                    back = true;
                    displayMainMenu();
                    break;
                case 5:
                    exit = true;
                    break;
            }

            if (back || exit) {
                return;
            }
        } while (choice >= 1 && choice <= 5);
    }

    private static void addService(String fileName) {
        scanner.nextLine();
        System.out.println("Please input Service's ID:");
        String id = scanner.nextLine();
        System.out.println("Please input Service's name:");
        String serviceName = scanner.nextLine();
        System.out.println("Please input Usage Area");
        double areaUsage = scanner.nextDouble();
        System.out.println("Please input Rent Cost:");
        double rentCost = scanner.nextDouble();
        System.out.println("Please input Maximum Number of Guests:");
        int maxGuests = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please input Rent Type:");
        String typeRent = scanner.nextLine();
        IOFile.setFilePath(fileName);
        if (fileName.equals(VILLA)) {
            System.out.println("Please input Villa's Standard:");
            String standard = scanner.nextLine();
            System.out.println("Please input Villa's other Descriptions:");
            String otherDescription = scanner.nextLine();
            System.out.println("Please input Villa's pool area:");
            double areaPool = scanner.nextDouble();
            System.out.println("Please input number of Villa's floors:");
            int numberOfFloors = scanner.nextInt();
            IOFile.writeFile(new String[]{id, serviceName, String.valueOf(areaUsage), String.valueOf(rentCost), String.valueOf(maxGuests), typeRent, standard, otherDescription, String.valueOf(areaPool), String.valueOf(numberOfFloors)});
        } else if (fileName.equals(HOUSE)) {
            System.out.println("Please input House's Standard:");
            String standard = scanner.nextLine();
            System.out.println("Please input House's other Descriptions:");
            String otherDescription = scanner.nextLine();
            System.out.println("Please input number of House's floors:");
            int numberOfFloors = scanner.nextInt();
            IOFile.writeFile(new String[]{id, serviceName, String.valueOf(areaUsage), String.valueOf(rentCost), String.valueOf(maxGuests), typeRent, standard, otherDescription, String.valueOf(numberOfFloors)});
        } else if (fileName.equals(ROOM)) {
            System.out.println("Please input Extra Service's name:");
            String nameOfExtraService = scanner.nextLine();
            System.out.println("Please input Extra Service's unit:");
            String unitOfExtraService = scanner.nextLine();
            System.out.println("Please input Extra Service's price:");
            double priceOfExtraService = scanner.nextDouble();
            IOFile.writeFile(new String[]{id, serviceName, String.valueOf(areaUsage), String.valueOf(rentCost), String.valueOf(maxGuests), typeRent, nameOfExtraService,unitOfExtraService, String.valueOf(priceOfExtraService)});
        }
    }

    private static void showServices() {
        int choice = 0;
        do {
                System.out.println("1.\tShow all Villa\n" +
                        "2.\tShow all House\n" +
                        "3.\tShow all Room\n" +
                        "4.\tShow All Name Villa Not Duplicate\n" +
                        "5.\tShow All Name House Not Duplicate\n" +
                        "6.\tShow All Name Name Not Duplicate\n" +
                        "7.\tBack to menu\n" +
                        "8.\tExit\n");
                System.out.println("Please choose one option above:");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        showAllService(VILLA);
                        back = false;
                        break;
                    case 2:
                        showAllService(HOUSE);
                        back = false;
                        break;
                    case 3:
                        showAllService(ROOM);
                        back = false;
                        break;
                    case 4:
                        showAllServiceNotDuplicate(VILLA);
                        back = true;
                        displayMainMenu();
                        break;
                    case 5:
                        showAllServiceNotDuplicate(HOUSE);
                        back = true;
                        displayMainMenu();
                        break;
                    case 6:
                        showAllServiceNotDuplicate(ROOM);
                        back = true;
                        displayMainMenu();
                        break;
                    case 7:
                        back = true;
                        displayMainMenu();
                        break;
                    case 8:
                        exit = true;
                        break;
                }

                if (back || exit) {
                    return;
                }

            } while (choice >= 1 && choice <= 8) ;
        }

    private static void showAllService(String fileName) {
        System.out.println("***************************");
        System.out.println("Services List:");
        for (Services services: ReadService.readAllServices(fileName)) {
            services.showInfo();
        }
        System.out.println("***************************");
    }

    private static void showAllServiceNotDuplicate(String fileName) {
        Set<String> setServices = new TreeSet<>();

        System.out.println("***************************");
        System.out.println("Services List (Not Duplicated):");
        for (Services services: ReadService.readAllServices(fileName)) {
            setServices.add(services.getServiceName());
        }

        for  (String serviceName: setServices) {
            System.out.println(serviceName);
        }

        System.out.println("***************************");

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