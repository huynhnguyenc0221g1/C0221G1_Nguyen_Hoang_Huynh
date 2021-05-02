package commons;

public class NameException extends Exception{
    public NameException() {
        super("First character must be an Uppercase!");
    }
}
