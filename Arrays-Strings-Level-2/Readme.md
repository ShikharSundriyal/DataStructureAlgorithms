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

5. 11 Container With Most Water : Optimised approach in 0(n)
	- Brute Force : 0(n2)
		- start a for loop over the heights array, inside that start another for loop from i+1, check area and compare with maxarea
	- Optimised Approach : (Two pointer approach)
		- Thigs to observe is area = width * Minimum of height out of two pillars
		- when we select 0th pillar and last pillar , and find the area , then we discard the smaller wall either left or right for next iteration by moving i or j pointer. This works because if 0th height is less than other pairs that i can pair up with will have a width less than the original widht that we used as j was present at the last position and height will remain same or will decrease if we encounter a smaller height, so there is no way we will get larger area . So we discard the smaller wall
```java
 public int maxArea(int[] height) {
        int i =0,j=height.length-1,maxarea=0;
        
        while(i<j){
            int area = (j-i) * Math.min(height[i],height[j]);
            if(area > maxarea){
                maxarea = area;
            }
            
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxarea;
    }
```


6. 238 Product of Array Except Self :
	- We are given an sorted array we need to create a new array where ith idx contains multiplition of all values except idx , we cannot use division operator
	- If the Division operator constraint was not given then approavh would be , find the total multiplication of all the elements and at each idx divide the total nultiplication value by by current value 
	- Approach 1 : 
		- Create two arrays where 
			- array1 will store the prefix multiplication starting from 0th i i.e arr1[i] = arr1[i-1] multiplied by nums[i]
			- array2 will store the prefix multiplication starting from last index to 0 i.e arr2[i] = arr1[i+1] multiplied by nums[i] 
			- now multiplication at ith idx will be multiplication of all elements from 0 to i-1 multiplied by multiplication of all elements from i+1 to last idx
			- we have both the values stroed in arr1 and arrr2[]

```java
 public int[] productExceptSelf(int[] nums) {
        int[] p1 = new int[nums.length];
        int[] p2 =  new int[nums.length];
        int[] res =  new int[nums.length];
        p1[0] = nums[0];
        for(int i =1;i<nums.length;i++){
         p1[i] = p1[i-1]*nums[i]; 
        }
        p2[nums.length-1]=nums[nums.length-1];
        for(int i =nums.length-2;i>=0;i--){
            p2[i] = p2[i+1]*nums[i];
        }
        for(int i = 0;i<nums.length;i++){
            
            res[i] = (i-1>=0?p1[i-1]:1)*(i+1<nums.length?p2[i+1]:1);
        }
        return res;
    }
```


7. 11 Container With Most Water :
	- Given an array heights which contain the height of ith bar.
	- We need to find the the max area that can formed using two bars.
	- Approach 1 : Brute Force 0(n2)
		- iterate over each bar and try to find the suitable bar with iterating over the other bars and finding the maximum area
	- Approach 2 : 0(n) Two pointer approach
		-  Keep two pointers at 0 and end of the array 
		-  the area = height * width , where width = distance between two bars and height will be Minimum of height[i] and height[j]
		-  so the height is kind of constant when we from from left to right but the widht is increasing so we can say that we will get the best contender where widht is maximum. Hence we take two pointer approach
		-  while i < j iterate over the array
			-  area = minimum of heights of i and j * widht i.e. j-i
			-  whichever height is minimum we need not do any more comparisions for that bar as rest all areas will be less as width will decrease if we travel 
			-  so whichever height is minimum remove that, i.e. i++ or j--
```java
//Brute force
public static int mostWater(int[] heights) {
        // write your code here
        
        int area = Integer.MIN_VALUE;
        for(int i = 0;i<heights.length;i++){
            for(int j=i+1;j<heights.length;j++){
                int h = Math.min(heights[i],heights[j]);
                int w = j-i;
                if(h*w>area){
                    area = h*w;
                }
            }
        }
        return area;
    }


// Optimised
public int maxArea(int[] heights) {
        int i = 0,j=heights.length-1;
        int totalarea = Integer.MIN_VALUE;
        while(i<j){
            int area = Math.min(heights[i],heights[j])* (j-i);
            if(area > totalarea){
                totalarea = area;
            }
            
            if(heights[i]>heights[j]){
                j--;
            }else{
                i++;
            }
        }
        return totalarea;
    }
```

8. Majority Element 1 :
	- Given an array we need to find an element whose occurence is greater than array.length/2
	- In an array there will be atmost one manjority element as for an element to be majority element it has to come more than n/2 times.
	- Brute force : Time 0(N), Space 0(N)
		- Make a frequency hashmap for each element of the array
		- iterate over the hashmap and check whose key has value greater than arr.length/2 
	- Optimised Approach : Time 0(N), Space 0(1) We will use Moore's voting algorithm
		- We will try to find the element which has the most chances of becoming the Majority element i.e. we will count how many more times an element is coming as compared to other elements
		- maintain two variables count and val, initially val = arr[0] and count = 1
		- iterate over the array form 1 to arr.length
			- if arr[i] == val that means that element is coming again , so count++
			- else count-- which means a different elment came and we have to compensate the previous value now if after compensating say that count becomes zero then we have to give chance to the current new element that came 
			- i.e if count == 0 val arr[i] count =1
		- At the end we will have one contender, now we need to iterate over the entire array and find the frequency of that element and chaeck if its greater than arr.length/2
```java
public static void printMajorityElement(int[] arr) {
        // write your code here
        int val = arr[0];
        int count=1;
        for(int i = 1;i<arr.length;i++){
            if(arr[i]==val) count++;
            else{
                count--;
                if(count ==0){
                    count =1;
                    val = arr[i];
                }
            }
        }
        int c=0;
        for(int i:arr){
            if(i==val) c++;
        }
        if(c>arr.length/2){
            System.out.println(val);
        }else{
            System.out.println("No Majority Element exist");
        }
    }
```  	 	  


9. Majority Elements two :
	- Find the manjority element in an array where majority element is an element whose frequency is more than arr.length/3 
	- Here also Brute force will be 0(N) time and 0(N) space using a frequency map
	- Optimised Approach : Time 0(N) and space 0(1)
	- Incase of n/3 we can have atmost 2 elements as Majority elements
	- We will keep 2 variables , v1 = arr[0], c1 = 1, v2 = 0, c2 = 0
	- iterate over the array 
		- if arr[i] == val1 -> increase count of c1
		- else if arr[i] == val2 -> increase count of c2
		- else we need to compensate the values from both c1 and c2 but before that we need to check if c1 ==0 then v1 = arr[i] c1 = 1
```java
 public List<Integer> majorityElement(int[] nums) {
        int val1 = nums[0];
        int c1 = 1;
        int val2 = 0;
        int c2 = 0;
        
        for(int i =1;i<nums.length;i++){
            if(nums[i] == val1) c1++;
            else if(nums[i]==val2) c2++;
            else{
                if(c1 == 0){
                    c1 = 1;
                    val1=nums[i];
                }
                else if(c2 == 0){
                    c2=1;
                    val2=nums[i];
                }
                else{
                    c1--;
                    c2--;
                }
            }
        }
        int f1=0,f2=0;
        List<Integer> al = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == val1) f1++;
            else if(nums[i]==val2) f2++;
        }
        if(f1>nums.length/3) al.add(val1);
        if(f2>nums.length/3) al.add(val2);
        return al;
    }
```

10. Majority elements general :
	- Given an array , find a majority element where majority element is defined as , if frequency of element > arr.length/k
	- Use the brute force approach i.e. create a frequency hashmap 
