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
        int res = 0,ps=arr[0];
        hm.put(0,-1);
        for(int i = 0;i<arr.length;i++){
            if(i==0){
                hm.put(arr[i],i);
            }else{
                ps = arr[i]+ps;
                if(hm.containsKey(ps)){
                    res = Math.max(res,i-hm.get(ps));
                }else{
                    hm.put(ps,i);    
                }
                
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
