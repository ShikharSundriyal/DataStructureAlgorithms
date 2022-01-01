# Graphs :

1. Creation of graph :
  - Graph can be imagined as combination of vertex and edges. The vertex are stored in an array as they are of fixed length and the edges are stored in an Arraylist against each array index as each vertex can have multiple edges/neighbours
  - vertex 0 -> Arraylist [ (vertex,neighbour1,weight) , (vertex,neighbour2,weight2) ]
  - vertex 1 -> ArrayList [ (vertex,neighbour1,weight) , (vertex,neighbour2,weight2) ]
  - vertex 2 -> Arraylist [ (vertex,neighbour1,weight) , (vertex,neighbour2,weight2) ]
  - vertex 3 -> ArrayList [ (vertex,neighbour1,weight) , (vertex,neighbour2,weight2) ]

2. Traversing over a Graph :
  - We can start with any vertex 
  - Travel over the neighnours of the graph except coming back to the original neighnour for that use a visited array and make sure we dont visit the visited node

3. Has path
