package ss6_inheritance.bai_tap.point_moveablePoint;

public class MoveablePointTest {
    public static void main(String[] args) {
        Point move1 = new MoveablePoint();
        System.out.println(move1);
        move1.setXY(12, 33);
        System.out.println(move1);
        ((MoveablePoint) move1).setSpeed(8, 7);
        System.out.println(move1);
        ((MoveablePoint) move1).move();
        System.out.println(move1);
    }
}
