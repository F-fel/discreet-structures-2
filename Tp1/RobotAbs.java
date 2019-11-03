package Tp1;

import java.util.LinkedList;

public class RobotAbs {
    final private int MAX_KILO;
    private LinkedList<Objet> load;
    private int loadWeight;

    RobotAbs(int max){
        MAX_KILO = max;
        load = new LinkedList<Objet>();
        loadWeight = 0;
    }

    public boolean pickup(Objet objet, GraphNode node){
        if(loadWeight + objet.getWeight() >= MAX_KILO) return false;
        load.add(objet);
        loadWeight += objet.getWeight();
        node.remove(objet.getType(),1);
        return true;
    }

    protected double computeK(double value, double factor){
        return value + factor * loadWeight;
    }

}