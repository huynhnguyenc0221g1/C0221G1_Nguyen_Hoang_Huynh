package commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    public static final String CUSTOMER_REGEX = "^KH-[\\d]{4}$";
    public static final String SERVICE_REGEX = "^DV-[\\d]{4}$";
    public static final String PHONE_NUMBER_REGEX = "(^0(90|91)[0-9]{7}$)|(^[(]84[)][+](90|91)[0-9]{7}$)";
    public static final String ID_NUMBER_REGEX = "(^[0-9]{9}$)|(^[0-9]{12}$)";
    public static final String EMAIL_REGEX = "^[\\w]{1,}@[\\w]{1,}.[\\w]{1,}$";
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean inputValidate(String inputString, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(inputString);
        boolean valid = matcher.matches();
        return valid;
    }
}
