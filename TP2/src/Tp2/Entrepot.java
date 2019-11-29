package Tp2;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;

public class Entrepot extends ArrayList<Objet> {
    Entrepot(){super();}
    public Objet popByID(String s ){
        Hex id = new Hex(s);
        Entrepot retval = new Entrepot();
        for(Objet o : this){
            if( o.getID().equals(id)) {
                remove(o);
                return o;
            }
        }
        return null;
    }

    String[] getNamesArray(){
        String[] retval = new String[this.size()];
        int i =0;
        for (Objet o: this){
            retval[i++] = o.getName();
        }
        return retval;
    }
    String[] getHexArray(){
        String[] retval = new String[this.size()];
        int i =0;
        for (Objet o: this){
            retval[i++] = o.getID().toString();
        }
        return retval;
    }
    public String[] getTypeArray(){
        String[] retval = new String[this.size()];
        int i =0;
        for (Objet o: this){
            retval[i++] = o.getType().toString();
        }
        return retval;
    }
    @NotNull
     String[] toStringArray(){
        String[] retval = new String[size()];
        int i =0;
        for(Objet o : this){
            retval[i++] = o.toString();
        }
        return retval;
    }
}
