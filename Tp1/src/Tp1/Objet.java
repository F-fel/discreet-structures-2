package Tp1;

enum objetType {A, B, C}
public class Objet {
    private int weight;
    private objetType type; //identification

    Objet(objetType type){
        this.type=type;
        switch (type) {
            case A:
                weight = 1;
            case B:
                weight = 3;
            case C:
                weight = 6;
        }

    }
    public boolean equals(Objet O){ return (type == O.type); }
    public int getWeight() { return weight;}
    public objetType getType(){return type;}

}
