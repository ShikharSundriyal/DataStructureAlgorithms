1. 1497 Check If Array Pairs Are Divisible by k :
  - Given an array of integers arr of even length n and an integer k. We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.Return true If you can find a way to do that or false otherwise. 
  - Approach 1 : 
   - Whenver we get a quetion based on devisible always check if we can use % .
   - here we iterate over the input array 
    - find the arr[i] % k and create a frequency map of remainders
    - Now we iterae over the frequncy key set 
      - check if k-key's is present in frequency map and the frequency is equal only then they will form a pair.
      - one edge case will be when key is zero then frequncy for that should be even otherwise return false
   - To handle negative numbers while creating frequency map, when the remainder is negative make sure to store them as k+arr[i]
   - as -5 % 6 is -5 but when we will try to find k-key while traversing frequency map it will become 6-(-5) which will be 11 as we are storing remainders , the remainders should always be between 0 to k-1 . so we store negative remainder as k+(rem). because -22  a number can be represented as -22 = -20 +(-2) , we add k and subtrack k , so the expression becomes , -22 = -25 + 3 where 3 is the remainder
 
<details><summary>Code</summary>
<p>

```java
  class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0;i<arr.length;i++){
            int rem = arr[i] % k;
            if(rem <0)
                rem+=k;
            hm.put(rem,hm.getOrDefault(rem,0)+1);
        }
        
        for(int rem:hm.keySet()){
            if(rem == 0){
                if(hm.get(rem)%2!=0) return false;
                else
                    continue;
            }
            int f1 = hm.get(rem);
            int f2 = hm.getOrDefault(k-rem,-1);
            if(f1!=f2) return false;
        }
        return true;
    }
}
  
```
  
</p>
</details>  


2. Longest subarray having sum 0
  - Brute force ,0(n3)
    - Normal three loops , one for starting point, other for ending point and one for starting to ending and calculate the sum
  - Approach 2 : 0(n2)
    - whenever we see subarraya and sum together we can think of using prefix sum which will optimise the previous approach also as instead of third loop we can store the prefix sum in an array and calculate the subarray sum from starting point to ending point with the help of prefix sum array.
  - Approach 3 : 0(n)
    - We will use HashMap , which will store the pprefix sum against the index at which that prefix sum is seen, if we see a pefix sum again that means all the elements between current index and first index where same prefix sum was seen has a subarray sum of 0.



<details><summary>Code</summary>
<p>

```java
  
   int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer> hm = new HashMap<>();
        int res = 0,ps=0;
        hm.put(0,-1);
        for(int i = 0;i<arr.length;i++){
            ps +=arr[i];
            if(hm.containsKey(ps)){
                res = Math.max(res,i-hm.get(ps));
            }else{
                hm.put(ps,i);    
            }
        }
        return res;
    }
                                                                   
    //Brute force
    int maxLen(int arr[], int n)
    {
        // Your code here
        int res=0;
        for(int i =0;i<arr.length;i++){
            
            for(int j= i;j<arr.length;j++){
                int subarraysum =0;
                for(int k=i;k<=j;k++){
                    subarraysum+=arr[k];
                   
                }
                 if(subarraysum == 0){
                        res = Math.max(res,j-i+1);
                    }
                
            }
        }
        return res;
    }                                                               
  
```
  
</p>
</details>  



3. Zero Sum Subarrays 
  - You are given an array arr[] of size n. Find the total count of sub-arrays having their sum equal to 0.
  - Approach 1 :
    - here we will create a hashmap storing, Prefix sum and the frequency of prefix sum
    - if we see a prefix sum already existing in the hashmap that means from i+1 to current index all elements sum is zero , in counting the nunber of sub arrays as the hashmap already has the frequency of number of times the same prefix sum was seen that means from the current position it can form x subarrayss wehre x is frequency of current prefix sum. 
    - Once we have taken the impact to the overall answer we add the prefix sum to the hashmap with frequency as 1 if we are seeing the prefix sum for the 1st time or we increase the already existing frequency of that prefix sum.
 

<details><summary>Code</summary>
<p>

