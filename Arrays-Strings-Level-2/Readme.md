1. Long Pressed Name : Two pointer approach
  - We are given two string, we need to find if the typed string provided can be formed from original string
  - edge cases to keep in mind :
    - typed gets fully consumed and original still has elements return false
    - typed length is smaller than original string return false

<details><summary>Code</summary>
<p>

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

</p>
</details>


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
<details><summary>Code</summary>
<p>

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
</p>
</details>

                     
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

<details><summary>Code</summary>
<p>

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

</p>
</details>


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
<details><summary>Code</summary>
<p>

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

</p>
</details>

5. 11 Container With Most Water : Optimised approach in 0(n)
    - Brute Force : 0(n2)
        - start a for loop over the heights array, inside that start another for loop from i+1, check area and compare with maxarea
    - Optimised Approach : (Two pointer approach)
        - Thigs to observe is area = width * Minimum of height out of two pillars
        - when we select 0th pillar and last pillar , and find the area , then we discard the smaller wall either left or right for next iteration by moving i or j pointer. This works because if 0th height is less than other pairs that i can pair up with will have a width less than the original widht that we used as j was present at the last position and height will remain same or will decrease if we encounter a smaller height, so there is no way we will get larger area . So we discard the smaller wall

<details><summary>Code</summary>
<p>

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

</p>
</details>



6. 238 Product of Array Except Self :
    - We are given an sorted array we need to create a new array where ith idx contains multiplition of all values except idx , we cannot use division operator
    - If the Division operator constraint was not given then approavh would be , find the total multiplication of all the elements and at each idx divide the total nultiplication value by by current value 
    - Approach 1 : 
        - Create two arrays where 
            - array1 will store the prefix multiplication starting from 0th i i.e arr1[i] = arr1[i-1] multiplied by nums[i]
            - array2 will store the prefix multiplication starting from last index to 0 i.e arr2[i] = arr1[i+1] multiplied by nums[i] 
            - now multiplication at ith idx will be multiplication of all elements from 0 to i-1 multiplied by multiplication of all elements from i+1 to last idx
            - we have both the values stroed in arr1 and arrr2[]

<details><summary>Code</summary>
<p>


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

</p>
</details>


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

<details><summary>Code</summary>
<p>

```java
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

</p>
</details>


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

<details><summary>Code</summary>
<p>

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

</p>
</details>

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

<details><summary>Code</summary>
<p>

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

</p>
</details>

10. Majority elements general :
    - Given an array , find a majority element where majority element is defined as , if frequency of element > arr.length/k
    - Use the brute force approach i.e. create a frequency hashmap 


11. Reverse Vowels of String :
    - Use a two pointer approach 
    - move i to appropriate position that is to a vowel 
    - move j to appropriate position that is to a vowel 

<details><summary>Code</summary>
<p>

```java
public boolean isvowel(char ch){
        String s = "aeiouAEIOU";
        return s.contains(ch+"");
    }
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0,j=s.length()-1;
        while(i<j){
            while(i<j && isvowel(arr[i]) == false){
                i++;
            }
            while(i<j && isvowel(arr[j]) == false){
                j--;
            }
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
        return String.valueOf(arr);
    }
```

</p>
</details>

12. Complex Number Multiplication :
    - given num1 and num2 as String 
    - num1 = "a+bi", num2 = "c+di"
    - real part afternultiply will be : a*c - b*d
    - imaginary part will be : a * d + b * c 
    - return real + "+" + imaginary + "i";

<details><summary>Code</summary>
<p>

```java
 public String complexNumberMultiply(String num1, String num2) {
        int a = Integer.parseInt(num1.split("\\+")[0]);
        int b = Integer.parseInt(num1.split("\\+")[1].split("i")[0]);
        int c = Integer.parseInt(num2.split("\\+")[0]);
        int d = Integer.parseInt(num2.split("\\+")[1].split("i")[0]);
        int real =a*c-b*d;
        int ima = a*d+b*c;
        
            return real+"+"+ima+"i";
        
        
    }
```

</p>
</details>

13. First Missing positive integer : 
    - Brute Force 0(nlogn)
        - Sort the array 
        - now iterate over the array and find the mmissing number
    - Optimised : T 0(n) , S 0(1)
        - The approach should be , partition the array move all 0 and -ve elements to the right of the array
        - Now we know the start and end index of the positive integers
        - Now start marking the indexes with negative sign which will indicate that idx+1 postive number is present in the array
        - -ve sign at 0th idx indicate that 1 is present, -ve at 1st idx represent 2 is present
        - we will mark the indexes -ve where arr[i] is within the positive index range and arr[i] is positive because there can be a case of duplicates
        - Now we will iterate over the array from 0 to positive index range and see which index has positive value , the idx which has +ve value means i+1 positive interger is missing from array
        - if all the index are negative that means last idx of positive range + 2 , integer is missing.

<details><summary>Code</summary>
<p>

```java
 public static int firstMissingPositive(int[] arr) {
    // write your code here
    int i =-1,j=0;
    // partition an array move all 0 and negative elements to the right
    while(j<arr.length){
        if(arr[j]<=0){
            j++;
        }else{
            i++;
            int t = arr[i];
            arr[i]=arr[j];
            arr[j]=t;
            j++;
        }
    }
    
    for(int m = 0; m<=i;m++){
        
        int val = Math.abs(arr[m]);
        if(val-1 <=i && arr[val-1]>0){
            arr[val-1]=-arr[val-1];
        }
    }
    
    for(int m = 0;m<=i;m++){
        if(arr[m]>0){
            return m+1;
        }
    }
    return i+2;
  }
