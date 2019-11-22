package Tp2;

enum ObjectType {A,B,C};
public class Objet {
    private String name;
    private Hex ID;
    private ObjectType type;
    Objet(String n, Hex i, ObjectType t){
        name = n;
        ID =i;
        type =t;
    }
    public ObjectType getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public Hex getID() {
        return ID;
    }
    public boolean equals(Objet obj) {
        return this.ID == obj.ID;
    }
}