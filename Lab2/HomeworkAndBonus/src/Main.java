import java.time.LocalTime;


/**
 * Main class
 * @author volentiralexandra
 */
public class Main {

    private static final long MEGABYTE = 1024L * 1024L;

    /**
     * function to convert byt3s to megabytes
     * @param totalBytes number of bytes
     * @return the result in Megabytes
     */
    public static long byteToMegabyte(long totalBytes) {
        return totalBytes / MEGABYTE;
    }

    /**
     * Calculates the memory consumption of the program at
     * a specific time.
     */
    public static void showMemoryConsumption(){
        Runtime time = Runtime.getRuntime(); // get the runtime
        time.gc(); // call garbage collector
        long totalMemory = time.totalMemory() - time.freeMemory();
        System.out.println("Memory (bytes): " + totalMemory + " bytes");
        System.out.println("Memory (megabytes): "
                + byteToMegabyte(totalMemory) + " megabytes");
    }

    /**
     * here would be executed the main of the program
     */
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        ComputerLab room1 = new ComputerLab("401", 30);
        ComputerLab room2 = new ComputerLab("403", 40);
        ComputerLab room3 = new ComputerLab("405", 41);
        LectureHall room4 = new LectureHall("309", 100);
        room1.setOperatingSystem("Linux");
        room4.setHasProjector(true);

        Event event1 = new Event("C1", 100,LocalTime.of(8,0,0),
                LocalTime.of(10,0,0));//8 10
        Event event2 = new Event("C2", 100,LocalTime.of(10,0,0),
                LocalTime.of(12,0,0)); // 10 12
        Event event3 = new Event("L1", 30,LocalTime.of(8,0,0),
                LocalTime.of(10,0,0)); // 8 10
        Event event4 = new Event("L2", 30,LocalTime.of(8,0,0),
                LocalTime.of(10,0,0)); // 8 10
        Event event5 = new Event("L3", 30,LocalTime.of(10,0,0),
                LocalTime.of(12,0,0)); // 10 12
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
        showMemoryConsumption();
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Runtime: " + elapsedTime + " milliseconds");
    }
}
