package ss17_string_regex.bai_tap.validate_phone_number;

import java.util.regex.*;

public class PhoneNumberExample {
    public static Pattern pattern;
    public Matcher matcher;

    private static final String PHONE_NUMBER_REGEX = "^\\(\\d{2}\\)\\-\\([0]\\d{9}\\)$";

    public PhoneNumberExample() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
