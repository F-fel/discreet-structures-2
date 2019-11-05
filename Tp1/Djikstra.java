package Tp1;

public class Djikstra {
    private int distanceTotal_=0;

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

    private double tempsTotal(RobotAbs robot, Order order){// A FAIRE
        int tempsTotal=0;
        //formule temps=robot.computeK()*distanceTotal();


        //il y a un cout de 10 secondes  pour prendre un objet a chaque fois
        tempsTotal+=(10*order.getTotalObjet_());

        return tempsTotal;


    }

    private double distanceTotal(){ //A FAIRE

        //additioner toute les distances entre les nodes du parcours


        //faire cette disctance *2 pour aller retour
        distanceTotal_*=2;

        return distanceTotal_;
    }

    private void plusCourtChemin(NodeList graph,int src, Order order){
        //Dijkstra

        //afficher robot utilise , afficher temps total et distance et commande

        System.out.println("objet A: "+ order.getA_()+", objet B: "+ order.getB_()+", objet C: "+ order.getC_());
        System.out.println("le robot choisi pour cette commande est le robot: "+ order.getRobotChoose_());
        System.out.println("le robot parcours une distance de "+ distanceTotal()+" metres");
        System.out.println("le temps total a effectuer pour le robot est de "+ tempsTotal());

        //afficher liste des noeuds afficher

        //afficher les objets prient dans les noeuds

        //afficher temps total et distance et commande



        //afficher si le chemin est impossible

        if (order.getImpossible()){
            System.out.println("la commande est impossible car cette derniere est trop lourde ("
                    +order.getTotalWeight_()+" kg)");
        }





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
