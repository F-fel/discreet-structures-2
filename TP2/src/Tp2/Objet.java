package Tp2;

public class Objet {
    private String name;
    private Hex ID;
    private ObjectType type;
    Objet(String n, Hex i, ObjectType t){
        name = n;
        ID =i;
        type =t;
    }
    ObjectType getType() {
        return type;
    }
    String getName() {
        return name;
    }
    Hex getID() {
        return ID;
    }
    public boolean equals(Objet obj) {
        return this.ID == obj.ID;
    }

    @Override
    public String toString() {
        return "name : "+name + " ID : "+ ID.toString() + " Type : "+ type.asChar();
    }
}