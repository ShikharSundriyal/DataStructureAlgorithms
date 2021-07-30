Recursion on the way down :

Expectation : Get all the possible paths from sr,sc to dr,dc

Faith :<br />
1.) We will get all the paths from sr+1,sc to dr,dc if we move one horizontal move in maze.<br />
2.) We will get all the paths from sr,sc+1 to dr,dc if we move one vertical move in maze. <br />

From faith to expectation : <br />
1.) Append h to all the paths that we got from the subproblem of sr+1,sc to dr,dc.<br />
2.) Append v to all the paths that we got from the subproblem of sr,sc+1 to dr,dc<br />

Base case : <br />
1.) if sr == dr and sc == dc return arraylist with "" element<br />
2.) make sure we dont go out of maze i.e. sr > dr and sc > dc<br />

