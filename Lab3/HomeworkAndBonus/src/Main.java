import java.util.*;

public class Main {
    public boolean checkIfNodesConnected(Network n  ,int i, int j){
//        ArrayList<Node> list = n.getListOfNodes();
//        for (Map.Entry<String, Object> entry : list.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            // ...
//        }
        return true;
    }
    /**
     * Here is the main code
     * @param args given parameters
     */
    public static void main(String[] args) {
        Computer v1 = new Computer("A");
        Router v2 = new Router("A");
        Switch v3 = new Switch("A");
        Switch v4 = new Switch("B");
        Router v5 = new Router("B");
        Computer v6 = new Computer("B");

        v1.setStorageCapacity(23);

        Network n1 = new Network();
        n1.addNode(v1);
        n1.addNode(v2);
        n1.addNode(v3);
        n1.addNode(v4);
        n1.addNode(v5);
        n1.addNode(v6);

        n1.setCost(v1,v2,10);
        n1.setCost(v1,v3,50);
        n1.setCost(v2,v3,20);
        n1.setCost(v2,v4,20);
        n1.setCost(v2,v5,20);
        n1.setCost(v3,v4,10);
        n1.setCost(v4,v5,30);
        n1.setCost(v4,v6,10);
        n1.setCost(v5,v6,20);

        System.out.println(v1.getCost());
        System.out.println(n1);

        n1.displayIdentifiable();

        /* Let us create the example graph discussed above */
        int len = n1.getListOfNodes().size();
        ArrayList[] graph = new ArrayList[len];

        for (int i = 0; i < len; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        int graph2[][] = new int[len][len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){

            }
        }




    }
}
