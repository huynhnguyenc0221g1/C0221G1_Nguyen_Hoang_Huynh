package commons;

public class GenderException extends Exception{
    public GenderException() {
        super("Gender must be Male, Female or Unknown!");
    }
}
