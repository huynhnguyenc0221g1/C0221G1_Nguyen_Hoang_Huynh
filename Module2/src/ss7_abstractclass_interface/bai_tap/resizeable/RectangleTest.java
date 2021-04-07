package ss7_abstractclass_interface.bai_tap.resizeable;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rectangle);

        System.out.println("Resize the last rectangle by 50%");
        rectangle.resize(60);
        System.out.println(rectangle);
    }
}
