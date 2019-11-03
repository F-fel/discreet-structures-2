package Tp1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tester {
    /**
     * Test function only works for the entrepot.txt given in the TP
     * @return
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
    boolean djikstraTester(){
        boolean retval = false;
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
        correct[0].distance =0;
        correct[0].previousNode = A;
        correct[1].distance = 7;
        correct[1].previousNode = A;
        correct[2].previousNode = B;
        correct[2].distance = 9;
        correct[3].distance=10;
        correct[3].previousNode = B;
        DjikstraTable[] out =dj.algorithm(graph,0);


        return retval;
    }
}
