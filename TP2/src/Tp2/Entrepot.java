package Tp2;

//import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

 class Entrepot extends ArrayList<Objet> {
    Entrepot(){super();}
     Objet popByID(String s ){
        Hex id = new Hex(s);
        for(Objet o : this){
            if( o.getID().equals(id)) {
                remove(o);
                return o;
            }
        }
        return null;
    }
    void add(Entrepot e){
        this.addAll(e);
    }

   // @NotNull
     String[] toStringArray(){
        String[] retval = new String[size()];
        int i =0;
        for(Objet o : this){
            retval[i++] = o.toString();
        }
        return retval;
    }
    int weight(){
        int x =0;
        for(Objet o : this){
            if(o.getType() == ObjectType.A) x++;
            else if(o.getType() == ObjectType.B) x+=3;
            else if(o.getType() == ObjectType.C) x+=5;
        }
        return x;
    }
}