```java
  
  public static int solution(int[] arr) {
        // write your code here
        HashMap<Integer,Integer>hm=new HashMap<>();
        hm.put(0,1);
        int ps = 0,ans=0;
        for(int i = 0;i<arr.length;i++){
            ps+=arr[i];
            if(hm.containsKey(ps)){
                int freq = hm.get(ps);
                ans+=freq;
            }
            hm.put(ps,hm.getOrDefault(ps,0)+1);
        }

        return ans;
    }

```
  
</p>
</details>  

4. 525 Contiguous Array
  - Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
  - Approach 1 : (gap of 0's and 1's at ith idx and gap of 0's and 1's at jth idx equal that means i+1 to jth idx has same number of 0's and 1's)
  - if there was a gap of 2 between number of 0's - number of 1's at a point x and going forward if we see a gap again of 2 between number of 0's - number of 1's at y idx that means from x+1 to yth idx equal number of 0's and equal number of 0's and 1's were added to the number of 0's and 1's that were present at x idx as the gap between the two is still constant.
  -
| idx        | x| y  |
| ------------- |:-------------:| -----:|
| 0's|4|6|
|1's|2|4|
|gap|2|2|
  
  - this means after xth idx 2 more 0's were added and 2 more 1's were added
  - Solution : 
    - in hashmap we will store the difference as key and the index at which that gap is seen as value.
    - initially diff is 0 for idx =-1 
    - then we travel over the array and see and calculate the number of 0's till ith idx and count of 1's till ith idx using same prefix approach and then calculate the  difference and check if that difference is present in hashmap if yes then calculate the length of the subarray which will be i-hm.get(diff) or else add diff and idx to hm .
  - Approach 2
    - Repace 0 with -1 and then apply longest subarray with sum 0 
    


<details><summary>Code</summary>
<p>

```java
  
  class Solution {
    public int findMaxLength(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int res =0;
        hm.put(0,-1); //difference btw num 0's - num 1's at -1 idx
        int c0=0,c1=0,diff=0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                c0++;
                diff = c0-c1;
            }else{
                c1++;
                diff = c0-c1;
            }
            if(hm.containsKey(diff)){
                res = Math.max(res,i-hm.get(diff));
            }else{
                hm.put(diff,i);
            }
        }
        return res;
    }
}

```
  
</p>
</details>  

    

5. Subarrays with equal 1s and 0s :
    - Given an array containing 0s and 1s. Find the number of subarrays having equal number of 0s and 1s.
    - Approach 1 : 
        - Here we will create a hashmap with key as gap i.e. difference in counts of zero - counts to 1's and value as the frequency we have seen this gap earlier
        - Initially we will put a entry 0 , 0 as gap and count will be 1.
        - Then we iterate over the array and increase the number of 1's and 0's based on the value of arr[i] and then calculate gap and see if we have seen the gap earlier
            - If we have seen that gap earlier then the frequency of thegap from the hashmap is fetched and added to overall answer and then we increase the frequency of that gap and put it in the hashmap.
            - if we are seeing that gap for the first time then we make a entry with gap,1

<details><summary>Code</summary>
<p>

```java
  
class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        HashMap<Integer,Integer>hm = new HashMap<>();
        hm.put(0,1);
        int c0=0,c1=0,ans=0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                c0++;
            }else{
                c1++;
            }
            int gap = c0-c1;
            if(hm.containsKey(gap)){
                ans+=hm.get(gap);
                hm.put(gap,hm.get(gap)+1);
            }else{
                hm.put(gap,1);
            }
        }

        return ans;
    }
}

```
  
</p>
</details>              



6. 325 Maximum Size Subarray Sum Equals k :
    - Given an integer array nums and an integer k, return the maximum length of a subarray that sums to k. If there is not one, return 0 instead.
    - As we need to get the max length of the subarray we wll create a hashmap which will store prefix sum vs first index at which that prefix sum is seen
    - We will check if the hashmap contains prefixsum-k in the hashmap 
        - if yes, we have an opportunity to make the answer
    - then we make a entry of prefix sum vs index in hashmap if it does not contain prefix sum earlier

<details><summary>Code</summary>
<p>

