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
            distance[i]= new DjikstraTable(Integer.MAX_VALUE,graph.get(src));
        }
        distance[src].setDistance(0);
        distance[src].setPreviousNode(graph.get(src));

        while(visitedLength<visited.length){
            int currentIndex = findMin(distance,visited);
            for(GraphEdge edge : graph.get(currentIndex).getEdges()){
                if(distance[edge.getNode().getId()].getDistance() > (distance[currentIndex].getDistance()+edge.getDistance())){
                    distance[edge.getNode().getId()].setDistance(distance[currentIndex].getDistance() + edge.getDistance());
                    distance[edge.getNode().getId()].setPreviousNode(graph.get(currentIndex));
                }
            }
            visited[currentIndex] = true;
            visitedLength++;
        }
        return distance;
    }
    private int findMin(DjikstraTable[] list,boolean[] visits){
        int min =Integer.MAX_VALUE;
        for(int i =0; i<list.length;++i){
            if(list[i].getDistance()<min && !visits[i]){
                min =i;
            }
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
    public int getDistance(){return distance;}
    public GraphNode getPreviousNode(){return previousNode;}

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setPreviousNode(GraphNode previousNode) {
        this.previousNode = previousNode;
    }

    boolean isEqual(DjikstraTable dj){
        return (distance==dj.distance && previousNode.isEqual(dj.previousNode));
    }
}
