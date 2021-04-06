package ss6_inheritance.bai_tap.point2D_point3D;

public class Point2D {
    protected float x = 0.0f;
    protected float y = 0.0f;
    public Point2D(){}

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float[] getXY() {
        float[] XY = new float[2];
        XY[0] = this.x;
        XY[1] = this.y;
        return XY;
    }
    public String toString(){
        return "("+getXY()[0]+","+getXY()[1]+")";
    }

}
