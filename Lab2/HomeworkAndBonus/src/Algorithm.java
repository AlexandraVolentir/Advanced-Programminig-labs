/**
 * Abstract class that serves as a prototype for
 * the GreedyAlgorithm and DSatur classes
 */
public abstract class Algorithm {
    Problem pb;

    /**
     * Constructor for the Algorithm classs
     * @param pb instance of the problem
     */
    public Algorithm(Problem pb) {
        this.pb = pb;
    }

    /**
     * abstract method. It will be overriden by
     * the classes which extend the Algoritm class.
     * @return
     */
    public abstract Solution solve();
}
