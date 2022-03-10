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


18. 760 Find Anagram Mappings :
    - You are given two integer arrays nums1 and nums2 where nums2 is an anagram of nums1. Both arrays may contain duplicates.Return an index mapping array mapping from nums1 to nums2 where mapping[i] = j means the ith element in nums1 appears in nums2 at index j. If there are multiple answers, return any of them.An array a is an anagram of an array b means b is made by randomizing the order of the elements in a.
    - Approach 1 :
        - we will first create the hashmap from nums2 having key as nums2[i] and value as an arraylist of index where nums2[i] are present
        - Now we will iterate over the nums1 array and check this element is present in which position in the hashmap.

<details><summary>Code</summary>
<p>


```java
class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer,ArrayList<Integer>>hm = new HashMap<>();
        
        for(int i=nums2.length-1;i>=0;i--){
            ArrayList<Integer> val = hm.getOrDefault(nums2[i], new ArrayList<>());
            val.add(i);
            hm.put(nums2[i],val);
        }
        int[] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ArrayList<Integer> al = hm.get(nums1[i]);
            int idx = al.get(al.size()-1);
            al.remove(al.size()-1);
            hm.put(nums1[i],al);
            res[i] = idx;
        }
        return res;
    }
}
```
  
</p>
</details>   

19. 914 X of a Kind in a Deck of Cards :
	- In a deck of cards, each card has an integer written on it.Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
		- Each group has exactly X cards.
		- All the cards in each group have the same integer.
	- Approach 1 :
		- create a frequency hashmap of card number and number of cards of that card number
		- Now we have to find if it is possible to split into multiple groupSize
			- In order to achieve that we have to take the GCD of all the frequency of the keys if final GCD is other than 1 that means we can group the cards in some groups following all the conditions
			- example a->4 , b->6 which tells us there are 4 cards with a name and 6 cards with name b. we can split them into group of 2's each such that it all the cards in each group is same and each group has name number of cards. 
			- The number 2 is achieved by taking the GCD of 4 and 6 which denotes 2 can divide both the numbers completely. 

<details><summary>Code</summary>
<p>


```java
class Solution {
    public int findGcd(int a,int b){
        while(a%b!=0){
            int rem = a%b;
            a=b;
            b = rem;
        }
        return b;
        // recursion to find GCD
//         if(b==0) return a;
//         int rem = a%b; 
//         return findGcd(b,rem);
        
    }
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer>hm= new HashMap<>();
        for(int i = 0;i<deck.length;i++){
            hm.put(deck[i],hm.getOrDefault(deck[i],0)+1);
        }
        int gcd = 0;
        for(int k:hm.keySet()){
            gcd = findGcd(gcd,hm.get(k));
        }
       
        return gcd != 1;
    }
}
```
  
</p>
</details> 


20. 1347 Minimum Number of Steps to Make Two Strings Anagram :
	- You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.Return the minimum number of steps to make t an anagram of s.An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
	- Approach 1 : 
		- Create a frequency hashmap of str1 
		- Now travel over the str2 and subtract the frequency from the hashmap and which characters are not present put a entry in hashmap with key as character and value as -1
		- Now iterate over the hashmap and take a sum of all the negative frequency that will the answer
<details><summary>Code</summary>
<p>


```java
class Solution {
    public int minSteps(String str1, String str2) {
        HashMap<Character,Integer> hm1 = new HashMap<>();
 	 	for(int  i=0;i<str1.length();i++){
 	 	    hm1.put(str1.charAt(i),hm1.getOrDefault(str1.charAt(i),0)+1);
 	 	    
 	 	}
 	 	
        for(int  i=0;i<str2.length();i++){
            if(!hm1.containsKey(str2.charAt(i))){
                hm1.put(str2.charAt(i),-1);
            }else{
                hm1.put(str2.charAt(i),hm1.getOrDefault(str2.charAt(i),0)-1);
            }
        }
 	 		int count=0;
 	 		for(char ch:hm1.keySet()){
 	 		    if(hm1.get(ch)>0) count+=hm1.get(ch);
 	 		}
        return count;
    }
}
```
  
</p>
</details> 


