package ss07_abstractclass_interface.bai_tap.resizeable;

public class Square extends Shape implements Resizeable {
    private double side = 1.0;
    public Square() {}
    public Square(double side) {
        this.side = side;
    }
    public Square(double side, String color, boolean filled) {
        super(color,filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side*side;
    }

    public double getPerimeter() {
        return side*4;
    }
    @Override
    public String toString() {
        return "A Square with side = "
                + getSide()
                + ", its' area = "
                + getArea();
    }
    @Override
    public void resize(double percent) {
        side = side * percent / 100;
    }
}

