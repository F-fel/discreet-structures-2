package Tp1;
import java.io.*;
import java.util.LinkedList;

public class EntrepotReader {
    /**
     * NOT TESTED
     * @return all nodes created
     * @throws Exception FileNotFoundException from FileReader
     */
    public LinkedList<GraphNode> readNodes() throws Exception{
        File file = new File(".\\entrepot.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line ;
        LinkedList<GraphNode> nodes = new LinkedList<>();

        while(!(line= br.readLine()).equals("\n")){
            int index1 = line.indexOf(',');
            int index2 = line.indexOf(',',index1);
            int index3 = line.indexOf(',',index2);
            int id = Integer.parseInt(line.substring(0,index1));
            int a = Integer.parseInt(line.substring(index+1,index2));
            int b = Integer.parseInt(line.substring(index2+1,index3));
            int c = Integer.parseInt(line.substring(index3+1));
            nodes.add(new GraphNode(id,a,b,c));
        }
        return nodes;
    }
}
