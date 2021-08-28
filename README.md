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

2. Arrange Building : [Code](https://github.com/ShikharSundriyal/DataStructureAlgorithms/blob/main/DynamicProgramming/Arrange%20Buildings/solution.java) very similar to Count Binary String only change is here you have to multiply the answer with itself </br>
Recursive : 
</br>faith get all the possible combination for n-1 plots such that no 2 buildings are together -> returns an array a[]
</br> from faith to expectation myans[0] = total ways ending with building a[1], myans[1] = total ways ending with space a[0]+a[1]

3. Count Posssible encodings : [Code](https://github.com/ShikharSundriyal/DataStructureAlgorithms/blob/main/DynamicProgramming/Count%20Encoding/solution.java)</br>
Tabulation :  dp[i] will store count of all possible encodings of string from 0 to i characters. base case = dp[0] and dp[1]. from i = 2 onwards we can have contribution from dp[i-1] + dp[i-2] based on the condition that the encoding formed is correct .



## Group 3 :(DP) </br> 
1. count of subsequence of type a+b+c+
        Recursive : </br>
            Faith : we will get an array filled with count of subsequence of type arr[0] -> a+, arr[1] -> a+b+ and arr[2] -> a+b+c+
            From faith to expectation : if last char == a or char == b or char == c , make adjustments to the value of appropriate arr[0] or arr[1] or arr[2]
3. maximum sum non adjacent elements 
       Recursive : </br>
            Faith : call1 -> we have the maximum sum of non adjacent elements for idx+1 if we include </br>
                    call2 -> we have the maximum sum of non adjacent elements for idx+1 if we exclude current idx </br>
            Faith to expectation : return the max from call1 and call2. </br>
        Tabulation 1: </br> 
            dp[i] -> stores the maximum sum if we include the element at i and the maximum sum that we have if we dont include the ith element.</br>
            only 4 variables required , oldexclude, oldinclude , newinclude and newexclude
            at each ith position if we include the ith element newinlude = oldexclude + arr[i] </br>
            at each ith position if we exclude the ith element newexclude =  + math.max(oldexclude, oldinclude) </br>
            after that reset the oldexlude = newexclude and oldinclude = newinclude</br>
         Tabulation 2:</br>
            dp[i] stores the max sum of non adjacent element ending with ith element.
               
4. paint house </br>
    Tabulation : </br>
        2d dp reequired, i  corresponds to the house number , j corresponds to the colour.</br>
        dp[i][j] stores -> min cost to paint all houses from [0 i] where ith house is painted with jth colour. </br>
    Recursive : </br>
        Faith : get the minimum cost of idx+1 if we paint 0th index with colour 0</br>
                get the minimum cost of idx+1 if we paint 0th index with colour 1</br>
                get the minimum cost of idx+1 if we paint 0th index with colour 2</br>
        Faith to expectation : Minimum of all faiths. 
6. paint house many colours </br>
       Tabulation : </br>
       2d dp required, i corresponds to house number , j corresponds to the colour </br>
       dp[i][j] stores -> min cost to paint all houses from [0 to i ] where ith house is paisnted by jth colour</br>
       Note : We have to keep min and second min for each row 
       
7. paint fence</br>


## Group 4 :(DP) </br> 
1. Tiling With 2 * 1 Tiles :</br>
Recursive : from source(floor not tiled at all) to destination(floor completely tiled)</br>
call 1 -> place one tile horizontally (solve for 2,n-2)</br>
call2 -> place one tile vertically (solve for 2,n-1)</br>
Tabulation : </br>
dp[i] -> stores no of ways to floor the tile of breadth i.
dp[i] = dp[i-1]+dp[i-2]
2. floor tiling
3. friends pairing
4. partition into subsets
