package ss6_inheritance.bai_tap.Triangle;

public class Shape {
    private String color = "red";
    public Shape(){}

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        return "Shape is filled with color " + getColor();
    }
}