```

</p>
</details>



14. Max Product Of Three Numbers :
    - Given an array of both positive and negative integers find the product of 3 numbers such that the product is largest
    - Approach 1 :  Brute Force Sort the array 0(Nlogn)
        - Sort the array 
        - now the max product can be formed by last 3 elements of the array if all the vlaues in array are positive
        - the 2 negative values with max magnitude and largest positive number can also give max product as two negatives will make one positive
        - Compare these two factors which ever is maximum is answer
    - Approach 2 : Optimised 0(N) Single pass
        - Now we know we just need 2 least numbers and 3 max numbers which we can maintain while we traversse the array
        - and then compare factor 1 and factor2 as approach 1 and get the answer

<details><summary>Code</summary>
<p>


```java
    public int maximumProductBruteForce(int[] nums) {
        Arrays.sort(nums);
        int f1 = nums[0]*nums[1]*nums[nums.length-1];
        int f2 = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        return Math.max(f1,f2);
    }
     public int maximumProduct(int[] nums) {
         int min1=Integer.MAX_VALUE;
         int min2 = Integer.MAX_VALUE;
         int max1=Integer.MIN_VALUE;
         int max2=Integer.MIN_VALUE;
         int max3=Integer.MIN_VALUE;
         for(int i = 0;i<nums.length;i++){
             if(nums[i]>max1 ){
                 max3 = max2;
                 max2 = max1;
                 max1 = nums[i];
             }else if(nums[i] > max2){
                 max3 = max2;
                 max2 = nums[i];
             }else if(nums[i]>max3){
                 max3 = nums[i];
             }
             
             if(nums[i] < min1){
                 min2 = min1;
                 min1 = nums[i];
             }else if(nums[i]<min2){
                 min2 = nums[i];
             }
         }
         int f1 = min1*min2*max1;
         int f2= max1*max2*max3;
         return Math.max(f1,f2);
         }
}
```
</p>
</details>



15. 769 Max Chunks To Make Sorted :
    - Given an array where elements are strictly between [0 to n-1]
    - We will maintain a variable MaxRange that is nothing but will help us in determining which all elements can be grouped together
    - iterate over the array
        - maxRange = Math.max(maxRange,arr[i]) -> that is the current element can go to max which position
        - if maxRange == i chunk++;  -> this means that we have got our chunk, as all elements till i will move within maxRange and take correct position as per result sorted array . This is working because we actually know that all elements are between 0 to n-1

<details><summary>Code</summary>
<p>

```java
public int maxChunksToSorted(int[] arr) {
        int maxRange = Integer.MIN_VALUE,chunks=0;
        for(int i =0;i<arr.length;i++){
            maxRange = Math.max(maxRange,arr[i]);
            if(maxRange == i) chunks++;
        }
        return chunks;
    }
```

</p>
</details>


16. Max Chunks to make array sorted 2 : 
    - Given an array where there is no restrictions on the values of the array . Find the max chunks in which the array can be divided such that if chunks sorted individually form a overall sorted array
    - Time 0(N), Space 0(N)
    - Approach :
        - Inorder to make a chunk it must follow : max of all elements from left should be lesser than min of all the elements on the right because in an sorted array it follows the same
        - Create two arrays, 
            - arr1 which stores max of prefix elements i.e from 0 to i , arr1[i] will store max element exconutered till ith idx
            - arr2 which stores min of suffix i.e. from arr.length-1 to i , arr2[i] will store the min element encountered till ith idx from behind
        - iterate over the array and see where arr1[i] < arr2[i+1] chunks++

<details><summary>Code</summary>
<p>


```java
 public static int maxChunksToSorted2(int[] arr) {
        // write your code here
        int[] pre= new int[arr.length];
        int[] suf= new int[arr.length+1];
        suf[suf.length-1]=Integer.MAX_VALUE;
        int chunks=0;
        pre[0]=arr[0];
        for(int i = 1;i<arr.length;i++){
            pre[i] = Math.max(arr[i],pre[i-1]);
        }
        
        for(int i = arr.length-1;i>=0;i--){
            suf[i] = Math.min(suf[i+1],arr[i]);
        }
        
        for(int i = 0;i<arr.length;i++){
            if(pre[i]<=suf[i+1]) chunks++;
        }
        return chunks;
    }
