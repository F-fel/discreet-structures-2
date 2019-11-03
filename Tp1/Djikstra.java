package Tp1;

public class Djikstra {
    public DjikstraTable[] algorithm(NodeList graph,int src){
        DjikstraTable[] distance = new DjikstraTable[graph.size()];
        //index of visited nodes will be true
        boolean[] visited = new boolean[distance.length];
        //number of visited nodes
        int visitedLength =0;

        //mettre les distance a l'infinie
        for(int i =0; i<distance.length;++i){
            distance[i].distance = Integer.MAX_VALUE;
        }
        distance[src].distance = 0;
        distance[src].previousNode = graph.get(src);

        while(visitedLength<visited.length){
            int currentIndex = findMin(distance,visited);
            for(GraphEdge edge : graph.get(currentIndex).getEdges()){
                if(distance[edge.getNode().getId()].distance > distance[currentIndex].distance+edge.getDistance()){
                    distance[edge.getNode().getId()].distance = distance[currentIndex].distance + edge.getDistance();
                    distance[edge.getNode().getId()].previousNode = graph.get(currentIndex);
                }
            }
            visited[currentIndex] = true;
            visitedLength++;
        }
        return distance;
    }
    private int findMin(DjikstraTable[] list,boolean[] visits){
        int min =0;
        for(int i =0; i<list.length;i++){
            if(list[i].distance<list[min].distance && !visits[i]) min = i;
        }
        return min;
    }
}
class DjikstraTable{
    private int distance;
    private GraphNode previousNode;
    DjikstraTable(){
        distance=0;
        previousNode = null;
    }
    DjikstraTable(int dist,GraphNode node){
        distance=dist;
        previousNode=node;
    }
    boolean isEqual(DjikstraTable dj){
        return (distance==dj.distance && previousNode.isEqual(dj.previousNode));
    }
}
