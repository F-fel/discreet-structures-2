package Tp2;

public enum ObjectType {
    A('A'), B('B'),C('C');

    public char asChar() {
        return asChar;
    }

    private final char asChar;

     ObjectType(char c) {
        asChar = c;
    }
}
