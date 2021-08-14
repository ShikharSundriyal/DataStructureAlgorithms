Given n coins of certain denomination , find all permutations to pay a amount using n denominations 

Recursion : </br>
Faith :</br>
give me all the ways from x amount  - [ (x - arr[0]) , (x - arr[1]) , (x - arr[2]) ] (The number of calls will be equal to number of denominations we have as 1st way to pay will be either with denomination1, denomination2 or denomination3).</br>

From faith to expectation : </br>
we have all the ways from [ (x - arr[0]) , (x - arr[1]) , (x - arr[2]) ] so total ways will be sum of all three choices. </br>

Base case : </br>
if amt == 0 return 1 possible way
if amt<0 return 0



Tabulation :</br>
dp[i] -> no of permutations to pay i amount with using all the given coins.</br>
Smallest problem , how to pay 0 amount</br>
Biggest problem , how to pay 10 amount</br>
solve from 0 to 10</br>
from each i amount look at dp[i-arr[0]] + dp[i - arr[1]] + dp[i arr[2]]</br>