21. 49 Group Anagrams :
	- Given an array of strings strs, group the anagrams together. You can return the answer in any order.An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
	- Approach 1 :
		- Create a HashMap with key as <HashMap<Character,Integer>> and value as as ArrayList
		- now iterate over the Strings array 
			- create a temp hashmap which is a frequency hashmap 
			- now check if this temo hashmap is present in the main hashmap or not , if present add the current string to the arraylist of the value and if not present create a new arraylist and add the string
		- At the end iterater over the main hashmap and get all the values and add those to a final list of list
	- Approach 2 :
		- Create a function which gives you string which contains all the character in sorted order concatenated with the frequency of those characters . example "bor" output -> b1o1r1 
		- Iterater over the strings array and apply the above function to get a key , now store that key in a hashmap with value as a arraylist of that string . Repeat this for all the string elements.
		
		
		
<details><summary>Code</summary>
<p>


```java
class Solution {
// Approach 1 
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,ArrayList<String>>hm  = new HashMap<>();
        
        for(String s:strs){
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i = 0;i<s.length();i++){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
            ArrayList<String> al = hm.getOrDefault(map,new ArrayList<>());
            al.add(s);
            hm.put(map,al);
        }
        List<List<String>> res = new ArrayList<>();
        for(HashMap<Character,Integer> a:hm.keySet()){
            res.add(hm.get(a));
        }
        return res;
    }
}

// Approach 2 : 
class Solution {
    public String getKey(String s){
		int[] arr = new int[26];
		for(int i = 0;i<s.length();i++){
			char ch = s.charAt(i);
			arr[ch-'a']+=1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++){
			if(arr[i]==0) continue;
			char ch = (char)('a'+i);
			int count = arr[i];
	        sb.append(ch+""+count);
		}
		return sb.toString();
	}
	public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String,ArrayList<String>>hm=new HashMap<>();
	   for(String s:strs){
		   String k = getKey(s);
		   ArrayList<String> al = hm.getOrDefault(k,new ArrayList<>());
		   al.add(s);
		   hm.put(k,al);
	   }
	   List<List<String>> res = new ArrayList<>();
	   for(String key:hm.keySet()){
		   res.add(hm.get(key));
	   }
	   return res;
    }
}
```
  
</p>
</details> 

# Acquire and release Strategy : 


22. 76 Minimum Window Substring :
    - Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
    - create a variable matchcount = 0, i =-1 , j = -1 
    - create a frequency hashmap for t
    - Now while i is less than s.length() - 1
        - acquire till the time we are not valid i.e. matchcount < t.length -> we acquire the ith character and put in a hashmap , if the chracter is also present in the t hashmap and the frequeny of char ch in t >= frequency of ch in hm then increase matchcount
        - release will the time we do not become invalid again, as we are valid when we enter the release phase we will make the answer and then release the jth character i.e. reduce the frequency by one and if it becomes zero remove the key , after doing so we check if we have become invalid that is done by checking the character that was removed or frequency reduced was it present in the t hashmap and the frequency of that character in t hashmap > frequency of the character in hm hashmap if yes decrement matchcount.

<details><summary>Code</summary>
<p>

```java
public String minWindow(String s, String t) {        
        int mtc = 0;
        HashMap<Character,Integer>sm = new HashMap<>(); //for current window
        HashMap<Character,Integer>tm = new HashMap<>(); //for 't' string
        
        for(int i=0; i < t.length();i++) {
            char ch = t.charAt(i);
            int nf = tm.getOrDefault(ch,0) + 1;
            tm.put(ch,nf);
        }
        
        int as = -1;
        int ae = -1;
        int olen = Integer.MAX_VALUE;
        int i = -1; //aquiring
        int j = -1; //release
        
        while(i < s.length()-1) {
            //aquire 
            while(i < s.length()-1 && mtc < t.length()) {
                i++;
                
                //aquire ith char 
                char ch = s.charAt(i);
                
                int nf = sm.getOrDefault(ch,0) + 1;
                sm.put(ch,nf);
                
                //impact on mtc
                if(sm.get(ch) <= tm.getOrDefault(ch,0)) {
                    mtc++;
                }
            }
            
            //release
            while(j < i && mtc == t.length()) {
                //ans -> j+1 to i
                
                int len = i-j;
                if(len < olen) {
                    as = j+1;
                    ae = i;
                    olen = len;
                }
                
                j++;
                
                //release jth char
                char ch = s.charAt(j);
                if(sm.get(ch) == 1) {
                    sm.remove(ch);
                }
                else {
                    int nf = sm.get(ch) - 1;
                    sm.put(ch,nf);
                }
                
                //impact on match count
                if(sm.getOrDefault(ch,0) < tm.getOrDefault(ch,0)) {
                    mtc--;
                }
            }
        }
        
        if(as == -1 && ae == -1) {
            return "";
        }
        
        return s.substring(as,ae+1);
    }

```
</p>
</details> 


