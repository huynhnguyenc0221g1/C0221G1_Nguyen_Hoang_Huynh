package ss14_exception_debug.bai_tap.illegal_triangle_exception;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Triangle triangle = new Triangle();
        boolean done = false;

        System.out.println("Enter three sides: ");

        while (!done) {
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
            }
        }
        System.out.println("Valid triangle!");

    }
}
