/**
 * Class for solving a scheduling problem with greedy
 * @author volentiralexandra
 */
public class GreedyAlgorithm extends Algorithm {

    /**
     * constructor for the GreedyAlgorithm class
     * points to the constructor of the super class
     * @param pb the instance of the problem
     */
    public GreedyAlgorithm(Problem pb) {
        super(pb);
    }

    /**
     * we traverse the sorted arraylists of the events and rooms
     * we assign to the smaller rooms first, then to the bigger ones
     * on assigning we take care that the number of participants isn't greater than the number of the room capacity
     * we take care that the event wasn't assigned a room before
     * the greedy approach consists in the fact that we consider the events which start earlier,
     * as well as filling the small rooms first by possibility
     * @return the solution for the greedy implementation of the problem
     */
    public Solution greedy(){
        Solution sol = new Solution();
        for(var room: pb.getRooms()){
            int lasHour = 0;
            for(var event: pb.getEvents()){
                if(room.getCapacity() >= event.getNrOfParticipants()){
                    if(lasHour <= event.getStartTimeHour() && !sol.getAssignmentMap().containsKey(event)){
                        sol.addPair(event, room);
                        lasHour = event.getEndTimeHour();
                    }
                }
            }
        }
        return sol;
    }

    /**
     * implementation for the solve method of the Algorithm abstract class
     * sorts the arrays of events and rooms
     * the rooms are sorted increasingly by their capacity using the RoomsComparator
     * the events are sorted by their start time in increasing order as well using the EventsComparator
     * the greedy method is executed
     * @return the solution of the greedy approach
     */
    @Override
    public Solution solve() {
        pb.getEvents().sort(new EventsComparator());
        pb.getRooms().sort(new RoomsComparator());
//        System.out.println(pb.getEvents());
//        System.out.println(pb.getRooms());
        return greedy();
    }
}