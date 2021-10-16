## General :
1. Height of a generic tree (level of a generic tree): 
  - Means the distance from the root node to the deepest node
  - If height in terms of edges , then initialize height=-1
  - If height in terms of nodes, then initialize height = 0
  - faith , get the height of childrens of the root node
  - from faith to expectation, whichever child height is greater take that height and add one as there is one edge between the child node and root node
