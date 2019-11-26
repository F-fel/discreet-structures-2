package Tp2;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;

public class Entrepot extends ArrayList<Objet> {
    Entrepot(){super();}
    public Entrepot getByName(LinkedList<String> strings ){
        Entrepot retval = new Entrepot();
        for(Objet o : this){
            for (String s : strings){
                if(o.getName().equals(s)) retval.add(o);
            }
        }
        return retval;
    }
    public Entrepot getByID(LinkedList<String> strings ){
        Entrepot retval = new Entrepot();
        for(Objet o : this){
            for (String s : strings){
                if(o.getID().toString().equals(s)) retval.add(o);
            }
        }
        return retval;
    }
    public Entrepot getByType(LinkedList<String> strings ){
        Entrepot retval = new Entrepot();
        for(Objet o : this){
            for (String s : strings){
                if(o.getType().asChar() == s.charAt(0)) retval.add(o);
            }
        }
        return retval;
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
    public String[] toArray(){
        String[] retval = new String[size()];
        int i =0;
        for(Objet o : this){
            retval[i++] = o.toString();
        }
        return retval;
    }

}
