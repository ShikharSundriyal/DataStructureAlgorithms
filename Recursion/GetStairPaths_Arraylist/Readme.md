Recursion on the way down approach :

Expectation : From stair n to stair 0 all possible ways with 1 2 and 3 jumps allowed.

Faith : We will get the paths from n-1 th staircase to 0th staircase, we will get all the paths from n-2nd staircase to 0th staircase and similarly from n-3rd staircase to 0th staircase.

From faith to Expectation :<br />
1.) we have all the possible ways from n-1 to 0 if we append 1 to this answer then we get all the answer possible from 0 to n if we take one step initially <br />
2.) we have all the possible ways from n-2 to 0 if we append 2 to this answer then we get all the answer possible from 0 to n if we take two step initially<br />
3.) we have all the possible ways from n-3 to 0 if we append 3 to this answer then we get all the answer possible from 0 to n if we take three step initially<br />

Base case : <br />
1.) if we have reached 0th staircase then return a arraylist with an element "".<br />
2.) as we are having n-3 we need to make sure that n is always greater than 0 for that either we apply smart calls or in the beginning we have a check that if n<0 return empy arrylist.<br />
