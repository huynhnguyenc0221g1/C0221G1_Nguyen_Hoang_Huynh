package commons;

import java.time.Year;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    public static final String SERVICE_ID_REGEX = "^SV(VL|HO|RO)-[\\d]{4}$";
    public static final String NAME_REGEX = "[A-Z][a-z]*";
    public static final String ID_NUMBER_REGEX = "[\\d]{3} [\\d]{3} [\\d]{3}";
    public static final String BIRTHDATE_REGEX = "[\\d]{2}/[\\d]{2}/[\\d]{4}";
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean inputValidate(String serviceString, String serviceRegex) {
        pattern = Pattern.compile(serviceRegex);
        matcher = pattern.matcher(serviceString);
        boolean valid = matcher.matches();
        if (!valid) {
            System.out.println("Input is not matching " + serviceRegex);
        }
        return valid;
    }

    public static boolean greaterThan(double number, double minNumber) {
        boolean valid = number > minNumber;

        if (!valid) {
            System.out.println("Input is not greater than " + minNumber);
        }
        return valid;
    }

    public static boolean inRangeOf(double number, double minNumber, double maxNumber) {
        boolean valid = number > minNumber && number < maxNumber;

        if (!valid) {
            System.out.println("Input is not in the range of " + minNumber + " and " + maxNumber);
        }
        return valid;
    }

    public static boolean validExtraServiceName(String extraServiceName) {
        String[] listValidExtraServices = {"massage", "karaoke", "food", "drink", "car"};
        boolean valid = Arrays.asList(listValidExtraServices).contains(extraServiceName);
        if (!valid) {
            System.out.println(extraServiceName + " is not available! Please choose again!");
        }
        return valid;
    }

    public static void validCustomerName(String fullName) throws NameException {
        String[] fullNameParts = fullName.split(" ");

        for (String namePart:fullNameParts) {
            if (Character.isLowerCase(namePart.charAt(0))) {
                throw new NameException();
            }
        }

        for (int i = 0; i < fullName.length() - 1; i++) {
            if (fullName.charAt(i) == ' ' && fullName.charAt(i+1) == ' ') {
                throw new NameException();
            }
        }
    }

    public static void validCustomerEmail(String email) throws EmailException {
        int atSymbolPosition = email.indexOf("@");
        int dotSymbolPosition = email.indexOf(".");

        if (atSymbolPosition < 0) {
            throw new EmailException();
        }

        int atSymbolCount = 0;
        int dotSymbolCount = 0;

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i)=='@') {
                atSymbolCount++;
            } else if (email.charAt(i)=='.') {
                dotSymbolCount++;
            }
            if (atSymbolPosition >= 2) {
                throw new EmailException();
            }
        }
        if (dotSymbolCount == 0) {
            throw new EmailException();
        }
    }

    public static void validGender(String gender) throws GenderException {
        String[] genderList = {"male","female","unknown"};
        if (!Arrays.asList(genderList).contains(gender.toLowerCase())) {
            throw new GenderException();
        }
    }

    public static void validIDNumber(String idNumber) throws IdCardException {
        if (!inputValidate(idNumber,ID_NUMBER_REGEX)) {
            throw new IdCardException();
        }
    }

    public static void validBirthdate(String birthdate) throws BirthdayException {
        if (inputValidate(birthdate,BIRTHDATE_REGEX)) {
            int birthYear = Integer.parseInt(birthdate.split("/")[2]);
            int currentYear = Year.now().getValue();
            if (birthYear <= 1900 || currentYear - birthYear < 18) {
                throw new BirthdayException();
            }
        } else {
            throw new BirthdayException();
        }
    }
}
