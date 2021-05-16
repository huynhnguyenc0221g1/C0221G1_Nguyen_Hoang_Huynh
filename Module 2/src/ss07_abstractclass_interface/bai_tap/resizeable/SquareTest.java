package ss07_abstractclass_interface.bai_tap.resizeable;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square(5.8, "yellow", true);
        System.out.println(square);

        System.out.println("Resize the last square by 40%");
        square.resize(40);
        System.out.println(square);
    }
}
