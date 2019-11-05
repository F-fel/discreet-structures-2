package Tp1;

public class RobotY extends RobotAbs {
    static final int MAX_KILO_ = 10;
    RobotY() {
        super();
    }
    public double computeK(){
        return super.computeK(1.5,0.6);
    }
}
