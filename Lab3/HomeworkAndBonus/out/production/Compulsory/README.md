## Compulsory
***

Created an object-oriented model of the networking problem. 
Introduced the classes Network, Node, Computer, Router, Switch. 
Created the interfaces Identifiable and Storage and implemented interfaces accordingly.
The Network class contains a List of nodes.
Created and printed all the nodes in the network (without the time costs).

## Homework

***

Each node contains a Map representing the time costs. Created and printed the complete network in the example.
Created a default method in the interface Storage, that is able to return the storage capacity in other units of storage (megabyte, kilobyte, byte).
In the Network class, created a method to display the nodes that are identifiable, sorted by their addresses.
Implemented an efficient agorithm (djikstra) to determine all the shortests times required for data packets to travel from an identifiable node to another using djikstra.

## Bonus 

***
 
Implemented an efficient agorithm (using djikstra again) to determine the safest route for a packet to travel between two given nodes.
Didn't generate random instances with JUnit.