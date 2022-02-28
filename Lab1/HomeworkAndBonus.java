package mypack;
import java.util.*;
import java.lang.Math;

/* Introductory program to Java
* (c) Volentir Alexandra
* */
public class HomeworkAndBonus {

    // checks if a sent string is integer
    public static boolean checkInt(String strNo) {
        try {
            Integer.parseInt(strNo);
        } catch(NumberFormatException | NullPointerException ex) {
            return false;
        }
        return true;
    }

    // fetches the integer value of a string
    public static int getInteger(String str) {
        if(checkInt(str)) {
            return  Integer.parseInt(str);
        }
        return 0;
    }

    //  fetches integer input from command line
    public static int waitForIntegerInput(String var) {
        int nr;
        String strOfNo;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Enter a number " + var + " = ");
            strOfNo= sc.nextLine();
            if(checkInt(strOfNo)) {
                nr = getInteger(strOfNo);
                return nr;
            }
        }
    }

    // check and validate user input
    public static StringBuilder waitForCharInput() {
        Scanner sc = new Scanner(System.in);
        StringBuilder listOfLetters = new StringBuilder();
        var hashSet = new HashSet<Character>();
        char c = '#';
        System.out.print("Input some random letters with space between: ");
        while(c != '.') {
            c = sc.next().toUpperCase().charAt(0);
            if(Character.isLetter(c) && !hashSet.contains(c)) {
                listOfLetters.append(c);
                hashSet.add(c);
            }
        }
        return listOfLetters;
    }

    public static void printStringBuilderArray(StringBuilder[] arr, int length) {
        for(int i = 0; i < length; i++) {
            System.out.println(arr[i].toString());
        }
    }

    public static void printMatrix(int[][] matrix)
    {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
    }

    public static boolean checkIfWordsAreNeighbours(String word1, String word2)
    {
//        System.out.println("The words are: " + word1 + " and " + word2);
        Map<Character, Boolean> mp = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            mp.put(word1.charAt(i), true);
        }
        for (int i = 0; i < word2.length(); i++) {
//            System.out.println(mp.get(word2.charAt(i)));
            if(mp.get(word2.charAt(i)) != null) {
                if (mp.get(word2.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    // creates and returns the symmetric adjacency matrix for a list of words
    public static int[][] getWordAdjacency(StringBuilder[] listOfWords, int wordNumber) {
        // initialize matrix
        int [][]matrix = new int[wordNumber][wordNumber];
        // check each pair of words for adjacency
        for(int i = 0; i < wordNumber; i++) {
            for(int j = 0; j < wordNumber; j++) {
                if(checkIfWordsAreNeighbours(listOfWords[i].toString().trim(), listOfWords[j].toString().trim())) {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    public static void wordsToWords() {
        // waiting for user input
        long startTime = System.nanoTime();

        int n, p;
        n = waitForIntegerInput("n");
        p = waitForIntegerInput("p");
        StringBuilder listOfChars = new StringBuilder(waitForCharInput());
        StringBuilder[] listOfWords = new StringBuilder[n];
        int length = listOfChars.length();
        // initialize the list of words
        for (int i = 0; i < listOfWords.length; i++) {
            listOfWords[i] = new StringBuilder();
        }
        // generate random words
        for(int i = 0; i < n; i++) {
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < p; j++) {
                int randInteger = (int) (Math.random() * length);
                word.append(listOfChars.charAt(randInteger));
            }
            listOfWords[i] = new StringBuilder(word);
        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime + " nanoseconds");
        // print the array of words
        System.out.println("The list of possible characters is: " + listOfChars);
        printStringBuilderArray(listOfWords, n);
        // create adjacency matrix & output it
        int[][] matrix = getWordAdjacency(listOfWords, n);
        System.out.println("The adjacency matrix is: ");
        printMatrix(matrix);
        findLargestCycle(matrix);
    }

    public static void findLargestCycle(int[][] matrix) {
        Graph g = new Graph(20000);
        for (int i = 0; i < g.max; i++) {
            g.graph[i] = new Vector<>();
            g.cycles[i] = new Vector<>();
        }
        int edges = g.createEdges(matrix);
        String[] nodeId = new String[g.max]; // visited or not
        int[] par = new int[g.max]; // parent
        int[] cycleId = new int[g.max]; // belonging with unique cycle
        g.cycleNr = 0; // counter for cycles
        // DFS to identify and numerate cycles
        g.dfsForCycles(1, 0, nodeId, cycleId, par);
        g.pushEdgesIntoAdjList(edges, cycleId);
        g.printCycles();
        Vector<Integer> cycle = g.findLongestCycle();
        if(cycle.size() < 3) {
            System.out.println("No cycle of size greater than 3");
        }
        else {
            System.out.print("The longest cycle is of length " + cycle.size() + ": ");
            for (int obj : cycle)
                System.out.print(obj + " ");
        }
    }

    public static void main(String[] args) {
        wordsToWords();
    }
}
