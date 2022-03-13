
public class Main {
    /**
     * Here is the main code
     * @param args given parameters
     */
    public static void main(String[] args) {
        Node v1 = new Computer("v1");
        Node v2 = new Router("v2");
        Node v3 = new Switch("v3");
        Node v4 = new Switch("v4");
        Node v5 = new Router("v5");
        Node v6 = new Computer("v6");

        v1.setCost(v2, 10);
        v2.setCost(v1,10);

        v1.setCost(v3,50);
        v3.setCost(v1, 50);

        v2.setCost(v3,20);
        v3.setCost(v2,20);

        v2.setCost(v4,20);
        v4.setCost(v2, 20);

        v2.setCost(v5,10);
        v5.setCost(v2, 10);

        v3.setCost(v4,20);
        v4.setCost(v3, 20);

        v4.setCost(v5,30);
        v5.setCost(v4, 30);

        v4.setCost(v6,10);
        v6.setCost(v4, 10);

        v5.setCost(v6,20);
        v6.setCost(v5, 10);

        Network n1 = new Network();
        n1.addNode(v1);
        n1.addNode(v2);
        n1.addNode(v3);
        n1.addNode(v4);
        n1.addNode(v5);
        n1.addNode(v6);
        System.out.println(n1);
    }
}
