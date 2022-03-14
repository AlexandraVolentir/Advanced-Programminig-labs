public class Main {
    /**
     * Here is the main code
     * @param args given parameters
     */
    public static void main(String[] args) {
        Computer v1 = new Computer("v1","A");
        Router v2 = new Router("v2","A");
        Switch v3 = new Switch("v3","A");
        Switch v4 = new Switch("v4","B");
        Router v5 = new Router("v5","B");
        Computer v6 = new Computer("v6","B");

        v1.setStorageCapacity(23);
        System.out.println("\nThe storage capacity of v1 is: " + v1.getStorageCapacity() + " GB");
        System.out.println("The storage capacity of v1 is: " + v1.translate(v1.getStorageCapacity(), StorageUnits.MEGABYTE) + " MB");
        System.out.println("The storage capacity of v1 is: " + v1.translate(v1.getStorageCapacity(), StorageUnits.KILOBYTE) + " KB");
        System.out.println("The storage capacity of v1 is: " + v1.translate(v1.getStorageCapacity(), StorageUnits.BYTE) + " bytes");


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

        System.out.println(n1);
        System.out.println("The sorted list of identifiable nodes is: ");
        n1.displayIdentifiable();
        System.out.println();

        int len = n1.getListOfNodes().size() ;
        Network tempNetwork = new Network(n1.sortByAddressesIdentifiable(n1.getListOfNodes()));
        for(var obj : tempNetwork.getListOfNodes()){
            System.out.println(obj);
        }
        System.out.println();

        Problem prob1 = new Problem(n1, n1.getListOfNodes().size());
        int idNode1 = 0;
        int idNode2 = 4;
        int flag = 0;
        for(var obj : n1.sortByAddressesIdentifiable(n1.getListOfNodes())){
            if (obj.getId() == idNode1 || obj.getId() == idNode2) flag++;
        }
        if(flag == 2){
            prob1.performDijkstra(0,4);
        }
        System.out.println();

        Problem p2 = new Problem(n1, n1.getListOfNodes().size());
        p2.performSafestDijkstra(3,5);
    }
}
