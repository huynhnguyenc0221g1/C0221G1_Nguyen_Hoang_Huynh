package ss6_inheritance.bai_tap.triangle;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the color of the triangle:");
        String color = scanner.nextLine();
        System.out.println("Please input side 1 of the triangle:");
        double side1 = scanner.nextInt();
        System.out.println("Please input side 2 of the triangle:");
        double side2 = scanner.nextInt();
        System.out.println("Please input side 3 of the triangle:");
        double side3 = scanner.nextInt();
        Shape triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        System.out.println(triangle);
    }
}
