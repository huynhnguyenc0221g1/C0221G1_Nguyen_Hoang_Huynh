package ss7_abstractclass_interface.thuc_hanh.comparator;
import ss6_inheritance.thuc_hanh.Shape;
import ss6_inheritance.thuc_hanh.Circle;
import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
}
