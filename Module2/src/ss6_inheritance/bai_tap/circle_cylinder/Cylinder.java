package ss6_inheritance.bai_tap.circle_cylinder;

public class Cylinder extends Circle {
    private double height = 1.0;
    public Cylinder(){};
    public Cylinder(double radius, String color, double height) {
        super(radius,color);
        this.height = height;

    }
    public double getHeight() {
        return this.height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume() {
        return super.getArea()*height;
    }
    public String toString() {
        return "A cylinder with the height of " + getHeight()
                + ", the radius of " + getRadius()
                + " and filled with color " + getColor()
                + ", which has a volume of " + getVolume()
                + ". Its' bottom place is " + super.toString();
    }
}
