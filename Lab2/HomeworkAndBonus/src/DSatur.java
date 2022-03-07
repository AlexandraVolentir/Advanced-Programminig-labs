/**
 * Class for solving a scheduling problem with DSatur algorithm
 * @author volentiralexandra
 */
public class DSatur extends Algorithm {

    /**
     * constructor for the DSatur class
     * points to the constructor of the super class
     * @param pb the instance of the problem
     */
    public DSatur(Problem pb) {
        super(pb);
    }

    @Override
    public Solution solve() {
        pb.getEvents().sort(new EventsComparator());
        pb.getRooms().sort(new RoomsComparator());
//        System.out.println(pb.getEvents());
//        System.out.println(pb.getRooms());
        return null;
    }
}