package ss6_inheritance.bai_tap.circle_cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Circle cylinder1 = new Cylinder();
        System.out.println(cylinder1);
        Circle cylinder2 = new Cylinder(3.5,"Black",2.0);
        System.out.println(cylinder2);
    }
}
