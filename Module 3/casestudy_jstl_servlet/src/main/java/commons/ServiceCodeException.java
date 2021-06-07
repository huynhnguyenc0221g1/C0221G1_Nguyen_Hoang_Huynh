package commons;

public class ServiceCodeException extends Exception{
    public ServiceCodeException() {
        super("Service Code must contain 'DV' and 4 digits with the format: DV-XXXX");
    }
}
