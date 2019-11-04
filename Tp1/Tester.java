package Tp1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tester {
    /**
     * Test function only works for the entrepot.txt given in the TP
     * @return true if read correctly
     */
    public boolean nodeTest(){
        NodeList correct = new NodeList();
        boolean b = false;
        correct.add(new GraphNode(0, 0, 0, 0));
        correct.add(new GraphNode(1, 0, 0, 0));
        correct.add(new GraphNode(2, 1, 0, 0));
        correct.add(new GraphNode(3, 0, 1, 0));
        correct.add(new GraphNode(4, 3, 0, 1));
        correct.add(new GraphNode(5, 0, 0, 1));
        correct.add(new GraphNode(6, 2, 0, 0));
        correct.add(new GraphNode(7, 2, 1, 0));
        correct.add(new GraphNode(8, 0, 0, 0));
        correct.add(new GraphNode(9, 1, 0, 0));
        correct.add(new GraphNode(10, 0, 1, 0));
        correct.add(new GraphNode(11, 0, 0, 0));
        correct.add(new GraphNode(12, 1, 0, 0));
        correct.add(new GraphNode(13, 3, 0, 1));
        correct.add(new GraphNode(14, 2, 2, 0));
        correct.add(new GraphNode(15, 1, 1, 0));
        correct.add(new GraphNode(16, 0, 1, 0));
        correct.add(new GraphNode(17, 0, 0, 1));
        correct.add(new GraphNode(18, 0, 0, 0));
        correct.add(new GraphNode(19, 0, 2, 0));
        correct.add(new GraphNode(20, 1, 1, 3));
        EntrepotReader er = new EntrepotReader();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\faelfa\\IdeaProjects\\Log2810_tp1\\src\\Tp1\\entrepot.txt"));
            NodeList nodes =er.readNodes(br);
            if(nodes.isEqual(correct)) b = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
    boolean graphTest(){
        boolean b = false;
        NodeList correct = new NodeList();
        correct.add(new GraphNode(0, 0, 0, 0));
        correct.add(new GraphNode(1, 0, 0, 0));
        correct.add(new GraphNode(2, 1, 0, 0));
        correct.add(new GraphNode(3, 0, 1, 0));
        correct.add(new GraphNode(4, 3, 0, 1));
        correct.add(new GraphNode(5, 0, 0, 1));
        correct.add(new GraphNode(6, 2, 0, 0));
        correct.add(new GraphNode(7, 2, 1, 0));
        correct.add(new GraphNode(8, 0, 0, 0));
        correct.add(new GraphNode(9, 1, 0, 0));
        correct.add(new GraphNode(10, 0, 1, 0));
        correct.add(new GraphNode(11, 0, 0, 0));
        correct.add(new GraphNode(12, 1, 0, 0));
        correct.add(new GraphNode(13, 3, 0, 1));
        correct.add(new GraphNode(14, 2, 2, 0));
        correct.add(new GraphNode(15, 1, 1, 0));
        correct.add(new GraphNode(16, 0, 1, 0));
        correct.add(new GraphNode(17, 0, 0, 1));
        correct.add(new GraphNode(18, 0, 0, 0));
        correct.add(new GraphNode(19, 0, 2, 0));
        correct.add(new GraphNode(20, 1, 1, 3));


        edgeCreator(correct.get(0),correct.get(1),10);
        edgeCreator(correct.get(0),correct.get(6),15);
        edgeCreator(correct.get(1),correct.get(2),16);
        edgeCreator(correct.get(2),correct.get(3),8);
        edgeCreator(correct.get(2),correct.get(12),29);
        edgeCreator(correct.get(3),correct.get(6),31);
        edgeCreator(correct.get(3),correct.get(7),12);
        edgeCreator(correct.get(3),correct.get(9),16);
        edgeCreator(correct.get(4),correct.get(8),8);
        edgeCreator(correct.get(4),correct.get(9),9);
        edgeCreator(correct.get(5),correct.get(10),14);
        edgeCreator(correct.get(5),correct.get(11),24);
        edgeCreator(correct.get(6),correct.get(11),10);
        edgeCreator(correct.get(6),correct.get(17),38);
        edgeCreator(correct.get(7),correct.get(8),11);
        edgeCreator(correct.get(8),correct.get(14),19);
        edgeCreator(correct.get(8),correct.get(17),26);
        edgeCreator(correct.get(9),correct.get(18),32);
        edgeCreator(correct.get(10),correct.get(16),18);
        edgeCreator(correct.get(11),correct.get(15),23);
        edgeCreator(correct.get(12),correct.get(13),13);
        edgeCreator(correct.get(12),correct.get(16),15);
        edgeCreator(correct.get(14),correct.get(19),7);
        edgeCreator(correct.get(15),correct.get(20),29);
        edgeCreator(correct.get(17),correct.get(19),26);
        edgeCreator(correct.get(19),correct.get(20),27);
        EntrepotReader er = new EntrepotReader();
        try {
            NodeList out = er.creerGraph();
            if(out.isEqual(correct))b = true;
        }catch (Exception e) {
            System.out.print("something is fishy\n");
        }
        return b;
    }
    /**
     * djikstra test on a simple graph hand made
     * @return true if works
     */
    boolean djikstraTester(){
        boolean retval = true;
        NodeList graph = new NodeList();
        GraphNode A =new GraphNode(0,0,0,0);
        GraphNode B =new GraphNode(1,0,0,0);
        GraphNode C =new GraphNode(2,0,0,0);
        GraphNode D =new GraphNode(3,0,0,0);
        A.addEdge(new GraphEdge(B,7));
        B.addEdge(new GraphEdge(A,7));

        C.addEdge(new GraphEdge(A,10));
        A.addEdge(new GraphEdge(C,10));

        B.addEdge(new GraphEdge(C,2));
        C.addEdge(new GraphEdge(B,2));

        B.addEdge(new GraphEdge(D,3));
        D.addEdge(new GraphEdge(B,3));

        C.addEdge(new GraphEdge(D,5));
        D.addEdge(new GraphEdge(C,5));
        graph.add(A);
        graph.add(B);
        graph.add(C);
        graph.add(D);
        Djikstra dj = new Djikstra();
        DjikstraTable[] correct = new DjikstraTable[4];
        correct[0] = new DjikstraTable(0,A);
        correct[1] = new DjikstraTable(7,A);
        correct[2] = new DjikstraTable(9,B);
        correct[3] = new DjikstraTable(10,B);
        DjikstraTable[] out =dj.algorithm(graph,0);
        for(int i =0; i<4;++i){
            if(!correct[i].isEqual(out[i])) retval = false;
        }

        return retval;
    }
    private void edgeCreator(GraphNode node1, GraphNode node2, int dist){
        node1.addEdge(new GraphEdge(node2,dist));
        node2.addEdge(new GraphEdge(node1,dist));
    }
}
