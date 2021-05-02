package input_output;

import controllers.MainController;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class ReadService {
    private static String VILLA = "villa";
    private static String HOUSE = "house";
    private static String ROOM = "room";

    public static List<Services> readAllServices(String fileName) {
        IOFile.setFilePath(fileName);
        List<String> dataServices = IOFile.readFile();
        List<Services> listServices = new ArrayList<>();
        String[] dataElements;
        Services services = null;
        for (String data : dataServices) {
            dataElements = data.split(IOString.COMMA);
            if (fileName.equals(VILLA)) {
                services = new Villa();

                ((Villa) services).setStandard(dataElements[6]);
                ((Villa) services).setOtherInfo(dataElements[7]);
                ((Villa) services).setPoolArea(Double.parseDouble(dataElements[8]));
                ((Villa) services).setNumberOfFloors(Integer.parseInt(dataElements[9]));
            } else if (fileName.equals(HOUSE)) {
                services = new House();

                ((House) services).setStandard(dataElements[6]);
                ((House) services).setOtherInfo(dataElements[7]);
                ((House) services).setNumberOfFloors(Integer.parseInt(dataElements[8]));
            } else if (fileName.equals(ROOM)) {
                ExtraService extraService = new ExtraService(dataElements[6],dataElements[7],Double.parseDouble(dataElements[8]));
                services = new Room();
                ((Room) services).setExtraService(extraService);
            }

            services.setId(dataElements[0]);
            services.setServiceName(dataElements[1]);
            services.setAreaUsage(Double.parseDouble(dataElements[2]));
            services.setRentCost(Double.parseDouble(dataElements[3]));
            services.setMaxGuests(Integer.parseInt(dataElements[4]));
            services.setRentType(dataElements[5]);

            listServices.add(services);
        }
        return listServices;
    }
}
