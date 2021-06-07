package commons;

public class CustomerCodeException extends Exception{
    public CustomerCodeException() {
        super("Customer Code must contain 'KH' and 4 digits with the format: KH-XXXX");
    }
}
