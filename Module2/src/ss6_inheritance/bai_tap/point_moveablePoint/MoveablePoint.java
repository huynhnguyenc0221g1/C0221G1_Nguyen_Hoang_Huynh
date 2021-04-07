package ss6_inheritance.bai_tap.point_moveablePoint;

public class MoveablePoint extends Point{
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;
    MoveablePoint() {}

    MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.xSpeed = ySpeed;
    }

    MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x,y);
        this.xSpeed = xSpeed;
        this.xSpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed() {
        float[] getSpeed = new float[2];
        getSpeed[0] = this.xSpeed;
        getSpeed[1] = this.ySpeed;
        return getSpeed;
    }

    @Override
    public String toString() {
        return super.toString() + ",speed=("+getSpeed()[0]+","+getSpeed()[1]+")";
    }
    public MoveablePoint move() {
        setX(this.x += this.xSpeed);
        setY(this.y += this.ySpeed);
        return this;
    }
}
