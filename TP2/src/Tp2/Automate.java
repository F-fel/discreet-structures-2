package Tp2;

import java.util.LinkedList;

public class Automate {

    /***
     * 3 methodes that uses no filter
     */
    public String[] getNames(LinkedList<Objet> inv){
        String[] retval = new String[inv.size()];
        int i =0; //retval index
        for (Objet o:inv) retval[i++] = o.getName();
        return retval;
    }
    public Hex[] getIds(LinkedList<Objet> inv){
        Hex[] retVal = new Hex[inv.size()];
        int i =0;
        for (Objet o : inv)
            retVal[i++] = o.getID();
        return retVal;
    }
    public ObjectType[] getTypes(LinkedList<Objet> inv){
        ObjectType[] retVal = new ObjectType[inv.size()];
        int i =0;
        for (Objet o : inv)
            retVal[i++] = o.getType();
        return retVal;
    }
}
