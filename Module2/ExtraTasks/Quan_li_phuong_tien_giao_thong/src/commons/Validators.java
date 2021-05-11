package commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    public static final String TRUCK_REGEX = "^[\\d]{2}C-[\\d]{3}.[\\d]{2}$";
    public static final String TOUR_CAR_REGEX = "^[\\d]{2}A-[\\d]{3}.[\\d]{2}$";
    public static final String PASSENGER_CAR_REGEX = "^[\\d]{2}B-[\\d]{3}.[\\d]{2}$";
    public static final String BIKE_REGEX = "^[\\d]{2}-[A-Z][\\d]-[\\d]{3}.[\\d]{2}$";
    public static final String NUMBER_PLATE_REGEX = "^([\\d]{2}C-[\\d]{3}.[\\d]{2})|([\\d]{2}A-[\\d]{3}.[\\d]{2})|([\\d]{2}B-[\\d]{3}.[\\d]{2})|([\\d]{2}-[A-Z][\\d]-[\\d]{3}.[\\d]{2})$";
    private static Pattern pattern;
    private static Matcher matcher;
    public static boolean inputValidate(String vehicleString, String vehicleRegex) {
        pattern = Pattern.compile(vehicleRegex);
        matcher = pattern.matcher(vehicleString);
        boolean valid = matcher.matches();
        if (!valid) {
            System.out.println("Input is not matching " + vehicleRegex);
        }
        return valid;
    }
}