```

</p>
</details>


17. Partition Array into Disjoint Intervals
    - Given an integer array nums, partition it into two (contiguous) subarrays left and right so that:
        - Every element in left is less than or equal to every element in right.
        - left and right are non-empty.
        - left has the smallest possible size.
    - Approach 0 :  Brute Force 0(n2)
        - start from left hand side of array , maintain max and from i+1 to arr.length check if arr[j] < max which means partition will happen at that jth idx.  
    - Approach 1 : Time 0(N), Space 0(N) 
        - very similar to the divide array into chunks , here we just need to return the first chunk length
    - Approach 2 : Time 0(N), Space 0(1)
        - Make an array and see at each index till where it is going till max 
        - We will maintain 3 variables , potential answer, maxtilli, maxtillpotentialanswer
        - we can divide an array into chunks 
            - when arr[i] <  maxtillpotentialanswer  this means that arr[i] wants to merge with the left hand side which means our previous potential answer was wrong so we update the potentialanswer = i and maxttillpotentialanswer = maxtilli as maxtilli will be the max till potential answer as we have updated potential answer
            - in other case if arr[i] > maxtilli just update maxtilli because here we cannot partition the array as this element will come into a single partition

<details><summary>Code</summary>
<p>


```java
// brute force 
0(N2)
 public int partitionDisjoint(int[] arr) {
        int maxelement = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {   boolean flag = true;
            maxelement = Math.max(maxelement,arr[i]);
            for(int j = i+1;j<arr.length;j++){
                if(maxelement > arr[j]){
                    flag = false;
                    break;
                }
            }
            if(flag) return i+1;
        }
        return -1;
    }

// 0(N) , with 0(N) space
public int partitionDisjoint1(int[] arr) {
        int[] pre= new int[arr.length];
    int[] suf = new int[arr.length+1];
    pre[0] = arr[0];
    for(int i = 1;i<arr.length;i++){
        pre[i] = Math.max(pre[i-1],arr[i]);
    }
    suf[suf.length-1] = Integer.MAX_VALUE;
    for(int i = arr.length-1;i>=0;i--){
        suf[i] = Math.min(suf[i+1],arr[i]);
    }
    for(int i =0;i<arr.length;i++){
        if(pre[i]<=suf[i+1]) return i+1;
    }
    return -1;
    }
    // Optimised 0(N) with 0(1) space
    public int partitionDisjoint(int[] arr) {
        int max = arr[0];
        int potentialAnswerMax = arr[0];
        int potentialAnswer = 0;
        
        for(int i =1;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }else if(arr[i] < potentialAnswerMax){
                potentialAnswer = i;
                potentialAnswerMax = max;
            }
        }
        return potentialAnswer+1;
    }
``` 

</p>
</details>


18. 2 Sum Target Sum Unique pairs :
    - Given an array and a target find the unique pairs which can form a target
    - brute force Approach : 0(n2)
        - start a for loop from 0 to arr.length-2
        - Start another for loop inside above for loop , from j=i to arr.length
            - check if arr[i]+arr[j] == target then we have a pair but this way still we will have duplicate pairs 
            - example 10 10 20 20 , target = 30
            - as per brute force we will get 10,20 , 10,20 in first iteration , in second iteration again we will get 10,20 10,20
            - so as a quick fix we can store the result in a hashset or hashmap
    - Optimised Approach : T (nlogn)
        - sort the array and apply two pointer approach
        - keep i = 0, j=arr.length-1
        - now while i<j
            - if i!=0 && arr[i]==arr[i-1] i++; continue; this condition is to handle the duplicates
            - if (arr[i] + arr[j] == target) store that pair and i++, j--;
            - if arr[i] + arr[j] < target i++;
            - else j--
    - Approach 3 : Time 0(n), space 0(N)
        - using a hashmap , storing each element along with its frequency in hashmap 
        - here also we need to see how we can remove duplicate pairs

<details><summary>Code</summary>
<p>


```java
public static List<List<Integer>> twoSum(int[] arr, int target) {
    // write your code here
    /* 0n2 approach but it will also give duplicate pairs
    for(int i =0;i<arr.length;i++){
        for(int j = i+1;j<arr.length;j++){
            if(arr[i] + arr[j] == target){
                System.out.println(arr[i]+" "+arr[j]);
            }
        }
    }
    */
    // 0(NlogN) sort the array, two pointer appraoch without duplicates
    Arrays.sort(arr); 
    int i =0,j=arr.length-1;
    List<List<Integer>> res = new ArrayList<>();
    while(i<j){
        if(i!=0 && arr[i]==arr[i-1]){
            i++;
            continue;
        }
        if(arr[i] + arr[j] == target){
            List<Integer> al = new ArrayList<>();
            al.add(arr[i]);
            al.add(arr[j]);
            i++;
            j--;
            res.add(al);
        }else if(arr[i]+arr[j] < target){
            i++;
        }else{
            j--;
        }
    }
    return res;
  }
