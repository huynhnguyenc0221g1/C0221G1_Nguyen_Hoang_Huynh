package ss06_inheritance.bai_tap.circle_cylinder;

public class Circle {
    private double radius = 1.0;
    private String color = "red";
    final private double PI = 3.14;
    public Circle() {};
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return Math.pow(this.radius,2)*PI;
    }
    public String toString() {
        return "A circle has a radius of " + getRadius()
                + ", which is filled with color " + getColor() +
                " and has a area of " + getArea();
    }
}
