/**
 *
 */

/**
 * Main class
 * @author volentiralexandra
 */
public class Main {
    /**
     * here would be executed the main of the program
     */
    public static void main(String[] args) {

        ComputerLab room1 = new ComputerLab("401", 30);
        ComputerLab room2 = new ComputerLab("403", 40);
        ComputerLab room3 = new ComputerLab("405", 41);
        LectureHall room4 = new LectureHall("309", 100);
        room1.setOperatingSystem("Linux");
        room4.setHasProjector(true);

        Event event1 = new Event("C1", 100,8,10);
        Event event2 = new Event("C2", 100,10,12);
        Event event3 = new Event("L1", 30,8,10);
        Event event4 = new Event("L2", 30,8,10);
        Event event5 = new Event("L3", 30,10,12);
        System.out.println(event1);
        System.out.println(event2);
        System.out.println(event3);

        Problem pb = new Problem();

        pb.addRoom(room1);
        pb.addRoom(room2);
        pb.addRoom(room3);
        pb.addRoom(room4);
        pb.addEvent(event1);
        pb.addEvent(event2);
        pb.addEvent(event3);
        pb.addEvent(event4);
        pb.addEvent(event5);

        Algorithm greedy = new GreedyAlgorithm(pb);
        Solution sol = greedy.solve();
        sol.computeUsedRooms();
    }
}
