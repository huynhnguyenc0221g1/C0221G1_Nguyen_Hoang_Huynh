package commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    public static final String NAME_REGEX = "\\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+";
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean inputValidate(String inputString, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(inputString);
        boolean valid = matcher.matches();
        return valid;
    }
}
