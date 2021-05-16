package ss07_abstractclass_interface.bai_tap.resizeable;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle(3.5, "indigo", false);
        System.out.println(circle);

        circle.resize(85);
        System.out.println("Resize the last circle by 85%");
        System.out.println(circle);
    }
}
