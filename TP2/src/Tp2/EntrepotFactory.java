package Tp2;

import java.io.*;
import java.security.InvalidParameterException;

public class EntrepotFactory{
    public Entrepot read() throws IOException {
        Entrepot retval = new Entrepot();
        File file = new File(getClass().getResource("inventaire.txt").getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line; //1 line of text
        while((line=br.readLine())!=null){
            int nameEnd = line.indexOf(" ");
            int idEnd = line.indexOf(" ",nameEnd+1);
            String name = line.substring(0,nameEnd);
            Hex hex = new Hex(line.substring(nameEnd+1,idEnd));
            switch(line.substring(idEnd+1).charAt(0)){
                case 'A':
                    retval.add(new Objet(name,hex,ObjectType.A));
                    break;
                case 'B':
                    retval.add(new Objet(name,hex,ObjectType.B));
                    break;
                case 'C':
                    retval.add(new Objet(name,hex,ObjectType.C));
                    break;
                default:
                    throw new InvalidParameterException("Not valid object type.\n");
            }

        }
        return retval;
    }
}
