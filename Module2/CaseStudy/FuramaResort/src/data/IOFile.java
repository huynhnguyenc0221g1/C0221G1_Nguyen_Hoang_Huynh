package data;

import models.House;
import models.Room;
import models.Services;
import models.Villa;

import java.io.*;
import java.util.*;

public class IOFile {
    public static void writeAllVillaToFile(List<Services> villaList) {
        File csvFile = new File("src/data/Villa.csv");
        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile));) {
            for (Services item : villaList) {
                csvWriter.println(item);
            }
            PrintWriter out = new PrintWriter(new FileWriter("src/data/Villa.csv", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showAllVilla() {
        List<Services> villaFinalList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/data/Villa.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                String serviceName = temp[0];
                double villaAreaUsage = Double.parseDouble(temp[1]);
                double villaRentPrice = Double.parseDouble(temp[2]);
                int villaMaximumGuests = Integer.parseInt(temp[3]);
                String villaRentingOption = temp[4];
                String villaID = temp[5];
                String villaStandard = temp[6];
                String villaAmenities = temp[7];
                double villaPoolSize = Double.parseDouble(temp[8]);
                int villaFloors = Integer.parseInt(temp[9]);
                villaFinalList.add(new Villa(serviceName, villaAreaUsage, villaRentPrice, villaMaximumGuests, villaRentingOption
                        , villaID, villaStandard, villaAmenities, villaPoolSize, villaFloors));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Services villa : villaFinalList) {
            System.out.println(villa.showInfor());
        }
    }

    public static void writeAllHouseToFile(List<Services> houseList) {
        File csvFile = new File("src/data/House.csv");
        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile));) {
            for (Services item : houseList) {
                csvWriter.println(item);
            }
            PrintWriter out = new PrintWriter(new FileWriter("src/data/House.csv", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showAllHouse() {
        List<Services> houseFinalList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/data/House.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                String serviceName = temp[0];
                double houseAreaUsage = Double.parseDouble(temp[1]);
                double houseRentPrice = Double.parseDouble(temp[2]);
                int houseMaximumGuests = Integer.parseInt(temp[3]);
                String houseRentingOption = temp[4];
                String houseID = temp[5];
                String houseStandard = temp[6];
                String houseAmenities = temp[7];
                int houseFloors = Integer.parseInt(temp[8]);
                houseFinalList.add(new House(serviceName, houseAreaUsage, houseRentPrice, houseMaximumGuests, houseRentingOption
                        , houseID, houseStandard, houseAmenities, houseFloors));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Services house : houseFinalList) {
            System.out.println(house.showInfor());
        }
    }

    public static void writeAllRoomToFile(List<Services> roomList) {
        File csvFile = new File("src/data/Room.csv");
        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile));) {
            for (Services item : roomList) {
                csvWriter.println(item);
            }
            PrintWriter out = new PrintWriter(new FileWriter("src/data/Room.csv", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showAllRoom() {
        List<Services> roomFinalList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/data/Room.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                String serviceName = temp[0];
                double roomAreaUsage = Double.parseDouble(temp[1]);
                double roomRentPrice = Double.parseDouble(temp[2]);
                int roomMaximumGuests = Integer.parseInt(temp[3]);
                String roomRentingOption = temp[4];
                String roomID = temp[5];
                String roomAmenities = temp[6];
                roomFinalList.add(new Room(serviceName, roomAreaUsage, roomRentPrice, roomMaximumGuests, roomRentingOption, roomID, roomAmenities));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Services room : roomFinalList) {
            System.out.println(room.showInfor());
        }
    }
}