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
