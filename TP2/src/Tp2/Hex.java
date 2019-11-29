package Tp2;

import java.security.InvalidParameterException;

/**
 * Did not like existing libraries so created this class.
 * */
public class Hex{
    private int value;
    private String forme;
    Hex(String s){
        value =0;
        for(char c :s.toCharArray()){
            switch (c) {
                case '0' :
                    value += 0;
                    break;
                case '1':
                    value ++;
                    break;
                case '2':
                    value+=2;
                    break;
                case '3' :
                    value +=3;
                    break;
                case '4' :
                    value +=4;
                    break;
                case '5' :
                    value += 5;
                    break;
                case '6':
                    value +=6;
                    break;
                case '7':
                    value+=7;
                    break;
                case '8' :
                    value +=8;
                    break;
                case '9' :
                    value +=9;
                    break;
                case 'A' :
                    value += 10;
                    break;
                case 'B':
                    value +=11;
                    break;
                case 'C':
                    value+=12;
                    break;
                case 'D' :
                    value +=13;
                    break;
                case 'E' :
                    value +=14;
                    break;
                case 'F':
                    value += 15;
                    break;
                default :
                    throw new InvalidParameterException("Le nombre hexadecimal doit etre ecrit avec 1,2,3,4,5,6,7,8,9,0,A,B,C,D,E ou F (pas de miniscule)\n");
            }
        }
        forme =s;
    }

    public String toString() {
        return forme;
    }

    public int getValue() {
        return value;
    }
    boolean equals(Hex hex){
        return (hex.forme.equals(forme) && value==hex.value);
    }
}
