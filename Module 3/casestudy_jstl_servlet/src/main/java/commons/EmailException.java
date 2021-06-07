package commons;

public class EmailException extends Exception{
    public EmailException() {
        super("Email is not in the right format!");
    }
}
