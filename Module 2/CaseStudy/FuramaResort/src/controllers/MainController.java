package controllers;

import commons.*;
import models.*;

import java.util.*;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean exit = false;
    private static String VILLA = "villa";
    private static String HOUSE = "house";
    private static String ROOM = "room";
    private static String CUSTOMER = "customer";
    private static String BOOKING = "booking";
    private static String EMPLOYEE = "employee";
    private static boolean back = false;

    public static void displayMainMenu() {
        int choice = 0;
        System.out.println("1.\tAdd New Services\n" +
                "2.\tShow Services\n" +
                "3.\tAdd New Customer\n" +
                "4.\tShow Information of Customer\n" +
                "5.\tAdd New Booking\n" +
                "6.\tShow Information of Employee\n" +
                "7.\tShow 4D Theatre's Queue\n" +
                "8.\tSearch for Employee's Information in the File Cabinet\n" +
                "9.\tExit\n");
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
                    addNewCustomer(CUSTOMER);
                    displayMainMenu();
                    break;
                case 4:
                    showInformationOfCustomer(CUSTOMER);
                    displayMainMenu();
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInformationOfEmployee(EMPLOYEE);
                    displayMainMenu();
                    break;
                case 7:
                    show4DTheatreQueue();
                    break;
                case 8:
                    searchEmployeeInFileCabinet();
                    displayMainMenu();
                    break;
                case 9:
                    exit = true;
            }
            if (exit) {
                break;
            }
        } while (choice >= 1 && choice <= 9);
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
        String id = null;
        do {
            System.out.println("Please input Service's ID:");
            id = scanner.nextLine();
        } while (!Validators.inputValidate(id, Validators.SERVICE_ID_REGEX));
        String serviceName = null;
        do {
            System.out.println("Please input Service's name:");
            serviceName = scanner.nextLine();
        } while (!Validators.inputValidate(serviceName, Validators.NAME_REGEX));
        double areaUsage = 0.0;
        do {
            System.out.println("Please input Usage Area");
            areaUsage = scanner.nextDouble();
        } while (!Validators.greaterThan(areaUsage, 30));
        double rentCost = 0.0;
        do {
            System.out.println("Please input Rent Cost:");
            rentCost = scanner.nextDouble();
        } while (!Validators.greaterThan(rentCost, 0));
        int maxGuests = 0;
        do {
            System.out.println("Please input Maximum Number of Guests:");
            maxGuests = scanner.nextInt();
        } while (!Validators.inRangeOf(maxGuests, 0, 20));
        scanner.nextLine();
        String typeRent = null;
        do {
            System.out.println("Please input Rent Type:");
            typeRent = scanner.nextLine();
        } while (!Validators.inputValidate(typeRent, Validators.NAME_REGEX));
        IOFile.setFilePath(fileName);
        if (fileName.equals(VILLA)) {
            String standard = null;
            do {
                System.out.println("Please input Villa's Standard:");
                standard = scanner.nextLine();
            } while (!Validators.inputValidate(standard, Validators.NAME_REGEX));
            System.out.println("Please input Villa's other Descriptions:");
            String otherDescription = scanner.nextLine();
            double areaPool = 0.0;
            do {
                System.out.println("Please input Villa's pool area:");
                areaPool = scanner.nextDouble();
            } while (!Validators.greaterThan(areaPool, 30));
            int numberOfFloors = 0;
            do {
                System.out.println("Please input number of Villa's floors:");
                numberOfFloors = scanner.nextInt();
            } while (!Validators.greaterThan(numberOfFloors, 0));
            IOFile.writeFile(new String[]{id, serviceName, String.valueOf(areaUsage), String.valueOf(rentCost), String.valueOf(maxGuests), typeRent, standard, otherDescription, String.valueOf(areaPool), String.valueOf(numberOfFloors)});
        } else if (fileName.equals(HOUSE)) {
            String standard = null;
            do {
                System.out.println("Please input House's Standard:");
                standard = scanner.nextLine();
            } while (!Validators.inputValidate(standard, Validators.NAME_REGEX));

            System.out.println("Please input House's other Descriptions:");
            String otherDescription = scanner.nextLine();
            int numberOfFloors = 0;
            do {
                System.out.println("Please input number of House's floors:");
                numberOfFloors = scanner.nextInt();
            } while (!Validators.greaterThan(numberOfFloors, 0));
            IOFile.writeFile(new String[]{id, serviceName, String.valueOf(areaUsage), String.valueOf(rentCost), String.valueOf(maxGuests), typeRent, standard, otherDescription, String.valueOf(numberOfFloors)});
        } else if (fileName.equals(ROOM)) {
            String nameOfExtraService = null;
            do {
                System.out.println("Please input Extra Service's name:");
                nameOfExtraService = scanner.nextLine();
            } while (!Validators.validExtraServiceName(nameOfExtraService));
            System.out.println("Please input Extra Service's unit:");
            String unitOfExtraService = scanner.nextLine();
            System.out.println("Please input Extra Service's price:");
            double priceOfExtraService = scanner.nextDouble();
            IOFile.writeFile(new String[]{id, serviceName, String.valueOf(areaUsage), String.valueOf(rentCost), String.valueOf(maxGuests), typeRent, nameOfExtraService, unitOfExtraService, String.valueOf(priceOfExtraService)});
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

        } while (choice >= 1 && choice <= 8);
    }

    private static void showAllService(String fileName) {
        System.out.println("***************************");
        System.out.println("Services List:");
        for (Services services : ReadService.readAllServices(fileName)) {
            services.showInfo();
        }
        System.out.println("***************************");
    }

    private static void showAllServiceNotDuplicate(String fileName) {
        Set<String> setServices = new TreeSet<>();

        System.out.println("***************************");
        System.out.println("Services List (Not Duplicated):");
        for (Services services : ReadService.readAllServices(fileName)) {
            setServices.add(services.getServiceName());
        }

        for (String serviceName : setServices) {
            System.out.println(serviceName);
        }

        System.out.println("***************************");

    }

    private static void addNewCustomer(String fileName) {
        scanner.nextLine();
        boolean inputCheck = true;
        String fullName = null;
        do {
            inputCheck = true;
            System.out.println("Please input Customer's Name:");
            fullName = scanner.nextLine();
            try {
                Validators.validCustomerName(fullName);
            } catch (NameException e) {
                inputCheck = false;
                e.printStackTrace();
            }
        } while(!inputCheck);
        String dateOfBirth = null;
        do {
            inputCheck = true;
            System.out.println("Please input Customer's Date of Birth::");
            dateOfBirth = scanner.nextLine();
            try {
                Validators.validBirthdate(dateOfBirth);
            } catch (BirthdayException e) {
                inputCheck = false;
                e.printStackTrace();
            }
        } while(!inputCheck);
        String gender = null;
        do {
            inputCheck = true;
            System.out.println("Please input Customer's Gender:");
            gender = scanner.nextLine();
            try {
                Validators.validGender(gender);
            } catch (GenderException e) {
                inputCheck = false;
                e.printStackTrace();
            }
        } while (!inputCheck);
        String idNumber = null;
        do {
            inputCheck = true;
            System.out.println("Please input Customer's ID Number:");
            idNumber = scanner.nextLine();
            try {
                Validators.validIDNumber(idNumber);
            } catch (IdCardException e) {
                inputCheck = false;
                e.printStackTrace();
            }
        } while(!inputCheck);
        System.out.println("Please input Customer's Phone Number:");
        String phoneNumber = scanner.nextLine();
        String email = null;
        do {
            inputCheck = true;
            System.out.println("Please input Customer's Email:");
            email = scanner.nextLine();
            try {
                Validators.validCustomerEmail(email);
            } catch (EmailException e) {
                inputCheck = false;
                e.printStackTrace();
            }
        } while (!inputCheck);
        System.out.println("Please input Customer's Type:");
        String typeOfCustomer = scanner.nextLine();
        System.out.println("Please input Customer's Address:");
        String address = scanner.nextLine();
        IOFile.setFilePath(fileName);
        IOFile.writeFile(new String[] {fullName,dateOfBirth,IOConvert.normalizeString(gender),idNumber,phoneNumber,email,typeOfCustomer,address});
    }

    private static void showInformationOfCustomer(String fileName) {
        System.out.println("***************************");
        System.out.println("List of Customers:");
        List<Customer> customersList = ReadCustomer.readCustomer(fileName);
        Collections.sort(customersList);
        for (Customer customer: customersList) {
            customer.showInfo();
        }
        System.out.println("***************************");
    }

    private static void addNewBooking() {
        System.out.println("***************************");
        System.out.println("List of Customers at the moment:");
        List<Customer> customersList = ReadCustomer.readCustomer(CUSTOMER);
        for (Customer customer: customersList) {
            customer.showInfo();
        }
        System.out.println("Which customer is going to commit this booking?");
        int choiceCustomer = scanner.nextInt();
        Customer bookingCustomer = customersList.get(choiceCustomer);
        int choiceBookingOption = 0;
        do {
            System.out.println("1.\tBooking Villa\n" +
                    "2.\tBooking House\n" +
                    "3.\tBooking Room\n");
            System.out.println("Please choose one option above:");
            choiceBookingOption = scanner.nextInt();
            switch (choiceBookingOption) {
                case 1:
                    bookingVilla(bookingCustomer);
                    displayMainMenu();
                    break;
                case 2:
                    bookingHouse(bookingCustomer);
                    displayMainMenu();
                    break;
                case 3:
                    bookingRoom(bookingCustomer);
                    break;
            }
        } while (choiceBookingOption >= 1 && choiceBookingOption <= 3);
    }

    private static void bookingVilla(Customer bookingCustomer) {
        System.out.println("***************************");
        System.out.println("List of Villas at the moment:");
        List<Services> villaList = ReadService.readAllServices(VILLA);
        for (Services villa: villaList) {
            villa.showInfo();
        }
        System.out.println("Which villa do you want to add to the current booking?");
        int choiceVilla = scanner.nextInt();
        Services bookingVilla = villaList.get(choiceVilla);
        IOFile.setFilePath(BOOKING);
        IOFile.writeFile(new String[] {bookingCustomer.getFullName(),bookingCustomer.getDateOfBirth(),bookingCustomer.getGender()
                ,bookingCustomer.getIdNumber(),bookingCustomer.getPhoneNumber(),bookingCustomer.getEmail(),bookingCustomer.getTypeOfCustomer(),
                bookingCustomer.getAddress(), String.valueOf(bookingVilla)});
        System.out.println("***************************");

    }

    private static void bookingHouse(Customer bookingCustomer) {
        System.out.println("***************************");
        System.out.println("List of Houses at the moment:");
        List<Services> houseList = ReadService.readAllServices(HOUSE);
        for (Services house: houseList) {
            house.showInfo();
        }
        System.out.println("Which house do you want to add to the current booking?");
        int choiceHouse = scanner.nextInt();
        Services bookingHouse = houseList.get(choiceHouse);
        IOFile.setFilePath(BOOKING);
        IOFile.writeFile(new String[] {bookingCustomer.getFullName(),bookingCustomer.getDateOfBirth(),bookingCustomer.getGender()
                ,bookingCustomer.getIdNumber(),bookingCustomer.getPhoneNumber(),bookingCustomer.getEmail(),bookingCustomer.getTypeOfCustomer(),
                bookingCustomer.getAddress(), String.valueOf(bookingHouse)});
        System.out.println("***************************");
    }


    private static void bookingRoom(Customer bookingCustomer) {
        System.out.println("***************************");
        System.out.println("List of Rooms at the moment:");
        List<Services> roomList = ReadService.readAllServices(ROOM);
        for (Services room: roomList) {
            room.showInfo();
        }
        System.out.println("Which room do you want to add to the current booking?");
        int choiceRoom = scanner.nextInt();
        Services bookingRoom = roomList.get(choiceRoom);
        IOFile.setFilePath(BOOKING);
        IOFile.writeFile(new String[] {bookingCustomer.getFullName(),bookingCustomer.getDateOfBirth(),bookingCustomer.getGender()
                ,bookingCustomer.getIdNumber(),bookingCustomer.getPhoneNumber(),bookingCustomer.getEmail(),bookingCustomer.getTypeOfCustomer(),
                bookingCustomer.getAddress(), String.valueOf(bookingRoom)});
        System.out.println("***************************");
    }

    private static void showInformationOfEmployee(String fileName) {
        int i = 1;
        System.out.println("***************************");
        System.out.println("List of Employee:");
        Map<String,Employee> employeeOfFuramaTreeMap = new HashMap<>();
        List<Employee> employeeList = ReadEmployee.readEmployee(fileName);
        for (Employee employee: employeeList) {
          employeeOfFuramaTreeMap.put("00"+i,employee);
          i++;
        }
        for (Map.Entry<String, Employee> element : employeeOfFuramaTreeMap.entrySet()) {
            System.out.println("Employee's ID: " + element.getKey() + " / " + element.getValue());
        }
    }

    private static void show4DTheatreQueue() {
        Queue<Customer> theatreQueue = new LinkedList<>();
        List<Customer> customerList = ReadCustomer.readCustomer(CUSTOMER);
        showInformationOfCustomer(CUSTOMER);
        theatreQueue.add(customerList.get(3));
        theatreQueue.add(customerList.get(4));
        theatreQueue.add(customerList.get(1));
        Customer customer = null;

        System.out.println("***************************");
        System.out.println("List of Customers who bought tickets at the 4D Theatre:");
        while (!theatreQueue.isEmpty()) {
            customer = theatreQueue.poll();
            customer.showInfo();
        }
        System.out.println("***************************");
    }

    private static void searchEmployeeInFileCabinet() {
        scanner.nextLine();
        System.out.println("***************************");
        System.out.println("Please input Employee's Name:");
        String employeeName = scanner.nextLine();
        List<Employee> employeeList = FileCabinet.getFileCabinet();
        Iterator iterator = employeeList.iterator();
        int count = 0;
        String employeeInfo = null;
        while(iterator.hasNext()){
            Employee value = (Employee) iterator.next();
            if (employeeName.toLowerCase().equals(value.getEmployeeName().toLowerCase())) {
                employeeInfo = value.toString();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Couldn't find the employee " + employeeName + " in the File Cabinet!");
        } else {
            System.out.println(employeeInfo);
        }
        System.out.println("***************************");
    }
}