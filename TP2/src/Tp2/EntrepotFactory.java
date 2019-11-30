package Tp2;

import java.io.*;
import java.security.InvalidParameterException;

 class EntrepotFactory{
     Entrepot read() throws InvalidParameterException, IOException {
        Entrepot retval = new Entrepot();
        File file = new File(getClass().getResource("inventaire.txt").getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line; //1 line of text
        while((line=br.readLine())!=null){
            int nameEnd = line.indexOf(" ");
            int idEnd = line.indexOf(" ",nameEnd+1);
            String name = line.substring(0,nameEnd);
            String hexString = line.substring(nameEnd+1,idEnd);
            if(hexString.length() != 6) throw new InvalidParameterException(hexString + " n'est pa de taille 6.");
            Hex hex = new Hex(hexString);
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
