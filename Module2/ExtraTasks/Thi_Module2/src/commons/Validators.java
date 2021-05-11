package commons;

import java.time.Year;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
//    public static final String TRUCK_REGEX = "^[\\d]{2}C-[\\d]{3}.[\\d]{2}$";;
    public static final String PHONE_NUMBER_REGEX = "^[\\d]{4}-[\\d]{6}$";
    public static final String EMAIL_REGEX = "^[\\w]{1,}@[\\w]{1,}.com$";
    public static final String EMPTY = ".+";
    public static final String GENDER = "Nam|Nữ|Khác";
    private static Pattern pattern;
    private static Matcher matcher;
    public static boolean inputValidate(String vehicleString, String vehicleRegex) {
        pattern = Pattern.compile(vehicleRegex);
        matcher = pattern.matcher(vehicleString);
        boolean valid = matcher.matches();
        if (!valid) {
            System.out.println("Du lieu nhap khong trung khop dinh dang " + vehicleRegex);
        }
        return valid;
    }
}