23. Smallest distinct window :
    - Given a string 's'. The task is to find the smallest window length that contains all the characters of the given string at least one time.
    For eg. A = aabcbcdbca, then the result would be 4 as of the smallest window will be dbca.
    - create a hashset and add all characters of the string
    - now acquire : we will acquire while hashmap.size() != hashset.size()
    - release : we will keep on releasing till the time we are valid i.e. hashmap.size() == hashset.size() 
    - answer making will happen inside the release phase before releaseing
<details><summary>Code</summary>
<p>

```java

class Solution {
    public String findSubString( String str) {
        // Your code goes here
        HashSet<Character>hs=new HashSet<>();
        for(int i =0;i<str.length();i++){
            hs.add(str.charAt(i));
        }
        HashMap<Character,Integer>hm = new HashMap<>();
        int i = -1,j=-1,ans=Integer.MAX_VALUE;
        int si=-1,ei=-1;
        while(i<str.length()-1){
            while(i<str.length()-1 && hm.size()<hs.size()){
                i++;
                char ch = str.charAt(i);
                hm.put(ch,hm.getOrDefault(ch,0)+1);
            }
            while(j<i && hm.size()==hs.size()){
               
                if(ans>i-j){
                    si = j+1;
                    ei = i;
                    ans = i-j;
                }
                j++;
                char ch = str.charAt(j);
                if(hm.get(ch)==1){
                    hm.remove(ch);
                }else{
                    hm.put(ch,hm.get(ch)-1);
                }
            }
        }
        // System.out.println(ans);
        if(si==-1 && ei==-1) return "";
        return str.substring(si,ei+1);
    }
}

```
</p>
</details> 



24. 3 Longest Substring Without Repeating Characters :
    - Given a string s, find the length of the longest substring without repeating characters.
    - We will use acquire and release straregy , 
    - we will acquire indefinately , till the time while acquiring we encounter an element which has come already at that point we break as we have become invalid
    - we will release indefinately , till the time while releasing we encounter an element whose frequency is greater than 1 then we reduce frequency and break as we are again valid.
    - answer making will happen at acquiring stage when we are putting an element to the hashmap which is coming for the first time that is a valid substring and that should be counted in the answer.


<details><summary>Code</summary>
<p>


```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i =-1,j=-1,ans = 0;
        HashMap<Character,Integer>hm = new HashMap<>();
        while(i<s.length()-1){
            //acquire
            while(i<s.length()-1 ){
                i++;
                char ch = s.charAt(i);
                
                if(hm.containsKey(ch)){
                    hm.put(ch,hm.get(ch)+1);
                    break;
                }else{
                     hm.put(ch,1);
                    //make answer
                    ans = Math.max(ans,i-j);
                }
            }
            
            //release
            while(j<i){
                //answer
                j++;
                char ch = s.charAt(j);
                if(hm.getOrDefault(ch,0) == 1){
                    hm.remove(ch);
                }else{
                    hm.put(ch,hm.get(ch)-1);
                    break;
                }
            }
        }
        return ans;
    }
}

```
  
</p>
</details> 