```

</p>
</details>


19. 3 Sum Target Sum Unique triplets : 
    - Given an array find the triplets whose sum is equal to given target
    - Here we will follow the same logic as 2 sum target Time complexity 0(n3)
    - we will iterate over each element of the array and call 2 sum target , where target will become target-arr[i] which means 2 sum function will give us a list of pairs whose sum is equal to target - arr[i] and if we add arr[i] to those pairs than the sum of those triplets will become equal to target. 

<details><summary>Code</summary>
<p>

```java
 public List<List<Integer>> twosum(int[] arr,int target,int si){
        List<List<Integer>> res = new ArrayList<>();
        int i =si,j=arr.length-1;
        while(i<j){
            if(i!=si&& arr[i]==arr[i-1]){
                i++;
                continue;
            }
            if(arr[i]+arr[j]==target){
                List<Integer> al = new ArrayList<>();
                al.add(arr[i]);
                al.add(arr[j]);
                res.add(al);
                i++;
                j--;
            }else if(arr[i]+arr[j] > target){
                j--;
            }else{
                i++;
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0;i<arr.length;i++){
            if(i!=0 && arr[i]==arr[i-1]) continue;
            List<List<Integer>> al = twosum(arr,-arr[i],i+1);
            for(List<Integer> l:al){
                l.add(arr[i]);
                res.add(l);
            }
        }
        return res;
    }
```

</p>
</details>


20. 4Sum
    - Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
    - nums[a] + nums[b] + nums[c] + nums[d] == target
    - Approach 1 : 0(n3)
        - here we will use three sum function which we have written earlier which internally calls 2 sum
        - for each index of i we will call 3sum to find triplets from i+1 idx whose sum is equal to target - arr[i] 
        - then once we have those triplets we can add arr[i] and we will get quadruplets whose sum is equal to target
    - Approach 2 : 
        - This is a more general approach where we can will use recursion 
        - faith : for ith idx we have all the triplets whose sum is = target-arr[i]  
        - from faith to expectation : we will add arr[i] to triplets list to get quadruplets 
        - as we need to find triplets whose sum is equal to targer-arr[i] for all index of array we will need a for loop, to handle duplicates we will make sure we sort the array and check if arr[i]==arr[i-1]
        - base case : the abse case will be twosum that is when k = 2 call twosum method
<details><summary>Code</summary>
<p>

```java
// Approch 1
 public static List<List<Integer>> twosum(int[] arr, int target, int si){
        List<List<Integer>> res = new ArrayList<>();
        int i = si;
        int j = arr.length-1;
        while(i<j){
            if(i!=si && arr[i]==arr[i-1]){
                i++;
                continue;
            }
            if(arr[i]+arr[j]== target){
                List<Integer> al = new ArrayList<>();
                al.add(arr[i]);
                al.add(arr[j]);
                res.add(al);
                i++;
                j--;
            }else if(arr[i]+arr[j] < target){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
     public static List<List<Integer>> helper(int[] arr, int target, int k, int si){
       if(k==2){
         List<List<Integer>> base = twosum(arr,target,si);
         return base;
    }
    List<List<Integer>> res = new ArrayList<>();
    for(int i = si;i<arr.length-k+1;i++){
        if(i!=si && arr[i]==arr[i-1]) continue;
        List<List<Integer>> a = helper(arr,target-arr[i],k-1,i+1); // get pairs who have k-1 pairs and target = target - arr[i]
        for(List<Integer> l:a){
            l.add(arr[i]);
            res.add(l);
        }
    }
    return res;
  }

  public static List<List<Integer>> kSum(int[] arr, int target, int k) {
    // write your code here
    Arrays.sort(arr);
    return helper(arr,target,k,0);
   
  }
  // Approach 2 
   public List<List<Integer>> twosum(int[] arr,int target,int si){
        List<List<Integer>> res = new ArrayList<>();
        int i = si,j=arr.length-1;
        while(i<j){
            if(i!=si && arr[i]==arr[i-1]){
                i++;
                continue;
            }
            if(arr[i]+arr[j]==target){
                List<Integer> al = new ArrayList<>();
                al.add(arr[i]);
                al.add(arr[j]);
                res.add(al);
                i++;
                j--;
            }else if (arr[i]+arr[j]<target){
                i++;
            }else{
                j--;
            }
        }
        // System.out.println(res);
        return res;
    }
    public List<List<Integer>> helper(int[] nums, int target, int si,int k){
        if(k == 2){
            return twosum(nums,target,si);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = si;i<nums.length-k+1;i++){
            if(i!=si && nums[i]==nums[i-1]) continue;
            List<List<Integer>> a = helper(nums,target-nums[i],i+1,k-1);
            for(List<Integer> al:a){
                al.add(nums[i]);
                res.add(al);
            }
        }
        return res;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return helper(nums,target,0,4);
        
        
    }
```

</p>
</details>

    
21. Pascals Triangle 2 (Leetcode):
    - Given a row print the required
    - If row 0 -> 1
    - If row 1 -> 1 1
    - If row 2 -> 1 2 1
    - If row 3 -> 1 3 3 1
    - If row 4 -> 1 4 6 4 1
    - approach 1 : Optimised 
        - If we look at the pattern it is nc0+nc1+nc2+.....+ncn
        - nco is always 1, and we can calculate ncr+1 from ncr using , ncr+1=ncr * (n-r)/(r+1)

<details><summary>Code</summary>
<p>

```java
  public static ArrayList<Integer> pascalRow(int r) {
    // write your code here
    ArrayList<Integer> al = new ArrayList<>();
    al.add(1);
    int ncr=1;
    for(int i = 0;i<r;i++){
        int ncr1 = (ncr * (r-i)/(i+1));
        al.add(ncr1);
        ncr=ncr1;
    }
    return al;
  }
```
    
</p>
</details>


22. Pascals Triangle 1 : 
  - Given a row index return a list of all rows till that row index, 
  - Same logic of ncr+1 = ncr* (n-r) / (r+1) , additionaly change is we need to treat rowindex from 0 to row_index so that we get all rows

<details><summary>Code</summary>
<p>

```java
public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<numRows;i++){
            List<Integer> al = new ArrayList<>();
            al.add(1);
            int ncr = 1;
            for(int j = 0;j<i;j++){
                int ncr1 = ncr*(i-j)/(j+1);
                al.add(ncr1);
                ncr = ncr1;
            }
            res.add(al);
        }
        return res;
    }
```
                                                     
</p>
</details>
  
23. Seive : 
  - Print all the prime numbers between 2 to b, b inclusive
  - Approach 1 : T(n root n)
    - Iterate from 2 to b and for each number check if its a prime number
  - Approach2 : 
    - create an boolean array of size b+1
    - iterate from 2 to root b
    - start a for loop and mark each factor of i except first factor as false as it cannot be prime
    - iterate over the array and check which idx have value as true , whichever is true add them to a list those are prime numbers from 2 to b

<details><summary>Code</summary>
<p>
  
```java
public static void printPrimeUsingSieve(int n) {
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);

        for (int k = 2; k * k <= n; k++) {
            if (arr[k] == true) {
                for (int i = 2 * k; i <= n; i += k) {
                    arr[i] = false;
                }
            }
        }


        for (int i = 2; i <= n; i++) {
            if (arr[i] == true) {
                System.out.print(i + " ");
            }
        }
    }
```
                              
</p>
</details>
  

24. Segmented Sieve :
  - Find all the prime numbers from a to b, both a and b inclusive
  - Approach 1 : 
    - Travel from a to b and check which all numbers are prime
  - Approach 2 :
    - Create an boolean array of length b-a+1 size
    - get all the primes from 2 to root b using seive algo 
    - Iterate over the list of primes 
      - find the multiplying factor i.e ceil of a/prime[i] 
      - if mf == 1 that means that prime itself is present in the array so we have to ignore that by making mf++;
      - if mf!=1 then the first multiple of that prime will be at idx = mf*prime[i] - a, this idx is the starting point wher the first multiple of that prime number is prensent and needs to be marked as not prime
    - Now when travlling over the boolean array check which all index are still true , if true then a+i is prime condition being i+a > 1
  
  
<details><summary>Code</summary>
<p>
  
```java
  public static ArrayList<Integer> seive(int a){
      boolean[] arr = new boolean[a+1];
      Arrays.fill(arr,true);
      for(int i =2;i*i<= a;i++){
          
          for(int j = 2*i;j<=a;j+=i){
              arr[j]=false;
          }
      }
      ArrayList<Integer> al = new ArrayList<>();
      for(int i =2;i<arr.length;i++){
          if(arr[i]==true){
              al.add(i);
          }
      }
      return al;
  }

  public static void segmentedSieveAlgo(int a, int b) {
    // write your code here
    
    int n = b-a+1;
    boolean[] arr = new boolean[n];
    Arrays.fill(arr,true);
    int modb = (int)Math.sqrt(b);
    ArrayList<Integer> primesal = seive(modb);
    // rather than math.sqrt we will iterate over only primes which we will get through sieve
    for(int i:primesal){
        int closest_factor = (int)Math.ceil(((a*1.0)/i));
        if(closest_factor == 1){ closest_factor++;}
        int idx = closest_factor*i -a; // finding the index of first factor in array
        for(int j = idx;j<arr.length;j+=i){
            arr[j]=false;
        }
    }
    int count =0;
    for(int i =0;i<arr.length;i++){
        // this i+a>1 is required becasue the primes always start from 2
        if(arr[i]==true && i+a>1) System.out.println(i+a); 
    }
    // return count;
  }
  
```
  
</p>
</details>
  
 
25. 290 Word Pattern (Leetcode) :
  - Given a pattern and a string s, find if s follows the same pattern.
  - Input: pattern = "abba", s = "dog cat cat dog" Output: true
  - Input: pattern = "abba", s = "dog cat cat fish" Output: false
  - Approach 1 : Using 2 HashMaps Time o(n) where n is the size of the pattern , space 0(M) where M . after splitting s length of array
  - Here initial thought that comes to out mind is to create a single hashmap and store pattern[i]->s[i] as pair , and then travel over pattern and see whatever we have in hashmap is inline with the current pattern . But here one test case will fail i.e. 
    - Pattern : "abba" , s = "dog dog dog dog" here in hashmap both a and b will have dog as value when we travel over pattern and s it wont throw an error but it should
  - To overcome this we create two hashmap which contains , s[i]->pattern[i] and pattern[i]->s[i]
  - iterate over the pattern and string 
    - If the hashmap1 does not contain the pattern key 'a' 
      - then check if hm2 contains the string key 'dog' if it contains that means dog is mapped to a different pattern alphabet which is wrong return false 
      - else hm2 also does not contain dog then add make entry to both hm1 and hm2
    - If the hasmap1 already contains the pattern key i.e. 'a' then
      - the value from hm1 'a' should be equal to the value we have when iterating over the string array if not then return false
  

<details><summary>Code</summary>
<p>
  
```java

public boolean wordPattern(String pattern, String s) {
       
        String[] arr = s.split(" ");
        if(arr.length != pattern.length()) return false;
        HashMap<Character,String> hm1= new HashMap<>();
        HashMap<String,Character> hm2= new HashMap<>();
        
        for(int i = 0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            String val = arr[i];
            if(!hm1.containsKey(ch)){
                if(hm2.containsKey(val)){
                    return false;
                }else{
                hm1.put(ch,val);
                hm2.put(val,ch);
                }
            }else{
                String value = hm1.get(ch);
                if(!value.equals(val)) return false;
            }
            }
        
        return true;
    }
  
```
</p>
</details>
  
26. 605 Can Place Flowers :
  - Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
  - Approach 1 : 0(N)
    - iterate over the array 
    - if index == 0 check only i+1 
    - if index == arr.length-1 then check only i-1
    - else check i+1 and i-1 at both index it should be 0.
 
  
<details><summary>Code</summary>
<p>
  
```java
 public boolean canPlaceFlowers(int[] arr, int n) {
        if(n == 0 ) return true;
        if(arr.length == 1) {
            if(arr[0]==0) return true;
            else return false;
        }
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==0){
                if(i == 0  ){
                    if(arr[i+1]==0){
                        arr[i]=1;
                        n--;
                    }
                }else if(i == arr.length-1){
                    if(arr[i-1]==0){
                        arr[i]=1;
                        n--;
                    }
                }
                else{
                    if(arr[i-1]==0 && arr[i+1]==0){
                        arr[i]=1;
                        n--;
                    }
                }
            }
            if(n==0) return true;
        }
        return false;
    }
  
  
