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
                case '1':
                    value ++;
                case '2':
                    value+=2;
                case '3' :
                    value +=3;
                case '4' :
                    value +=4;
                case '5' :
                    value += 5;
                case '6':
                    value +=6;
                case '7':
                    value+=7;
                case '8' :
                    value +=8;
                case '9' :
                    value +=9;
                case 'A' :
                    value += 10;
                case 'B':
                    value +=11;
                case 'C':
                    value+=12;
                case 'D' :
                    value +=13;
                case 'E' :
                    value +=14;
                case 'F':
                    value += 15;
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
}
