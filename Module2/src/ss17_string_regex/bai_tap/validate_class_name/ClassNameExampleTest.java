package ss17_string_regex.bai_tap.validate_class_name;

public class ClassNameExampleTest {
    private static ClassNameExample classNameExample;
    public static final String[] validClassName = new String[] {"C0318G","A3508I","P0711M"};
    public static final String[] invalidClassName = new String[] {"M0318G","P0323A","A131Z"};

    public static void main(String[] args) {
        classNameExample = new ClassNameExample();
        for (String className : validClassName) {
            boolean isValid = classNameExample.validate(className);
            System.out.println("Class's name " + className + " is valid: " + isValid);
        }
        for (String className : invalidClassName) {
            boolean isValid = classNameExample.validate(className);
            System.out.println("Class's name " + className + " is valid: " + isValid);
        }
    }
}
