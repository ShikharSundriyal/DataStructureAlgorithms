# DataStructureAlgorithms
Basic concepts and questions of some DataStructures that are most commonly used.

Problem Groups :</br>
## Group 1 :(DP) </br> 
1. Target Sum Subset </br>
    Recursive : at level keep the element of the array , at each level we can either select an element from the level or reject the element from the level to form the target. At next level we will decide for next element of the array . So at each level we have two choices the element will contribute to form the target or the elemnent will not contribute to form the target.</br>
    Tabulation : Here 2d DP is required as at each level the index and amount are varying.</br>
    dp[i][j] -> number of ways to form target 'j' using array of elements from 0 to i.
3. Coin Change Combination </br>
    Recursive : at level keep's one coin at a time , we can either use the available coin to pay the amount in this case the amt will get subtracted from the coin and in next level we have all the coins available or we do not use the available coin at this level so amount will remain unchanged but at next level we will not have the previous coin which we did not select .
    So here both amount and index for coins is changing so 2D dp required for tabulation.</br>
    Tabulation : Here we can have 2 solutions , first 2d dp and second with 1d dp. </br>
    for 1d dp : apply the effect of each coin only once that can be done via coins loop outside and amount loop inside.
    
5. Coin Change Permutation ([Code](https://github.com/ShikharSundriyal/DataStructureAlgorithms/tree/main/DynamicProgramming/coin_change_permutation))</br> 
    Recursive : at level we will keep amount and at choices we will keep all the coins. For each amount we can try to use all 3 coins which means . No. of calls is equal to number of coins present.</br>
    Tabulation : 1D dp required as from the recursive code we can see only amount is varying at each level. 
                 dp[i] indicates total number of ways to pay i amount using all avialable coins.
    
6. Zero one Knapsack (Can be related to target sum subset)</br>
    Recursive :
    tabulation : 2d dp required, dp[i][j] -> using items from [0 to i] having max profit generated for capacity of 'J'.

7. Unbounded knapsack : (can be related to coin change combination or coin change permutation doesnt matter) ([Code](https://github.com/ShikharSundriyal/DataStructureAlgorithms/blob/main/DynamicProgramming/Unbounded%20knapsack/solution.java))</br>
    Recursive : similar to coin change permutation , only capacity changing. level correponds to capacity and at each Level we have arr.length choices.</br>
    Tabulation : using 1d dp , dp[i] -> max profit that can be created for capacity i. At each index we will have arr.length choices select max one.
   
8. Fractional Knapsack </br>


## Group 2 :(DP) </br> 

1. Count Binary String : [Code](https://github.com/ShikharSundriyal/DataStructureAlgorithms/blob/main/DynamicProgramming/Count%20binary%20string/solution.java)</br> 
 Recursive : </br>
             Approach 1 : 1st call count of length n-1 strings ending with 0, 2nd call count of length n-1 strings ending with 1</br>
             Approach 2 : (will return an array containing strings ending with 0 and engind with 1 wihout consecutive 0)</br>
                    faith count of binary string of length n-1 without consecutive 0.</br>
                    function : int[] getcbs(int n)</br>
Tabulation : dp requires only 4 variables , variable one-> dp[i] -> strings of length 'i' ending with 0 , another variable strings of length 'i' ending with 1 </br>

2. Arrange Building : very similar to Count Binary String only change is here you have to multiply the answer with itself </br>
Recursive : 
</br>faith get all the possible combination for n-1 plots such that no 2 buildings are together -> returns an array a[]
</br> from faith to expectation myans[0] = total ways ending with building, myans[1] = total ways ending with space 
