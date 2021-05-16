package commons;

public class BirthdayException extends Exception{
    public BirthdayException() {
        super("Birth Year must be greater than 1900, Age must be more than 18 years old and Birthdate format must be dd/mm/yyyy!");
    }
}
