package ss17_string_regex.bai_tap.validate_class_name;

import java.util.regex.*;

public class ClassNameExample {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String CLASS_NAME_REGEX = "^[CAP]\\d{4}[GHIKLM]$";

    public ClassNameExample() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(CLASS_NAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

