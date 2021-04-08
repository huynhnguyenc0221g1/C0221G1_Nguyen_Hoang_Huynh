package ss7_abstractclass_interface.bai_tap.colorable;

public class TestCase {
    public static void main(String[] args) {
        Shape circle1 = new Circle();
        Shape circle2 = new Circle(23);
        Shape rectangle = new Rectangle();
        Shape square1 = new Square();
        Shape square2 = new Square(2);
        Shape square3 = new Square(123.4);
        Shape[] shapes = {square1,circle1,rectangle,square2,circle2,square3};
        for (Shape shape: shapes) {
            System.out.println(shape);
            if (shape instanceof Square) {
                shape.howToColor();
            }
            System.out.println();
        }
        }

    }