```java
  
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer,Integer>hm = new HashMap<>();
        hm.put(0,-1);
        int ans=0,ps=0;
        for(int i = 0;i<nums.length;i++){
            ps+=nums[i];
            
            if(hm.containsKey(ps-k)){
                ans = Math.max(ans,i-hm.get(ps-k));
            }
            hm.put(ps,hm.getOrDefault(ps,i));
        }
        return ans;
    }
}

```
  
</p>
</details>   

7. 560 Subarray Sum Equals K :
    - Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
    - Here as we have to find the total count of the subarrays we will create a hashmap of Prefix sum vs frequency of that prefix sum
    - We will iterate over the array and create prefix sum, at each index we will check if 
        - hashmap contains prefixsum - k 
            - if yes then we have an opportunity to make the answer
        - we will make the entry of the prefix sum in the hashmap , if we are seeing the prefix sum for the first time

<details><summary>Code</summary>
<p>

```java

 class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>hm = new HashMap<>();
        hm.put(0,1);
        int ps = 0,ans=0;
        for(int i = 0;i<nums.length;i++){
            ps+=nums[i];
            if(hm.containsKey(ps-k)){
                ans+=hm.get(ps-k);
            }
            hm.put(ps,hm.getOrDefault(ps,0)+1);
        }
        return ans;
    }
}

```
  
</p>
</details>   


8. Longest Subarray With Sum Divisible By K :
    - You have to find length of the longest subarray whose sum is divisible by K.
    - Here we will create a hashmap of rem vs index of first occurence of that rem
    - the rem will be calculated with the prefix sum % k , as rem is always positive if we get a -ve remainder we will make it positive by adding k to it
    - if we seen the remainder earlier that means from previous seen index + 1 to current idx the subarray is divisible by k 


<details><summary>Code</summary>
<p>

```java
 public static int solution(int[] arr, int k) {
        // write your code here
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int ans = 0,ps=0;
        for(int i = 0;i<arr.length;i++){
            ps+=arr[i];
            int rem = ps%k;
            if(rem<0){
                rem+=k;
            }
            
            if(hm.containsKey(rem)){
                ans = Math.max(ans,i-hm.get(rem));
            }
            hm.put(rem,hm.getOrDefault(rem,i));
        }

        return ans;
    }
    

```
  
</p>
</details>   

9. 974 Subarray Sums Divisible by K :
    - Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.  
    - Here we will create a hashmap of rem vs number of times we have seen this rem earlier
    - if we seen the remainder earlier that means from previous seen index+1 to current idx the subarray is divisible by k but as we only need the count of subarrays we will get the count of how many times we have seen this remainder which will the number of subarrays which are divisible. 


<details><summary>Code</summary>
<p>


```java

class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        HashMap<Integer,Integer>hm = new HashMap<>();
        int ps =0,ans=0;
        hm.put(0,1);
        for(int i =0;i<arr.length;i++){
            ps+=arr[i];
            int rem = ps%k;
            if(rem<0)
                rem+=k;
            if(hm.containsKey(rem)){
                ans +=hm.get(rem);
            }
            hm.put(rem,hm.getOrDefault(rem,0)+1);
        }
        return ans;
    }
}

```
  
</p>
</details>   



10. Longest Subarray With Equal Number Of 0s 1s And 2s 
    - You have to find length of the longest subarray with equal number of 0s, 1s, and 2s.
    - Here we will create a hashmap of a state where state is count of 0's - count of 1's @ count 1's - count 2's vs first index where this state is seen
    - at an index x and y if the two states are same that means elemnents from x+1 to y have equal number of 0 1 and 2


<details><summary>Code</summary>
<p>


```java

public static int solution(int[] arr) {
        // write your code here
        
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("0@0",-1);
        int c0=0,c1=0,c2=0,ans=0;
        for(int i =0;i<arr.length;i++){
            if(arr[i] == 0){
                c0++;
            }else if(arr[i]==1){
                c1++;
            }else{
                c2++;
            }
            
            int d1 = c0-c1;
            int d2 = c1-c2;
            String k = d1+"@"+d2;
            if(hm.containsKey(k)){
                ans = Math.max(ans,i-hm.get(k));
            }else{
                hm.put(k,i);
            }
        }
        return ans;
        // return 0;
    }

```
  
</p>
</details>   

