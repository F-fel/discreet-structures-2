package Tp1;

public class RobotX extends RobotAbs{
    static final int MAX_KILO_ = 5;
    RobotX() {
        super();
    }

    public double computeK() {
        return super.computeK(1,1);
    }
}
