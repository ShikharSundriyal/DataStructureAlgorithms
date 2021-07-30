Recursion on the way down approach

Exceptation : We are at 0,0 we can take any number of jumps horizontally , vertically and diagnally . We weed to print all the possible paths from 0,0 to dr,dc.

Faith : <br/>
1.) Horizontal moves : </br>
If we are at 0,0 then we can move to 0,1 with h1 move, 0,2 with h2 move, 0,3 with h3 move and so on .<br/>
From 0,1 to dr,dc we will get the solution thats our faith.<br/>
From 0,2 to dr,dc we will get the solution thats our faith.<br/>
.<br/>
.<br/>
.<br/>

2.) Vertical Moves : <br/>
If we are at 0,0 then we can move to 1,0 with v1 jump, 2,0 with v2 jump and so on.<br/>
From 1,0 to dr,dc we will get the solution thats our faith.<br/>
From 2,0 to dr,dc we will get the solution thats our faith.<br/>
.<br/>
.<br/>
.<br/>

3.) Diagnol Moves : <br/>
If we are at 0,0 then we can move to 1,1 with d1 jump , 2,2 with d2 jump and so on.<br/>
From 1,1 to dr,dc we will get the solution thats our faith.<br/>
From 2,2 to dr,dc we will get the solution thats our faith.<br/>
.<br/>
.<br/>
.<br/>

From Faith to Expectation :<br/>
we need to add h + i to all horizontal moves to final list.<br/>
we need to add v + i to all vertical moves to final list.<br/>
we need to add d + i to all diagnol moves to final list.<br/>