11. Count Of Subarrays With Equal Number Of 0s 1s And 2s 
    - You have to find the count of subarrays with equal number of 0s, 1s, and 2s.
    - Here we will create a hashmap of state vs frequency of this state seen earlier

<details><summary>Code</summary>
<p>


```java

 public static int solution(int[] arr) {
        // write your code here
        HashMap<String,Integer>hm = new HashMap<>();
        hm.put("0@0",1);
        int c0=0,c1=0,c2=0;
        int ans = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==0){
                c0++;
            }else if(arr[i]==1){
                c1++;
            }else{
                c2++;
            }
            
            int g1 = c0-c1;
            int g2 = c1-c2;
            String state = g1+"@"+g2;
            if(hm.containsKey(state)){
                ans+=hm.get(state);
            }
            hm.put(state,hm.getOrDefault(state,0)+1);
        }
        return ans;
    }

```
  
</p>
</details>     


12. Word Pattern :
    - Given a pattern and a string s, find if s follows the same pattern.Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
    - Here there are three cases :
        - case 1 : pattern character is not present in hashmap and word element is not present in hashset that means its a new valid entry , add pattern chracter mapping with word element in hashmap and add word element to the hashset
        - case 2 : pattern character is already present in hashmap then we need to check if the key in hashmap is same as the current word element if not return false
        - case 3 : deault case i.e. if hashset already has arr[i] return false

<details><summary>Code</summary>
<p>


```java

class Solution {
    public boolean wordPattern(String pattern, String str) {
       
       String[] arr = str.split(" ");
        if(arr.length !=pattern.length()) return false;
        
        HashMap<Character,String>hm = new HashMap<>();
        HashSet<String>hs = new HashSet<>();
        for(int i = 0;i<pattern.length();i++){
            if(!hm.containsKey(pattern.charAt(i)) && !hs.contains(arr[i]) ){
                hm.put(pattern.charAt(i),arr[i]);
                hs.add(arr[i]);
            }else if(hm.containsKey(pattern.charAt(i))){
                if(!hm.get(pattern.charAt(i)).equals(arr[i])){
                    return false;
                }
            }else{
                return false;
            }
           
        }
        
        
        return true;
    }
}

```
  
</p>
</details> 


13. 1502 Can Make Arithmetic Progression From Sequence :
    - A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.
    - Approach 0(N) :
        -For a AP we need the common difference and the first term
        - for first term we can find the min element in the array
        - for common difference we find min and second min and subtract secondmin and min
        - we put all the elements of the array in the hashset
        - if common difference is 0 and hashset size is 1 then it means either array has only one element or all the elements in array are same so its a AP
        - else if common difference is 0 but hashset size() >1 that means there are more than two different elements in the array but common difference which is 0 is suggesting that all elements should be same in the array that is not the case so we reuturn false
        - now we travel from 1 to arr.length and check if the term is present in the hashset or not

<details><summary>Code</summary>
<p>


```java

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
         int min = Integer.MAX_VALUE,sec_min = Integer.MAX_VALUE;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<min){
                sec_min = min;
                min = arr[i];
            }else if(arr[i]<sec_min){
                sec_min = arr[i];
            }
            
            hs.add(arr[i]);
        }
        int cd = sec_min-min;
        
        if(cd == 0 && hs.size() == 1)
            return true;
        else if(cd == 0){
            return false;
        }
        int term = min;
        for(int i = 1;i<arr.length;i++){
            term +=cd;
            if(!hs.contains(term)) return false;
        }
        return true;
    }
}

```
  
</p>
</details>          


14. 205 Isomorphic Strings :
    - Given two strings s and t, determine if they are isomorphic.Two strings s and t are isomorphic if the characters in s can be replaced to get t.All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
    - Approach 1 : 
        - Very Similar to Word Pattern problem
        - Here we will create one hashmap and one hashset.
        - three cases :
            - If there is not an entry of string s ith character in hashmap and ith character of string t is not present in hashset then
                - make an entry in hashmap ( s.charAt(i), t.charAt(i)) and hashset t.charAt(i)
            - If there is entry of string s ith character in hashmap then,
                - we need to check if the current chacter from string t and the hashmap entry are same or not
            - If the hashset already has an entry for t string ith character that means two characters are mapping to same character


