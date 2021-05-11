package controllers;

import commons.IOFile;
import commons.IOString;
import commons.Validators;
import models.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static Scanner scanner = new Scanner(System.in);
    public static final String TRUCK = "truck";
    public static final String CAR = "car";
    public static final String BIKE = "bike";
    public static final String MANUFACTURER = "manufacturer";
    public static boolean exit = false;
    public static boolean back = false;

    public static void displayMainMenu() {
        int choiceMainMenu = 0;
        System.out.println("Vehicle Managing Program:\n"
                + "1. Add a new vehicle\n"
                + "2. Show all vehicle\n"
                + "3. Delete an vehicle\n"
                + "4. Exit\n");
        System.out.println("Please choose an option:");
        choiceMainMenu = scanner.nextInt();
        do {
            switch (choiceMainMenu) {
                case 1:
                    addNewVehicle();
                    break;
                case 2:
                    showAllVehicle();
                    break;
                case 3:
                    deleteVehicle();
                    break;
                case 4:
                    exit = true;
                    break;
            }
            if (exit) {
                break;
            }
        } while (choiceMainMenu >= 1 && choiceMainMenu <= 4);
    }

    private static void addNewVehicle() {
        int choiceAddNewVehicle = 0;
        do {
            System.out.println("1.\tAdd New Truck\n" +
                    "2.\tAdd New Car\n" +
                    "3.\tAdd New Bike\n" +
                    "4.\tBack To Main Menu\n" +
                    "5.\tExit");
            System.out.println("Please choose one option above:");
            choiceAddNewVehicle = scanner.nextInt();

            switch (choiceAddNewVehicle) {
                case 1:
                    addVehicle(TRUCK);
                    displayMainMenu();
                    break;
                case 2:
                    addVehicle(CAR);
                    displayMainMenu();
                    break;
                case 3:
                    addVehicle(BIKE);
                    displayMainMenu();
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
        } while (choiceAddNewVehicle >= 1 && choiceAddNewVehicle <= 3);
    }

    private static void addVehicle(String fileName) {
        IOFile.setFilePath(fileName);
        scanner.nextLine();
        String numberPlate = null;
        String typeCar = null;
        if (fileName.equals(TRUCK)) {
            do {
                System.out.println("Please input Vehicle's Number Plate:");
                numberPlate = scanner.nextLine();
            } while (!Validators.inputValidate(numberPlate,Validators.TRUCK_REGEX));
        } else if (fileName.equals(CAR)) {
            int choiceCar = 0;
                System.out.println("1.\tTour Car\n" +
                        "2.\tPassenger Car\n");
                System.out.println("Please choose one option above:");
                choiceCar = scanner.nextInt();
                scanner.nextLine();
                switch (choiceCar) {
                    case 1:
                        do {
                            System.out.println("Please input Vehicle's Number Plate:");
                            numberPlate = scanner.nextLine();
                        } while (!Validators.inputValidate(numberPlate, Validators.TOUR_CAR_REGEX));
                        typeCar = "Tour Car";
                        break;
                    case 2:
                        do {
                            System.out.println("Please input Vehicle's Number Plate:");
                            numberPlate = scanner.nextLine();
                        } while (!Validators.inputValidate(numberPlate, Validators.PASSENGER_CAR_REGEX));
                        typeCar = "Passenger Car";
                        break;
                }
        } else if (fileName.equals(BIKE)) {
            do {
                System.out.println("Please input Vehicle's Number Plate:");
                numberPlate = scanner.nextLine();
            } while (!Validators.inputValidate(numberPlate,Validators.BIKE_REGEX));
        }
        String manufacturerName = null;
        System.out.println("***************************");
        System.out.println("Manufacturers List:");
        List<Manufacturer> manufacturerList = readAllManufacturer();
        for (Manufacturer manufacturer : manufacturerList) {
            System.out.println((manufacturerList.indexOf(manufacturer)+1)+"\t"+manufacturer.getNameManufacturer());
        }
        System.out.println("***************************");
        System.out.println("Please select Vehicle's Manufacturer (By choosing number):");
        int choiceManufacturer = scanner.nextInt();
        manufacturerName = manufacturerList.get(choiceManufacturer-1).getNameManufacturer();
        int yearProduct = 0;
        System.out.println("Please input Vehicle's production year:");
        yearProduct = scanner.nextInt();
        String owner = null;
        scanner.nextLine();
        System.out.println("Please input Vehicle's owner:");
        owner = scanner.nextLine();
        if (fileName.equals(TRUCK)) {
            double loadAmount = 0;
            System.out.println("Please input Vehicle's Load Amount:");
            loadAmount = scanner.nextDouble();
            IOFile.setFilePath(fileName);
            IOFile.writeFile(new String[]{numberPlate, manufacturerName, String.valueOf(yearProduct), owner, String.valueOf(loadAmount)});
        } else if (fileName.equals(CAR)) {
            int numberOfSeat = 0;
            System.out.println("Please input Vehicle's Number Of Seats:");
            numberOfSeat = scanner.nextInt();
            IOFile.setFilePath(fileName);
            IOFile.writeFile(new String[]{numberPlate, manufacturerName, String.valueOf(yearProduct), owner, String.valueOf(numberOfSeat), typeCar});
        } else if (fileName.equals(BIKE)) {
            double horsePower = 0;
            System.out.println("Please input Vehicle's Horse-Power:");
            horsePower = scanner.nextDouble();
            IOFile.setFilePath(fileName);
            IOFile.writeFile(new String[]{numberPlate, manufacturerName, String.valueOf(yearProduct), owner, String.valueOf(horsePower)});
        }
    }

    public static List<Manufacturer> readAllManufacturer() {
        IOFile.setFilePath(MANUFACTURER);
        List<String> dataManufacturer = IOFile.readFile();
        List<Manufacturer> listManufacturer = new ArrayList<>();
        String[] dataElements;
        Manufacturer manufacturer = null;
        for (String data: dataManufacturer) {
            dataElements = data.split(IOString.COMMA);
            manufacturer = new Manufacturer();
            manufacturer.setIdManufacturer(dataElements[0]);
            manufacturer.setNameManufacturer(dataElements[1]);
            manufacturer.setNationalityManufacturer(dataElements[2]);
            listManufacturer.add(manufacturer);
        }
        return listManufacturer;
    }

    public static List<Vehicle> readAllVehicle(String fileName) {
        IOFile.setFilePath(fileName);
        List<String> dataVehicle = IOFile.readFile();
        List<Vehicle> listVehicle = new ArrayList<>();
        String[] dataElements;
        Vehicle vehicle = null;
        for (String data : dataVehicle) {
            dataElements = data.split(IOString.COMMA);
            if (fileName.equals(TRUCK)) {
                vehicle = new Truck();
                ((Truck) vehicle).setLoadAmount(Double.parseDouble(dataElements[4]));
            } else if (fileName.equals(CAR)) {
                vehicle = new Car();
                ((Car) vehicle).setNumberOfSeats(Integer.parseInt(dataElements[4]));
                ((Car) vehicle).setType(dataElements[5]);
            } else if (fileName.equals(BIKE)) {
                vehicle = new Bike();
                ((Bike) vehicle).setHorsePower(Double.parseDouble(dataElements[4]));
            }
            vehicle.setNumberPlate(dataElements[0]);
            vehicle.setManufacturer(dataElements[1]);
            vehicle.setYearProduced(Integer.parseInt(dataElements[2]));
            vehicle.setOwner(dataElements[3]);
            listVehicle.add(vehicle);
        }
        return listVehicle;
    }

    private static void showAllVehicle() {
        String choice;
        do {
            System.out.println("1.\tShow all Trucks\n" +
                    "2.\tShow all Cars\n" +
                    "3.\tShow all Bikes\n" +
                    "4.\tBack To Main Menu\n" +
                    "5.\tExit");
            System.out.println("Please choose one option above:");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showVehicle(TRUCK);
                    displayMainMenu();
                    break;
                case "2":
                    showVehicle(CAR);
                    displayMainMenu();
                    break;
                case "3":
                    showVehicle(BIKE);
                    displayMainMenu();
                    break;
                case "4":
                    back = true;
                    displayMainMenu();
                    break;
                case "5":
                    exit=true;
                default:
                    System.out.println("Not a valid option! Please input again!");
            }
            if (back || exit) {
                return;
            }
        } while (choice != "5");
    }

    private static void showVehicle(String fileName) {
        System.out.println("***************************");
        System.out.println("Vehicles List:");
        for (Vehicle vehicle : readAllVehicle(fileName)) {
            vehicle.showInfo();
        }
        System.out.println("***************************");
    }

    private static void deleteVehicle() {
        List<Vehicle> truckList = new ArrayList<>(readAllVehicle(TRUCK));
        List<Vehicle> carList = new ArrayList<>(readAllVehicle(CAR));
        List<Vehicle> bikeList = new ArrayList<>(readAllVehicle(BIKE));
        scanner.nextLine();
        System.out.println("***************************");
        String deleteNumberPlate = null;
        System.out.println("Please input a number plate that you want to delete in the database:");
        do {
            deleteNumberPlate = scanner.nextLine();
        } while (!Validators.inputValidate(deleteNumberPlate,Validators.NUMBER_PLATE_REGEX));
        int countTruck = 0;
        int idTruck = 0;
        int countCar = 0;
        int idCar = 0;
        int countBike = 0;
        int idBike = 0;
        for (Vehicle truck: truckList) {
            if (deleteNumberPlate.equals(truck.getNumberPlate())) {
                countTruck++;
                idTruck = truckList.indexOf(truck);
            }
        }
        for (Vehicle car: carList) {
            if (deleteNumberPlate.equals(car.getNumberPlate())) {
                countCar++;
                idCar = carList.indexOf(car);
            }
        }
        for (Vehicle bike: bikeList) {
            if (deleteNumberPlate.equals(bike.getNumberPlate())) {
                countBike++;
                idBike = truckList.indexOf(bike);
            }
        }
        if (countTruck!=0||countBike!=0||countCar!=0) {
            int choiceDelete = 0;
            System.out.println("Founded number plate " + deleteNumberPlate + " in the Database! Do you want to delete it?\n"
            +"1.\tYes\n"
            +"2.\tNo");
            choiceDelete = scanner.nextInt();
            switch (choiceDelete) {
                case 1:
                    if (countTruck != 0) {
                        truckList.remove(idTruck);
                        Truck truck1 = (Truck) truckList.get(0);
                        IOFile.setFilePath(TRUCK);
                        IOFile.overWriteFile(new String[] {truck1.getNumberPlate(),truck1.getManufacturer(), String.valueOf(truck1.getYearProduced()),
                                truck1.getOwner(), String.valueOf(truck1.getLoadAmount())});
                        for (int i = 1; i<truckList.size(); i++) {
                            Truck otherTruck = (Truck) truckList.get(i);
                            IOFile.writeFile(new String[] {otherTruck.getNumberPlate(),otherTruck.getManufacturer(), String.valueOf(otherTruck.getYearProduced()),
                                    otherTruck.getOwner(), String.valueOf(otherTruck.getLoadAmount())});
                        }
                        System.out.println("Successfully deleted truck with number plate " + deleteNumberPlate + " in the truck.csv file");
                        System.out.println("PRESS ENTER TO GO BACK TO THE MAIN MENU!");
                        scanner.nextLine();
                    }
                    if (countCar != 0) {
                        carList.remove(idCar);
                        Car car1 = (Car) carList.get(0);
                        IOFile.setFilePath(CAR);
                        IOFile.overWriteFile(new String[] {car1.getNumberPlate(),car1.getManufacturer(), String.valueOf(car1.getYearProduced()),
                                car1.getOwner(), String.valueOf(car1.getNumberOfSeats()),car1.getType()});
                        for (int i = 1; i<carList.size(); i++) {
                            Car otherCar = (Car) carList.get(i);
                            IOFile.writeFile(new String[] {otherCar.getNumberPlate(),otherCar.getManufacturer(), String.valueOf(otherCar.getYearProduced()),
                                    otherCar.getOwner(), String.valueOf(otherCar.getNumberOfSeats()),otherCar.getType()});
                        }
                        System.out.println("Successfully deleted car with number plate " + deleteNumberPlate + " in the car.csv file");
                        System.out.println("PRESS ENTER TO GO BACK TO THE MAIN MENU!");
                        scanner.nextLine();
                    }
                    if (countBike != 0) {
                        bikeList.remove(idBike);
                        Bike bike1 = (Bike) bikeList.get(0);
                        IOFile.setFilePath(BIKE);
                        IOFile.overWriteFile(new String[] {bike1.getNumberPlate(),bike1.getManufacturer(), String.valueOf(bike1.getYearProduced()),
                                bike1.getOwner(), String.valueOf(bike1.getHorsePower())});
                        for (int i = 1; i<bikeList.size(); i++) {
                            Bike otherBike = (Bike) bikeList.get(i);
                            IOFile.writeFile(new String[] {otherBike.getNumberPlate(),otherBike.getManufacturer(), String.valueOf(otherBike.getYearProduced()),
                                    otherBike.getOwner(), String.valueOf(otherBike.getHorsePower())});
                        }
                        System.out.println("Successfully deleted bike with number plate " + deleteNumberPlate + " in the bike.csv file");
                        System.out.println("PRESS ENTER TO GO BACK TO THE MAIN MENU!");
                        scanner.nextLine();
                    }
                    displayMainMenu();
                    break;
                case 2:
                    displayMainMenu();
                    break;
            }
        }
        if (countTruck == 0 && countCar == 0 && countBike == 0) {
            System.out.println("Couldn't find the number plate " + deleteNumberPlate + " in the database!");
        }
        System.out.println("PRESS ENTER TO GO BACK TO THE MAIN MENU!");
        scanner.nextLine();
        displayMainMenu();
    }
}
