package ss04_oop.bai_tap;

class Fan {
    private final int slow = 1;
    private final int medium = 2;
    private final int fast = 3;
    private int speed = slow;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public int getSpeed() {
        return this.speed;
    }

    public int setSpeed(int speed) {
        return this.speed = speed;
    }

    public boolean getOn() {
        return this.on;
    }

    public boolean setOn(boolean on) {
        return this.on = on;
    }

    public double getRadius() {
        return this.radius;
    }

    public double setRadius(double radius) {
        return this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public String setColor(String color) {
        return this.color = color;
    }

    public Fan() {
    }

    Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public String toString() {
        String speedString = "slow";
        if (this.speed == slow) {
            speedString = "slow";
        } else if (this.speed == medium) {
            speedString = "medium";
        } else {
            speedString = "fast";
        }
        if (this.on) {
            return "Speed: " + speedString + ", radius: " + this.radius + ", color: " + this.color + ", fan is on.";
        } else {
            return "Speed: " + speedString + ", radius: " + this.radius + ", color: " + this.color + ", fan is off.";

        }
    }
}

public class Thiet_ke_lop_Fan {
    public static void main(String[] args) {
        final int slow = 1;
        final int medium = 2;
        final int fast = 3;
        Fan fan1 = new Fan(fast, true, 10, "yellow");
        Fan fan2 = new Fan(medium, false, 5, "blue");
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
