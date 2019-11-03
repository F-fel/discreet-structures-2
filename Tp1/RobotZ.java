package Tp1;

public class RobotZ extends RobotAbs {
    RobotZ() {
        super(25);
    }
    public double computeK(){
       return super.computeK(2.5,0.2);
    }
}
