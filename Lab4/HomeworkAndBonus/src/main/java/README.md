## Compulsory 

***

Created a Maven project.
Introduced an object-oriented model of the problem (streets have names and lengths, intersections have names). A street joins two intersections.
Introduced the streets and the intersections of the problem described in the example. All the edges and vertices have a name.

Also, used streams in order to easily create the intersections.
```java
Intersection[] nodes = IntStream.rangeClosed(0, 8) .mapToObj(i -> new Intersection("vertice" + i) ) .toArray(Intersection[]::new);
ArrayList<Intersection> nodesList =
new ArrayList<Intersection>(Arrays.asList(nodes));
```
Created a list of streets, using LinkedList implementation and sorted it by the length, using a comparator expressed as a method reference.
Created a set of intersections, using a HashSet implementation and doublechecked the properties of the hashset.

## Homework 

***

Created a class that describes the city called CityMap.
Using Java Stream API, wrote a query that displayed all the streets that are longer than a specified value and join at least 3 streets.
Used the java faker in order to generate random fake names for intersections and streets.
Also used JGraphT in order to solve the problem (or other library) using Prims

## Bonus 

***

Implemented an algorithm that determines the route of the maintenance car, in order to minimize the total length using MetricTSP.
Created a random problem generator, making sure that the lengths between intersections satisfy the triangle inequality.
