package mypack;
import java.util.Vector;

public class Graph {

    Graph(int max) {
        graph = new Vector[max];
        cycles = new Vector[max];
        this.max = max;
    }

    public boolean checkStr(String str, String id) {
        if (str == null || str.isEmpty()) return false;
        return str.equals(id);
    }

    public void basicDfs(int node, String[] nodeId, int[] cycleId, int[] ancestor) {
        for (int v : graph[node]) {
            // if unvisited for now
            if (v == ancestor[node]) {
                continue;
            }
            dfsForCycles(v, node, nodeId, cycleId, ancestor);
        }
    }

    // assign an id number for each cycle
    void dfsForCycles(int node, int p, String[] nodeId, int[] cycleId, int[] ancestor){
        if (checkStr(nodeId[node], "visited")) {
            return;
        }
        // backtrack on ancestors to find full cycle
        if (checkStr(nodeId[node], "partially")) {
            ++cycleNr;
            int current = p;
            cycleId[current] = cycleNr;
            // backtrack the vertex in the current cycle
            while (current != node) {
                current = ancestor[current];
                cycleId[current] = cycleNr;
            }
            return;
        }
        ancestor[node] = p;
        nodeId[node] = "partially"; // the node was visited, but not completely yet
        basicDfs(node,nodeId, cycleId, ancestor);
        nodeId[node] = "visited"; // the node was completely visited
    }

    public int createEdges(int[][] matrix) {
        int edges = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == 1) {
                   if(i < j) { // && !graph[i].contains(j)
//                       System.out.println("add edges " + (i+1) + " and " + (j+1));
                       graph[i+1].add(j+1);
                       graph[j+1].add(i+1);
                       edges++;
                   }
                }
            }
        }
        return edges;
    }

    public void pushEdgesIntoAdjList(int edges, int[] cycleId) {
        for (int i = 1; i <= edges; i++) {
            if (cycleId[i] != 0)
                cycles[cycleId[i]].add(i);
        }
    }

    public void printCycles() {
        for (int i = 1; i <= cycleNr; i++) {
            if(cycles[i].size() >= 3)
            {
                System.out.print("cycle "+ i + " => ");
                for (int obj : cycles[i])
                    System.out.print(obj + " ");
                System.out.println();
            }
        }
    }

    public Vector<Integer> findLongestCycle() {
        int max = 0;
        int cycleCount = -1;
        for(int i = 0; i <= cycleNr; i++) {
            if(cycles[i].size() > max) {
                max = cycles[i].size();
                cycleCount = i;
            }
        }
        return cycles[cycleCount];
    }

    int max;
    int cycleNr;
    Vector<Integer>[] graph;
    Vector<Integer>[] cycles;
}
