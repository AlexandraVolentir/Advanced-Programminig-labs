## Laboratory 1 - Introduciton to Java Programming

## The tasks can be divided in three cathegories: compulsory, homework and bonus

### Compulsory

***
Our task was to define an array of strings of languages in java, and then, by performing some operations (like multiplication, adding binary numbers, computing the sum of the digits) on a random integer, access a specific index of the string an output the result.
The result of the output will always be "Java". 
The main of the compulsory is located in the "Compulsory.java" class.

### Homework

***

The task was to find the adjacency matrix of a set of words, taking in consideration their "neighbouring" properties.

We had two integers: n and p, and a set of characters which we need to validate. The validation was done by the functions *waitForIntegerInput*, *waitForCharInput* and *checkInt*. The integer validation was done with the function *parseInt* and a set of try-catch blocks. If our input is wrong, we have the chance of retyping it until it's right.

Whereas the function for character validation used was *isLetter*. Also, al the letters where made uppercase and checked with the collection Set - to avoid 
repetition and decrease the probability of accessing a certain letter many times and have a homogeneous matrix of ones(1).

The neighbouring property consists in checking whether two words have a common letter or no. If they DO have a common letter -
they are neighbours. The verification was done using the functions *checkIfWordsAreNeighbours* that checked whether two words are neighbours or not with the help of a hashmap, and *getWordAdjacency* which returned, basically the adjacency matrix of zeroes and ones. 1 represents that
the words are neighbours, whereas 0 - that they are not. As expected, the obtained matrix is symmetric.
I used a matrix to store the neighbours of each word. 

For larger instances, I adjusted the JVM Heap Space using the VM options -Xms4G -Xmx4G.
Application, in general, can be launched following the structure *java Compulsory.java*.

### Bonus

***

Implement an efficient algorithm that determines, if possible, a subset of distinct words W1,W2,...,Wk (from the ones that you have generated) such that k ≥ 3 and Wi and Wi+1 are neighbors, for all i in [1..k], where Wk+1=W1.  Also, we were asked if we could find the largest possible k.
First, I created a class called graph, and I added all the edges and nodes from the adjacency matrix used at the homework.
I also added a String array called nodeId, which could be either "visited", either "partially" visited,
signifing that the node was either completely visited or not. If it was
completely visited, we don't inspect it anymore, otherwise, if the node was slightly tocuched, seen before, but was
not completely visited, it means that we have a cycle and we must backtrack the node with its ancestors and find the complete graph cycle.
If the node, wasn't inspected at all, we inspect it now with dfs and assign it state and parent(ancestor node). 

In this way we inspect all the nodes, while assigning them a cycle number in the backtracking process. 
All this happends in the class Graph (backtracking, cycle assignment), whereas in the class with the main - "HomeWorkAndBonus.java", with the help of the funciton *findLargestCycle* we find the largest cycle from our graph by comparing the length of all found cycles with the length k >= 3.

