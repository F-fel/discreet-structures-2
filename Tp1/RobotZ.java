package Tp1;

public class RobotZ extends RobotAbs {
    static final int MAX_KILO_ = 25;
    RobotZ() {
        super();
    }
    public double computeK(){
       return super.computeK(2.5,0.2);
    }
}
