package ss14_exception_debug.bai_tap.illegal_triangle_exception;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Triangle triangle = new Triangle();
        boolean done = false;

        System.out.println("Enter three sides: ");

        while (!done) {
            Scanner scanner = new Scanner(System.in);
            try {
                double side1 = scanner.nextDouble();
                double side2 = scanner.nextDouble();
                double side3 = scanner.nextDouble();
                triangle = new Triangle(side1, side2, side3);
                done = true;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
                System.out.println("Enter three sides:  ");
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Must input number!");
                System.out.println("Enter three sides: ");
            }
        }
        System.out.println("Valid triangle!");

    }
}