```
  
</p>
</details>

  
27. 268 Missing Number (Leetcode):
  - Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
  - Approach 1 : 0(N) , O(1)
    - Create an boolean array and iterate over orignal array mark all the index which are coming as element in arr.
    - Then iterate over the array and see which idx is false that is the missing number
  - Approach 2 : 0(N) , O(1)
    - use sum of first n numbers formula , subtract the sum of array from the sum of n number that will be the answer.
  
  
<details><summary>Code</summary>
<p>
  
```java
  
public int missingNumber1(int[] nums) {
        boolean[] arr = new boolean[nums.length+1];
        
        for(int i:nums){
            arr[i] = true;
        }
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == false) return i;
        }
        return arr.length;
    }
     public int missingNumber(int[] arr) {
        int n = arr.length;
        int s = (n*(n+1) )/2;
        for(int i:arr){
            s= s-i;
        } 
        return s;
    }
  
```
  
</p>
</details>

  
28. 56 Merge Intervals :
  - Given a list of intervals , return a list of overlapping intervals
  - [[1,3],[2,6],[8,10],[15,18]] output -> [[1,6],[8,10],[15,18]]
  - Sort the given array based on the starting index
  - then add the first interval to an arraylist of 2d integers
  - Now iterate over the remianing intervals and check if the current interval's starting point is less than or equal to the arraylist's last intervals ending idx, if yes change the ending idx of arraylist to Math.max(endingidxof arraylist, endingidx of interval over where we are iterating)
  
  
<details><summary>Code</summary>
<p>
  
```java
  
