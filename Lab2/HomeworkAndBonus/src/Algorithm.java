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
     * abstract method. It will be override by
     * the classes which extend the Algorithm class.
     * @return the solution of the algorithm
     */
    public abstract Solution solve();
}
