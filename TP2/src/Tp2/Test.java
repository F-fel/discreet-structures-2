package Tp2;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public void entrepotFactoryTester() throws IOException {
        EntrepotFactory ef = new EntrepotFactory();
        Entrepot e = ef.read();
        for(Objet o : e){
            System.out.println(o.toString());
        }

    }/*
    public void automateTester() {
        State s0 = new State('t');
        State s1 = new State('e');
        State s2 = new State('s');
        State s3 = new State('t');
        State[] states = {s0, s1, s2, s3};
        String[] strings = {
                "testing is part of programing",
                "not testing is a sin",
                "test test test test",
                "i ran out of imagination",
                "tesss",
                "tallll",
                "atest",
                "testt"
        };
        Automate auto = new Automate(states);
        ArrayList<String> ret = auto.filter(strings);
        for (String s : ret) {
            System.out.println(s);
        }
    }*/
}
