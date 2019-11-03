package Tp1;

public class RobotX extends RobotAbs{
    RobotX() {
        super(5);
    }

    public double computeK() {
        return super.computeK(1,1);
    }
}
