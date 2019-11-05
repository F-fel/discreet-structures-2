package Tp1;

import java.util.LinkedList;

enum robotType {X, Y, Z}

public class RobotAbs {
    final private int MAX_KILO_;
    private LinkedList<Objet> load_;
    private int loadWeight_;

    public int getMAX_KILO(){
        return MAX_KILO_;
    }


    RobotAbs(int max){
        MAX_KILO_ = max;
        load_ = new LinkedList<Objet>();
        loadWeight_ = 0;
    }

    public boolean pickup(Objet objet, GraphNode node){
        if(loadWeight_ + objet.getWeight() >= MAX_KILO_) return false;
        load_.add(objet);
        loadWeight_ += objet.getWeight();
        node.remove(objet.getType(),1);
        return true;
    }

    protected double computeK(double value, double factor){
        return value + factor * loadWeight_;
    }

}