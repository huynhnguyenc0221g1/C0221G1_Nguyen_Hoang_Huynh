package commons;

public class IDCardException extends Exception{
    public IDCardException() {
        super("ID Number must contain 9 or 12 digits");
    }
}
