package Tp1;

public class RobotY extends RobotAbs {

    RobotY() {
        super(10);
    }
    public double computeK(){
        return super.computeK(1.5,0.6);
    }
}
