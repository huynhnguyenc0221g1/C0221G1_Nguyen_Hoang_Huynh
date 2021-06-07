package commons;

public class PhoneNumberException extends Exception{
    public PhoneNumberException() {
        super("PHone number must be in the format: (0/((84)+))(90/91)XXXXXXX");
    }
}