25. Count Of Substrings Having All Unique Characters :
    - You are given a string.
    - You have to find the count of valid substrings of the given string.
    - Valid substring is defined as a substring that has all unique characters.
    - example gfg : ( “g“, “gf“, “gfg”, “f“, “fg“, “g” )  ans = 5
    - Acquire indefinately , if the element that we acquire is a new character then add number of subarrays ending with char ch will be i-j and if we are encountering the element for the second time then we add the element to the hashmap with increased frequency but we dont make the answer as we are in invalid state and break.
    - we release indefinately , if the element we get has a frequency as 1 in hashmap then we remove that element from the hashmap and if we get an element whose frequency is more than 1 than we reduce its frequency in hashmap and now we have landed into a valid state and me make our answer here also.
    - here answer making happens at both acquire and release phase.



<details><summary>Code</summary>
<p>


```java
    public static int solution(String s) {
        // write your code here
        HashMap<Character,Integer>hm = new HashMap<>();
        int ans=0,i=-1,j=-1;
        while(i<s.length()-1){
            //acquire
            while(i<s.length()-1){
                i++;
                char ch = s.charAt(i);
                int nf = hm.getOrDefault(ch,0)+1;
                if(nf == 1){
                    hm.put(ch,1);
                    ans+=i-j;
                }else{
                    hm.put(ch,nf);
                    break;
                }
            }
            //release
            while(j<i){
                j++;
                char ch = s.charAt(j);
                int nf = hm.get(ch);
                if(nf == 1){
                    hm.remove(ch);
                }else{
                    hm.put(ch,nf-1);
                    ans+=i-j;
                    break;
                }
            }
        }
        
        return ans;
    }
```
  
</p>
</details> 


26. Longest K unique characters substring :
    - Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.
    - S = "aabacbebebe", K = 3 , Output: 7
    - As we have to form the largest string , we will make the answer in the acquire phase .
    - acquire : we wil keep on acquiring till the hashmap size is less than or equal to k
    - we will make the answer inside acquire phase if the hashmap size is equal to k.
    - release : we will come inside release phase if the hashmap size has become more than the k , then we will release till the hashmap.size() not equal to k.

<details><summary>Code</summary>
<p>


```java
class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        if(k>s.length()) return -1;
        int i = -1,j=-1,ans = -1;
        HashMap<Character,Integer>hm = new HashMap<>();
        while(i<s.length()-1){
            //acquire
            while(i<s.length()-1 && hm.size()<=k){
                i++;
                char ch = s.charAt(i);
                int nf = hm.getOrDefault(ch,0)+1;
                hm.put(ch,nf);
                if(hm.size() == k){
                    ans = Math.max(i-j,ans);
                }
            }
            while(j<i && hm.size() != k){
                j++;
                char ch = s.charAt(j);
                int nf = hm.get(ch);
                if(nf == 1){
                    hm.remove(ch);
                }else{
                    hm.put(ch,nf-1);
                }
            }
        }
        return ans;
    }
}
```
  
</p>
</details> 


27. 485 Max Consecutive Ones :
    - Given a binary array nums, return the maximum number of consecutive 1's in the array.
    
    -  Approach 1 :
        - iterate over the array , if arr[i] == 1 then increase the count of continuous 1's
            - if arr[i] == 0 then make your answer by comparing the count of continuous 1's with the previous max and then make the count of continuous 1's as 0 as we have encountered 0.

<details><summary>Code</summary>
<p>


```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count =0,ans=0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                ans = Math.max(ans,count);
                count =0;
            }else{
                count++;
            }
        }
        ans = Math.max(ans,count);
        return ans;
    }
}
```
  
</p>
</details> 

28. 487 Max Consecutive Ones II :
    - Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
    - Brute force : 0(n2)
        - iterate over the array , find 0 and make it to 1 and then find the continuous number of 1's in the modified array and do it for all 0's
    - Optimised Approach :
        - Based on acquire adn release
        - acquire : we will acquire till count of turned 0's is less than or equal to 1.
        - release : we will keep on releasing while count of turned 0's is not equal to 1.
        - answer making : we will make the answer at the release phase as when we enter the release phase we have the count of consecutive 1's in a variable when we flipped 1 0 to 1. One additional check will be once we are out of all the loops to compare if the count of 1's is greater than the answer so far.


