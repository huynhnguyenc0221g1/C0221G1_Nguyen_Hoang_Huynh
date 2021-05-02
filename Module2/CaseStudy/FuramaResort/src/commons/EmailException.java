package commons;

public class EmailException extends Exception{
    public EmailException() {
        super("Email's format must be abc@abc.abc");
    }
}