public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals,(a,b)->{
           return a[0]-b[0]; 
        });
        ArrayList<int[][]> al = new ArrayList<>();
        int[][] smallInterval1 = new int[1][2];
        smallInterval1[0][0] = intervals[0][0];
        smallInterval1[0][1] = intervals[0][1];
        al.add(smallInterval1);
        // al.add(intervals[0]);
        // System.out.println(al);
        for(int i = 1;i<intervals.length;i++){
            int startingIdx = intervals[i][0];
            int endingIdx = intervals[i][1];
            if(startingIdx <= al.get(al.size()-1)[0][1]){
                int[][] pair = al.get(al.size()-1);
                int newEndingIdx = Math.max(endingIdx,al.get(al.size()-1)[0][1]);
                pair[0][1] = newEndingIdx;
            }else{
                int[][] smallInterval = new int[1][2];
                smallInterval[0][0] = startingIdx;
                smallInterval[0][1] = endingIdx;
                al.add(smallInterval);
            }
        }
        int[][] res = new int[al.size()][2];
        for(int i = 0;i<res.length;i++){
            int[][] mergedInterval = al.get(i);
            res[i][0] = mergedInterval[0][0];
            res[i][1] = mergedInterval[0][1];
        }
        return res;
    }
  
```
  
</p>
</details>
  

29 . Minimum number of platforms required : 
  - Given two arrays containing arrival and departure times of the trains find the minimum number of platforms required to accomodate the train schedule
  - Approach 1 : 0(NlogN) 
    - Sort both arrival and departure array , now keep i = 1 which will iterate over arrivals array and j=0 which will iterate over the departures array
    - We will need a new platform if the the arrival time of current train is less than the departure time of a train .
    - Incase the arrival time of current train is greater than the departure time of train then number of platform required will be one less
    - Here we are only interested to know at a particular time how many trains are coming in parallel those many minimum number of platforms will be required.
    - Here we can think of as how many max trains are coming at a particular time instance for example
        - train1 comes at 7 goes at 11 -> maxtrains at 7 o clock is 1 
        - train2 comes at 8 goes at 1 -> maxtrains at 8 0 clock is 2 as 7 0 clock hasnt left yet
        - train3 comes at 9 goes as 1:20 -> maxtrains at 9 o clock is 3 as nor train1 nor train2 have left
        - train4 comes at 12 goes at 1:30 -> maxtrains at 12 is 3-1 as train1 has left (train 4 coming will be taken care in next iteration where arrival[i] will become greater than departure of j which means another train has come)

<details><summary>Code</summary>
<p>
  
```java
  
