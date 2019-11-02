package Tp1;
import java.io.*;

public class EntrepotReader {
    /**
     * NOT TESTED
     * @return all nodes created
     * @throws IOException
     */
    private NodeList readNodes(BufferedReader br) throws IOException {

        String line ;
        NodeList nodes = new NodeList();

        while(!(line= br.readLine()).equals("\n")){
            int index1 = line.indexOf(',');
            int index2 = line.indexOf(',',index1+1);
            int index3 = line.indexOf(',',index2+1);
            int id = Integer.parseInt(line.substring(0,index1));
            int a = Integer.parseInt(line.substring(index1+1,index2));
            int b = Integer.parseInt(line.substring(index2+1,index3));
            int c = Integer.parseInt(line.substring(index3+1));
            nodes.add(new GraphNode(id,a,b,c));
        }
        return nodes;
    }

    /**
     * utility function to read Entrepot.txt if it follow the right format.
     * @param br buffered reader have to be the same than readNodes();
     * @param graph graph without nedges
     * @return adjancy matrix for the graph
     * @throws IOException
     */
    private void readEdges(BufferedReader br,NodeList graph) throws IOException {
        String line;
        while((line=br.readLine())!=null){
            //not necessary but make it easier to read
            int index1 = line.indexOf(',');
            int index2 = line.indexOf(',',index1+1);
            int nodeIndex1 = Integer.parseInt(line.substring(0,index1));
            int nodeIndex2 = Integer.parseInt(line.substring(index1+1,index2));
            int dist = Integer.parseInt(line.substring(index2));
            graph.get(nodeIndex1).addEdge(new GraphEdge(graph.get(nodeIndex2),dist));
            graph.get(nodeIndex2).addEdge(new GraphEdge(graph.get(nodeIndex1),dist));
        }
    }

    /**
     *
     * @param filePath path of the file needed
     * @return the full graph
     * @throws Exception
     */
    public NodeList readEntrepot(String filePath)throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
        NodeList retval = readNodes(br);
        readEdges(br,retval);
        return retval;
    }

}
