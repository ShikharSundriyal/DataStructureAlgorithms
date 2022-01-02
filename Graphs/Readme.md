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

3. Connected components : (Important concept)
  - A graph can have connected as well as disconnected components.
  - A connected component is if we start from an vertex which all vertex we are able to touch or traverse .
  - In order to get a list of connected components, we need to iterate over each vertex and mark them visited and then call travel function. In the travel function all the vertex will be visited which are part of the connected component from that vertex.
  - Now we will iterate over non visited elements and get the connected components from that vertex. 

# Questions : 
1. Has Path : 
  - Given a graph, source and destination tell whether there is a path between the source and destination
  - Make a travel function which takes grpah , src , destination and a boolean matrix of length total vertex
  - public void travel(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited)
  ```java
boolean hasPath(ArrayList<Edge>[] graph, int src, int dest,boolean[] vis){
	if(src == dest) return true;
	vis[src]=true;
	for(Edge edge:graph[src]){
		if(vis[edge.nbr]==false){
			hasPath(graph,edge.nbr,dest,vis);
		}
	}
	return false;
	
}
  ```

2. Print all paths :
  