static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        int maxTrains = 1,maxPlatform=0;
    Arrays.sort(arr);
    Arrays.sort(dep);
    int i = 1,j=0;
    while(i<arr.length && j<dep.length){
        
        if(arr[i]<=dep[j]){
            maxTrains++;
            i++;
        }else{
            j++;
            maxTrains--;
        }
        if(maxTrains<platform) maxPlatform = maxTrains;
    }
    return maxPlatform;
        
    }
  

```  
  
</p>
</details>
  
  
30. Meeting Rooms I :
  - Given an array containing the start time and end time of the meetings find if a person can attend all the meetings
  - Approach 1 : 0(NlogN)
    - sort the given intervals array based on the start time of the meeting 
    - then travel over the intervals array and check if startidx of i is less than the end interval of the i-1 then return false

  
<details><summary>Code</summary>
<p>
  
  
```java
 public static boolean meetingRooms(int intervals[][]){
        // write code here
        Arrays.sort(intervals, (a,b)->{
           return a[0]-b[0]; 
        });
        
        for(int i = 1;i<intervals.length;i++){
            int endidx = intervals[i-1][1];
            int startidx = intervals[i][0];
            if(startidx<endidx) return false;
        }
        return true;
    }
  
  
```
  
</p>
</details>

31. 253 Meeting Rooms II :
  - Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
  - Same approach as minimum number of plarforms.
  - Just convert the 2d array into teo different array which correspond to start time and end time 
  
<details><summary>Code</summary>
<p>

```java
  public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0;i<intervals.length;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int  i = 0, j = 0, minrooms = Integer.MIN_VALUE, rooms = 0;
        while(i<start.length && j<end.length){
            if(start[i]<end[j]){
                rooms++;
                i++;
            }else{
                rooms--;
                j++;
            }
            minrooms = Math.max(rooms,minrooms);
        }
        return minrooms;
    }
  
```

</p>
</details>

  
32. 986 Interval List Intersections :
  - You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
  - Return the intersection of these two interval lists.
  - Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]] 
  - Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
  - Approach 1 : 0(N) as the intervals are already sorted
    - Take 2 pointers , i and j. Keep i at 0 and j = 0
    - the intersection Interval will be , startidx = Math.max(firstList start idx , secondList startIdx) and endidx = Math.min(firstList end idx, secondList endidx) ( this will be valid only if startidx <= endidx )
  - whosesoever end idx is smaller that list's pointer needs to be increased , if both list's endInterval are same increase both pointers

<details><summary>Code</summary>
<p>

```java
  
public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[][]> al = new ArrayList<>();
        int i = 0,j=0;
        while(i<firstList.length && j<secondList.length){
            int s1 = firstList[i][0];
            int e1 = firstList[i][1];
            int s2 = secondList[j][0];
            int e2 = secondList[j][1];
            int commonstart = Math.max(s1,s2);
            int commonend = Math.min(e1,e2);
            if(commonstart<=commonend){
                int[][] a = new int[1][2];
                a[0][0] = commonstart;
                a[0][1] = commonend;
                al.add(a);
            }
            if(e1<e2){
                i++;
            }else if(e1>e2){
                j++;
            }else{
                i++;
                j++;
            }   
        }
        int[][] fres = new int[al.size()][2];
        int k = 0;
        for(int[][] arr:al){
            fres[k][0] = arr[0][0];
            fres[k][1]=arr[0][1];
            k++;
        }
        return fres;
    }
  
```
  
</p>
</details>
  

33. 680 Valid Palindrome II :
  - Given a string s, return true if the s can be palindrome after deleting at most one character from it.
  - Approach 1 : 0(N) two pointer approach
    - travel over the string, wherever we find two character from front and end are not equal , check if we remove the ith or jth character and after that the remaining string is palindrone or not.
  
<details><summary>Code</summary>
<p>

```java
 public static boolean isPali(String str, int s, int e){
    while(s<e){
        if(str.charAt(s)==str.charAt(e)){
            s++;
            e--;
        }else{
            return false;
        }
    }
    return true;
}
  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
  public static boolean validPalindrome(String s) {
    // write your code here
    int i = 0,j=s.length()-1;
    while(i<j){
        if(s.charAt(i) != s.charAt(j)){
            boolean res1 = isPali(s,i+1,j);
            if(res1) return true;
            boolean res2 = isPali(s,i,j-1);
            if(res2) return true;
            return false;
        }else{
            i++;
            j--;
        }
    }
    return true;
    
  } 
  
