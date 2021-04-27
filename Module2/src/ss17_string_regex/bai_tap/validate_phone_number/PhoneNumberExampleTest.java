package ss17_string_regex.bai_tap.validate_phone_number;

public class PhoneNumberExampleTest {
    private static PhoneNumberExample phoneNumberExample;
    public static final String[] validPhoneNumber = new String[]{"(84)-(0978489648)", "(84)-(0123456789)", "(84)-(0935660697)"};
    public static final String[] invalidPhoneNumber = new String[]{"(a8)-(22222222)", "(84)-(1234567890)", "84-0978489648"};

    public static void main(String[] args) {
        phoneNumberExample = new PhoneNumberExample();
        for (String phoneNumber : validPhoneNumber) {
            boolean isValid = phoneNumberExample.validate(phoneNumber);
            System.out.println("Phone number " + phoneNumber + " is valid: " + isValid);
        }
        for (String phoneNumber : invalidPhoneNumber) {
            boolean isValid = phoneNumberExample.validate(phoneNumber);
            System.out.println("Phone number " + phoneNumber + " is valid: " + isValid);
        }
    }
}
