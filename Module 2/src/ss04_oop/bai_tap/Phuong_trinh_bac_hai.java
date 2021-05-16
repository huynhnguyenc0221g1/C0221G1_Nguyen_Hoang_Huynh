package ss04_oop.bai_tap;

import java.util.Scanner;

class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    private double delta;

    public QuadraticEquation() {
    }

    QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    void getDiscriminant() {
        this.delta = Math.pow(this.b, 2) - this.a * this.c * 4;
    }

    void getRoot() {
        double root1;
        if (this.delta < 0) {
            System.out.println("Equation has no root!");
        } else if (this.delta == 0) {
            root1 = (-this.b) / (2 * this.a);
            System.out.println("Equation has a double root: " + root1);
        } else {
            root1 = (-this.b + Math.sqrt(this.delta)) / (2 * this.a);
            double root2 = (-this.b - Math.sqrt(this.delta)) / (2 * this.a);
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
        }
    }
}

public class Phuong_trinh_bac_hai {
    public static void main(String[] args) {
        double a,b,c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quadratic Equation (ax^{2}+bx+c=0)");
        System.out.println("Input a: ");
        a = scanner.nextDouble();
        System.out.println("Input b: ");
        b = scanner.nextDouble();
        System.out.println("Input c: ");
        c = scanner.nextDouble();
        QuadraticEquation userEquation = new QuadraticEquation(a,b,c);
        userEquation.getDiscriminant();
        userEquation.getRoot();
    }
}