<details><summary>Code</summary>
<p>

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c0=0,c1=0,oans=0,ans=0;
        int i =-1,j=-1;
        
        while(i<nums.length-1){
            //acquire
            while(i<nums.length-1 && c0<=1){
                i++;
                if(nums[i]==1){
                    c1++;
                }else{
                    if(c0 == 1){
                        c0++;
                    }else{
                        c0++;
                        c1++;
                    }
                }
                
            }
            //release
            while(j<i && c0!=1){
                ans = Math.max(c1,ans);
                j++;
                if(nums[j] == 1){
                    c1--;
                }else{
                    c0--;
                }
            }
        }
        ans = Math.max(c1,ans);
        return ans;
    }
}
```
  
</p>
</details> 


29. 1004 Max Consecutive Ones III :
    - Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
    - Approach 1 :
        - Same approach as above where we use acquire and release but instead of comparing count of turned 0's to 1 we will compare it with k
<details><summary>Code</summary>
<p>

```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int c0=0, c1=0;
        int ans =0,i=-1,j=-1;
        while(i<nums.length-1){
            while(i<nums.length-1 && c0<=k){
                i++;
                if(nums[i]==1){
                    c1++;
                }else{
                    if(c0<k){
                        c1++;
                        c0++;
                    }else{
                        c0++;
                    }
                }
            }
            while(j<i && c0!=k){
                ans = Math.max(ans,c1);
                j++;
                if(nums[j]==0){
                    c0--;
                }else{
                    c1--;
                }
            }
        }
        ans = Math.max(ans,c1);
        return ans;
    }
}
```
  
</p>
</details> 

30. 340 Longest Substring with At Most K Distinct Characters :
    - Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
    - Approach 1 :
        - Acquire : we will acquire till hashmap.size is less than or equal to k
        - Release : we will release till the hashmap.size not equal to k
        - answer making : we will make the answer at both acquire and release phase but the actual answer will come from acquire and release answer will always be smaller than the answer that we get from acquire

<details><summary>Code</summary>
<p>

```java
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k>s.length()) return s.length();
        int i = -1,j=-1,ans=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        
        while(i<s.length()-1){
            //acquire
            while(i<s.length()-1 && hm.size()<=k){
                i++;
                char ch = s.charAt(i);
                int nf = hm.getOrDefault(ch,0)+1;
                hm.put(ch,nf);
                if(hm.size()<=k){
                    ans = Math.max(ans,i-j);
                }
            }
            //release
            while(j<i && hm.size()!=k){
                
                j++;
                char ch = s.charAt(j);
                if(hm.get(ch)==1){
                    ans = Math.max(ans,i-j);
                    hm.remove(ch);
                }else{
                    hm.put(ch,hm.get(ch)-1);
                }
            }
        }
        return ans;
    }
}
```
  
</p>
</details> 


31. Count Of Substrings Having At Most K Unique Characters :
	- You are given a string(str) and a number K.
	You have to find the count of substrings of the given string that contains at most K unique characters.
	- Input : aabcbcdbca , 2
	- Output : 23
	- Approach 1 : (from jth idx to ith idx, number of substrings ending with ith idx will be i-j )
		- Acquire : We will acquire till the hashmap size is <= k
		- Release : We will release till the hashmap size > k
		- Answer making : we will make the answer in both acquire and release phase. In acquire because atmost is given and in release because once after removing an element from hashmap in release we become again valid for that instance.
	
	
<details><summary>Code</summary>
<p>

```java
public static int solution(String s, int k) {
		// write your code here
		int ans=0,i=-1,j=-1;
		HashMap<Character,Integer>hm=new HashMap<>();
		
		while(i<s.length()-1){
		    //
		    while(i<s.length()-1 && hm.size()<=k){
		        i++;
		        char ch = s.charAt(i);
		        hm.put(ch,hm.getOrDefault(ch,0)+1);
		        if(hm.size()<=k){
		            ans+=(i-j);
		        }
		    }
		    while(j<i && hm.size() > k){
		        j++;
		        char ch = s.charAt(j);
		        int nf = hm.get(ch)-1;
		        if(nf == 0){
		            hm.remove(ch);
		            ans+=(i-j);
		        }else{
		            hm.put(ch,nf);
		        }
		    }
		  
		}
		return ans;

	}
```
  
</p>
</details> 	
	
	
	
