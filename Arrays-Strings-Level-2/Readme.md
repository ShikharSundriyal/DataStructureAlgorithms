1. Long Pressed Name : Two pointer approach
  - We are given two string, we need to find if the typed string provided can be formed from original string
  - edge cases to keep in mind :
    - typed gets fully consumed and original still has elements return false
    - typed length is smaller than original string return false
  
```java
 public static boolean isLongPressedName(String name, String typed) {
 	 	 // Write your code here
 	 	 
 	 	 if(typed.length()<name.length() || typed.charAt(0) != name.charAt(0)) return false;
 	 	 int i = 1,j=1;
 	 	 while(j<typed.length() && i<name.length()){
 	 	     
 	 	     if(typed.charAt(j) == name.charAt(i)){
 	 	         i++;
 	 	         j++;
 	 	     }else if(typed.charAt(j) == typed.charAt(j-1)){
 	 	         j++;
 	 	     }else{
 	 	         return false;
 	 	     }
 	 	 }
 	 	 while(j!=typed.length()){
 	 	     if(typed.charAt(j) == typed.charAt(j-1))
 	 	        j++;
 	 	    else return false;
 	 	 }
 	 	 return i< name.length()?false:true;
 	 }
```

2. Range Addition :
  - Given an empty array of length n, and an 2d array containing k updates that need to be applied to the array
  - Approach 1 : T 0(kn)
    - Iterate over updates array , find the starting idx , ending idx and the update value
    - start a for loop from startidx to end idx and apply update
  - Approach 2 : T 0(n+k)  (Using prefix sum)
    - Iterate over the updates array , get the startidx, endidx and update value
    - put arr[startidx]+=update_value and arr[endidx+1]-=updatevalue
    - After all updates are done
    - Do a prefix sum on the array 
```java
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for(int i = 0;i<updates.length;i++){
            int si = updates[i][0];
            int ei = updates[i][1];
            int up = updates[i][2];
            arr[si]+=up;
            if(ei+1<arr.length)
                arr[ei+1]+=-up;    
        }
        
        
        for(int i = 1;i<arr.length;i++){
            arr[i] = arr[i] + arr[i-1];
        }
        return arr;
        
        
    }
```

3. Max Range Queries : (Uses range addition which uses prefix sum, count of k's till ith idx and count of k+1 till ith idx)
  - Given an array and certain queries and an integer k, we need to find out after we apply all the queries which query should we remove which will give us maximum count of K
  - First we need to calculate the range addition which is nothing but giving overall impact of all queries and then calculating prefix sum
  - Once we have the overall impact of all the queries we have two approach :
    - Approch 1 : 0(nk)
      - Iterate over the queries array and from si to ei reduce 1 and then count number of k's in array.   
    - Approach 2 : 0(k)
      - Make two arrays containing count of k's and count of k+1 till ith index using the final prefix sum array.
        - if finalarray[i] == k then countk[i]=countk[i-1]+1; 
      - Now iterate over queries array , calculate total k's if this query is removed then 
        - remaining k's formula = total k's - count of k's +count of k+1 as k+1 will become k
```java
public static void maxRangeQueries(int[] arr, int k, int[][] queries){
	
	int[] finarr = new int[arr.length];
	
	for(int i =0;i<queries.length;i++){
		int si = queries[i][0];
		int ei = queries[i][1];
		finarr[si]+=1;
		if(ei+1<arr.length)
			finarr[ei+1]-=1;
	}
	for(int i =1;i<arr.length;i++){
		finarr[i] = finarr[i-1]+finarr[i];
	}
	int total_k=0;
	for(int i:finarr){
		if(i==k) total_k++;
	}
	int[] countk = new int[arr.length];
	int[] countkp = new int[arr.length];
	if(finarr[0] == k ){
		countk[0] =1;
	}
	if(finarr[0] == k+1){
		countkp[0]=1;
	}
	for(int i =1;i<finarr.length;i++){
		if(finarr[i] == k){
			countk[i] = countk[i-1]+1;
		}
		if(finarr[i] ==k+1){
			countkp[i]=countkp[i-1]+1;
		}
	}
	int res = Integer.MIN_VALUE;
	for(int i =0;i<queries.length;i++){
		int si = queries[i][0];
		int ei = queries[i][1];
		int ck = countk[ei]-(si-1>=0?countk[si-1]:0);
		int ckp1 = countk[ei]-(si-1>=0?countk[si-1]:0);
		int total = total_k - (ck)+(ckp1);
		if(total>res) res = total;
	}
	
}
```

4. 977 Squares of a Sorted Array :
	- Given an sorted array containing both negative and positive elements. Return an sorted array containing the squares of the element.
	- Approach 1 : 0(nlogn) using sorting 
		- find squares of the array
		- sort the array and return
	- Approach 2 : 0(n)
		- Have two pointers i and j , one at 0th idx and j at last idx
		- while i<=j 
			- check which elements square value is more either i or j , if i put that square value to new array at kth index and increment i
			- if the jth square is more than put that square value to new array kth idx and then decrement j
			- finally decrement k
```java
public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int i = 0,j=nums.length-1,k=nums.length-1;
        while(i<=j){
            if(nums[i]*nums[i] <=nums[j]*nums[j]){
                arr[k]=nums[j]*nums[j];
                j--;
            }else{
                arr[k]=nums[i]*nums[i];
                i++;
            }
            k--;
        }
        return arr;
    }
```