<details><summary>Code</summary>
<p>


```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> hm = new HashMap<>();
        HashSet<Character>hs = new HashSet<>();
        for(int i =0;i<s.length();i++){
            if(!hm.containsKey(s.charAt(i)) && !hs.contains(t.charAt(i))){
                hm.put(s.charAt(i),t.charAt(i));
                hs.add(t.charAt(i));
            }else if(hm.containsKey(s.charAt(i))){
                if(hm.get(s.charAt(i)) != t.charAt(i)) return false;
            }else if(hs.contains(t.charAt(i))){
                return false;
            }
            
            
        }
        return true;
    }
}

```
  
</p>
</details>     


15. 781 Rabbits in Forest :
    - There is a forest with an unknown number of rabbits. We asked n rabbits "How many rabbits have the same color as you?" and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit. Given the array answers, return the minimum number of rabbits that could be in the forest.
    - Approach : 
        - Create a frequency hashmap containing answers[i] as key and frequency as value
        - now iterate over the hashmap ,
            - group size = key+1, 
            - number of group = Math.ceil(1.0 * value/group_size)
            - number of rabbit in each group = number_of_group * group_size

<details><summary>Code</summary>
<p>


```java
class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<answers.length;i++){
            hm.put(answers[i],hm.getOrDefault(answers[i],0)+1);
        }
        int numRabbits = 0;
        for(int key:hm.keySet()){
            int groupSize = key+1;
            int val = hm.get(key);
            numRabbits += (int)Math.ceil(1.0*val/groupSize)*groupSize;
        }
        return numRabbits;
    }
}

```
  
</p>
</details>     

16. 554 Brick Wall :
    - There is a rectangular brick wall in front of you with n rows of bricks. The ith row has some number of bricks each of the same height (i.e., one unit) but they can be of different widths. The total width of each row is the same.Draw a vertical line from the top to the bottom and cross the least bricks. If your line goes through the edge of a brick, then the brick is not considered as crossed. You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.Given the 2D array wall that contains the information about the wall, return the minimum number of crossed bricks after drawing such a vertical line.
    - Approach :
        - Here we have to find the line which will intersect the least number of bricks.
        - Instead we will try to find out the position at which max number of bricks have a common ending this way we will find the line with least bricks intersection.
        - We will create a hashmap containing the brick_ending_position and freqency of (number of times a brick ended at this position).
        - We will iterate over the hasmap and see at which position did bricks end the most. if at 3rd position 5 bricks ended and the total rows were 7 then minimum 2 bricks were crossed if a vertcal line was drawn from 3rd position.
        - Point to remember is that we should not consider the bricks ending at last position because at last position all the bricks will be ending and there we will not cut any bricks .

<details><summary>Code</summary>
<p>


```java
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(List<Integer> ls:wall){
            int gap_ending_position = 0;
            for(int i = 0;i<ls.size()-1;i++){
                gap_ending_position+=ls.get(i);
                hm.put(gap_ending_position,hm.getOrDefault(gap_ending_position,0)+1);
            }
        }
        int max = 0;
        for(int gap_ending_position:hm.keySet()){
            int val = hm.get(gap_ending_position);
            if(val>max) max = val;
        }
        return wall.size()-max;
    }
}
```
  
</p>
</details>   


17. 242 Valid Anagram :
    - Given two strings s and t, return true if t is an anagram of s, and false otherwise.An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once 
    - Approach :
        - Firstly the length of both string should be equal if not return false
        - Create a frequency hashmap of charcter and occurence of that char in string t
        - now iterate over string t,
            - check if t.charAt(i) is prensent in hm 
                - if not present return false
                - if present reduce the frequency in the hashmap
        - now iterate over hashmap and check if any key is having value other than 0 if yes return false

<details><summary>Code</summary>
<p>


```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer>hm = new HashMap<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        for(int i =0;i<t.length();i++){
            char ch = t.charAt(i);
            if(!hm.containsKey(ch)) return false;
            else {
                hm.put(ch,hm.get(ch)-1);
            }
        }
        for(char c : hm.keySet()){
            if(hm.get(c)!=0) return false;
        }
        return true;
    }
}
```
  
</p>
</details>   
