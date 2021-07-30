Faith :
We will get the subsequence for bc(subproblem) i.e. [,b,c,bc]

Expectation :
We will need the subsequence for abc .

From faith to expectation :
a needs to be added to faith along with a does not need to be added to faiths answers 
so final answer = [,b,c,bc,a,ab,ac,abc].

Base case : 
when string length becomes zero than the base case will hit and we need to return a arraylist which contains one element i.e "".
