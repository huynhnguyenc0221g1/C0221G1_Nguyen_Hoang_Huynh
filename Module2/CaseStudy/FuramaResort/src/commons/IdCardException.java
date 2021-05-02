package commons;

public class IdCardException extends Exception{
    public IdCardException() {
        super("ID Number must contain 9 digits with the format: XXX XXX XXX !");
    }
}
