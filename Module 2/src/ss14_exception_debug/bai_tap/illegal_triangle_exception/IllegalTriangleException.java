package ss14_exception_debug.bai_tap.illegal_triangle_exception;

public class IllegalTriangleException extends Exception {
    private double side = 1.0;
    public IllegalTriangleException(double side) {
            super("Not a valid triangle because " + side);
    }
    public double getSide() {
        return side;
    }
}
