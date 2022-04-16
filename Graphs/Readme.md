# Graphs Level 1:

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
	- Given a src and destination, print all the possible paths
	- Here we need to explore all the paths so we will unmark the visited vertex
```java
void printPath(ArrayList<Edge>[] graph, int src, int dest,boolean[] vis,String ans){
	if(src == dest) {
		System.out.println(ans+src);
		return;
	}
	vis[src]=true;
	for(Edge edge:graph[src]){
		if(vis[edge.nbr]==false){
			hasPath(graph,edge.nbr,dest,vis,ans+src);
		}
	}
	vis[src]=false;
}
```

	
	
# Graphs Level 2:
934. Shortest Bridge :
	- You are given an n x n binary matrix grid where 1 represents land and 0 represents water.An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.You may change 0's to 1's to connect the two islands to form one island.Return the smallest number of 0's you must flip to connect the two islands.
	- Approach 1 : 
		- As we need to find the minimum number of 0's to flip we will need to use Graph.
		- First fill the 1st island to a queue and mark all those lands to 2.
		- now while queue.size > 0 
			- rem the element from the Queue and apply top down left right element to the queue and add all 0 to queue and mark them visited 
			- when doing so if we encounter a 1 i.e. land that means we have encountered the next land and we have our answer
```java

class Solution {
    
    public static class Pair{
        int i;
        int j;
        int l;
        Pair(int i,int j,int l){
            this.i = i;
            this.j = j;
            this.l = l;
        }
    }
    public void travel(int[][] grid,int i, int j, ArrayDeque<Pair> q){
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0 || grid[i][j] == 0 || grid[i][j] == 2){
            return;
        }
        
        if(grid[i][j] == 1){
            grid[i][j] = 2;
            q.add(new Pair(i,j,0));
        }
        
        //tldr
       
        travel(grid,i-1,j,q);
        travel(grid,i+1,j,q);
        travel(grid,i,j-1,q);
        travel(grid,i,j+1,q);
        
    }
    public int shortestBridge(int[][] grid) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        int island = 0;
        for(int i = 0;i<grid.length;i++){
            if(island == 1) break;
            for(int j = 0;j<grid[i].length;j++){
                if(island == 1) break;
                if(grid[i][j] == 1){                    
                    island++;
                    travel(grid, i, j, q);
                     if(island == 1) break;
                }
                
            }
        }
        
        // System.out.println(q);
        while(true){
            Pair rem = q.remove();
            int i = rem.i;
            int j = rem.j;
            int level = rem.l;
            
            if(i-1<grid.length && i-1>=0 && j<grid[0].length && j>=0 && grid[i-1][j] == 1){ 
                return level;
            }
            if(i+1<grid.length && i+1>=0 && j<grid[0].length && j>=0 && grid[i+1][j] == 1){ 
                return level;
            }
            if(i<grid.length && i>=0 && j-1<grid[0].length && j-1>=0 && grid[i][j-1] == 1){ 
                return level;
            }
            if(i<grid.length && i>=0 && j+1<grid[0].length && j+1>=0 && grid[i][j+1] == 1){ 
                return level;
            }
            
            ////////////////
            
            if(i-1<grid.length && i-1>=0 && j<grid[0].length && j>=0 && grid[i-1][j] == 0){ 
                grid[i-1][j]=2;
                q.add(new Pair(i-1,j,level+1));
            }
            if(i+1<grid.length && i+1>=0 && j<grid[0].length && j>=0 && grid[i+1][j] == 0){ 
                grid[i+1][j]=2;
                q.add(new Pair(i+1,j,level+1));
            }
            if(i<grid.length && i>=0 && j-1<grid[0].length && j-1>=0 && grid[i][j-1] == 0){ 
                grid[i][j-1]=2;
                q.add(new Pair(i,j-1,level+1));
            }
            if(i<grid.length && i>=0 && j+1<grid[0].length && j+1>=0 && grid[i][j+1] == 0){ 
                grid[i][j+1]=2;
                q.add(new Pair(i,j+1,level+1));
            }
            
        }
        // return -1;
    }
}	
```
	

