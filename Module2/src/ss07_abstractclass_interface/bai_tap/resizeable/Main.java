package ss07_abstractclass_interface.bai_tap.resizeable;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        Shape square = new Square();
        Shape[] shapes = {circle,rectangle,square};
        System.out.println("Before Resize:");
        for (Shape shape: shapes) {
            System.out.println(shape);
        }

        System.out.println("After Resize:");
        for (Shape shape: shapes) {
            int random = (int) (Math.random()*100);
            shape.resize(random);
            System.out.println(shape + " (Resized by " + random + "%)");
        }

    }
}