```
  
</p>
</details>

  
34. Car Pooling : 
  - Given an input [passenger, startlocation, drop location] in an list and a capaity of the cab find if the cab can complete the trip without overloading the cab.
  - If we look at the input the input of intervals is very similar to range addition , here we will put the overall affect of all the passenger 
  - the array we will create of size of maxlength of the destinaton from all the intervals i.e. the maximum distance the cab has to go .
  - this way we can will have at each location what was the capacity of the cab and if it increases from capacity we return false

<details><summary>Code</summary>
<p>
  
```java
  
  public boolean carPooling(int[][] trips, int capacity) {
        int maxL = 0;
        for(int i =0;i<trips.length;i++){
            if(trips[i][2]>maxL){
                maxL = trips[i][2];
            }
        }
        
        int[] arr = new int[maxL+1];
        for(int i =0;i<trips.length;i++){
            int start = trips[i][1];
            int end = trips[i][2];
            int passenger = trips[i][0];
            arr[start]+=passenger;
            arr[end]-=passenger;
        }
        if(arr[0]>capacity) return false;
        for(int i = 1;i<arr.length;i++){
            arr[i] = arr[i]+arr[i-1];
            if(arr[i] > capacity) return false;
        }
        return true;
    }
  
```
  
  
</p>
</details>

35. 556 Next Greater Element III :
  - Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
  - Approach 1 :
    - Take a pointer i and eep ar end of the string, and traverse and find the first dip i.e. where str.charAt(i)>str.charAt(i-1)
    - reverse the string from , ith position to str.length()
    - k = i-1 , now travel from ith idx and find an element whose just greater than str.charAt(k) , swap that element with str.charAt(k)

  
<details><summary>Code</summary>
<p> 
  
  
```java
  
public int nextGreaterElement(int n) {
        String str = n+"";
        StringBuilder sb = new StringBuilder(str);
        int i = sb.length()-1;
        boolean flg = false;
        while(i>0){
            //first dip idx
            if(sb.charAt(i)>sb.charAt(i-1)){
                flg = true;
                break;
            }
            i--;
        }
        if(flg == false){
            return -1;
        }else{
            reverse(sb,i,sb.length()-1);
            int k = i-1;
            // System.out.println(k);
            while(i<sb.length()){
                if(sb.charAt(i)>sb.charAt(k)){
                    // System.out.println("swap");
                    char tmp = sb.charAt(i);
                    sb.setCharAt(i,sb.charAt(k));
                    sb.setCharAt(k,tmp);
                    break;
                }
                i++;
            }
            Long res = Long.parseLong(sb.toString());
            if(res>Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return -1;
            }else{
                return Integer.parseInt(sb.toString());
            }
        }
        
    }
    public void reverse(StringBuilder sb, int si, int end){
        while(si<end){
            char tmp = sb.charAt(si);
            sb.setCharAt(si,sb.charAt(end));
            sb.setCharAt(end,tmp);
            si++;
            end--;
        }
    }  
  
```
  
</p>
</details>

  
36. 280 Wiggle Sort :
  - Given an integer array nums, reorder it such that nums[0] <= nums[1] >= nums[2] <= nums[3] >=
  - Approach 1 : Time 0(n), Space 0(1)
    - if we look at the order mentioned , the elements at the odd index follow a property i.e. they are larger than left and right element and similarly the even indexes follow that they are smaller than both right and left element
    - we will use the same insight and travel over the array if idx is even we will check if it is larger than i+1 element if yes we perform a swap, similarly for odd idx
    - we need not compare with the i-1th idx because while moving from left to right we would have already satisfied the first condition that is either a <= b in case of and in next index we need not compare with i-1th idx 

  
<details><summary>Code</summary>
<p> 
    
  
  
```java

 public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public void wiggleSort(int[] nums) {
        
        for(int i = 0;i<nums.length-1;i++){
            if(i%2 == 0 && nums[i]>nums[i+1]){
                swap(nums, i, i+1);
            }else if(i % 2 !=0 && nums[i] < nums[i+1]){
                swap(nums, i, i+1);
            }    
        }
    }
                                                       
```
    
  
</p>
</details>

  
37. 324 Wiggle Sort II :
  - Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3] >
  - Its different from wiggle sort 1 as equality sign is not present 
  - Approach 1 : 
    - Sort the array 
    - keep a pointer k = arr.length-1
    - start filling the odd index of the result array , i=1 , i+=2 res[i] = arr[k] , k--;
    - start filling the even index of result array, i = 0; i+=2 res[i] = arr[k] ,k -- (while filling odd index , at the end of the loop k is at the correct position)
  
  
<details><summary>Code</summary>
<p> 
    
  
  
```java  
  
   public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int k = res.length-1;
        for(int i = 1;i<res.length;i+=2){
            res[i] = nums[k];
            k--;
        }
        
        // nums = res;
        for(int i =0 ;i<res.length;i+=2){
            res[i]=nums[k];
            k--;
        }
        for(int i = 0;i<res.length;i++){
            nums[i] = res[i];
        }
    }
  
```
    
  
</p>
</details>  

  
38. Count and Say :
  - Time 0(N), Space 0(N)
  
<details><summary>Code</summary>
<p> 
    
```java  
  
  class Solution {
    public String helper(String s){
        //"11211"
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<s.length()){
            int count = 1;
            while(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(count+""+s.charAt(i));
            i++;
        }
        return sb.toString();
        
    }
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        
        String a = countAndSay(n-1);
        
        String ans = helper(a);
        return ans;
        
    }
}
  
```
    
  
</p>
</details> 
