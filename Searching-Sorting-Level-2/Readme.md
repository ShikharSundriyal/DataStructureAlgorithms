1. Marks Of Pcm :
  - Here we need to do a custom sort based on the physics marks , if physics marks are equal sort by desc of chem marks and then asc of maths marks.
  - Approach 1 : 
    - Create a Pair class which contains all three marks 
    - iterate over the individual subject marks and create a pair .
    - then sort that array containing all the pairs
    - the compareTo function should follow the mentioned order

<details><summary>Code</summary>
<p>

```java
 public static class Pair implements Comparable<Pair>{
        int phy;
        int chem;
        int maths;
        Pair(int phy, int chem, int maths){
            this.phy = phy;
            this.chem = chem;
            this.maths = maths;
        }
        public int compareTo(Pair other){
            if(this.phy!=other.phy){
                return this.phy-other.phy;
            }else if(this.chem != other.chem){
                return -(this.chem - other.chem);
            }else{
                return this.maths-other.maths;
            }
        }
    }

    /*You have to complete the body of customSort function, 
    after sorting final changes should be made in given arrays only. */
    public static void customSort(int[]phy,int[]chem,int[]math) {
        //write your code here
        Pair[] res = new Pair[phy.length];
        for(int i = 0;i<res.length;i++){
            res[i] = new Pair(phy[i],chem[i],math[i]);
        }
        Arrays.sort(res);
        for(int i = 0;i<res.length;i++){
            Pair p = res[i];
            phy[i] = p.phy;
            chem[i] = p.chem;
            math[i] = p.maths;
        }
        
    }
```
  
</p>
</details>


 2. 74 Search a 2D Matrix :
  -   Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
    -   Integers in each row are sorted from left to right.
    -   The first integer of each row is greater than the last integer of the previous row.
  - Approach 1 : Time 0(logN)
    - Here if we look at the properties given we can imagine the 2d array as a single 1d array that is sorted from left to right
    - We will first find the potential row where we can find the target by using binary search
    - once we have the potential row we will apply binary search on that row to check if the target element is present in the potential row or not.
 
<details><summary>Code</summary>
<p>

```java
public int findPotentialRow(int[][] matrix, int target){
        int i = 0,j=matrix.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(matrix[mid][0] <= target && target<=matrix[mid][matrix[0].length-1]) return mid;
            else if(matrix[mid][0]>target){
                j= mid-1;
            }else{
                i = mid+1;
            }
        }
        return -1;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int k = findPotentialRow(matrix,target);
      
        if(k == -1) return false;
        int i = 0,j=matrix[0].length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(matrix[k][mid] == target) return true;
            else if(matrix[k][mid] > target){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return false;
    }
```
  
</p>
</details>

 
3. 240 Search a 2D Matrix II :
  - Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
    - Integers in each row are sorted in ascending from left to right.
    - Integers in each column are sorted in ascending from top to bottom. 
  - Approach 1 : 
    - Here if we look at the property we can see that unlike previous questtion the last element of each row is not smaller than the first element of first row
    - Here we will keep the index at (0,arr[0].length-1) now check
      -  if the target is greater than the element if yes then i++ as target element will not be present in that row
      -  else if the target is smaller than the element then j-- , as target will not be present in that column


<details><summary>Code</summary>
<p>

```java
public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0,j=matrix[0].length-1;
        while(j>=0 && i<matrix.length ){
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] >target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
```
  
</p>
</details>

  
4. 475 Heaters :
  -Every house can be warmed, as long as the house is within the heater's warm radius range. Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.
  - Approach 1 Brute Force 0(heaters.length*houses.length): 
    - On reading the question we can see that for every house we have to find the the closest heater and the maximum amongst the minimum's will be the answer.
    - If we do it via brute force we will iterate over each house and then iterate over heaters for each house and find the closest heater to that house and then compare it with the exixting max.
  - Approach 2 : Optimised (houses.length *log(heaters.length)) + 0((heaters.length)*log(heaters.length))
    - If we look at the brute force approach we observe that instead iterating over heaters array for each house, we need to find the ceil and floor which means we need to find only the two clostest heater from the house and which ever is minimum of these two will be the radius for this house. For this we will need to sort the heaters array.
    - then we compare it with already existing minRadius amongst other radius .


  
<details><summary>Code</summary>
<p>

```java
  
  class Pair{
        int ceil;
        int floor;
        Pair(int ceil, int floor){
            this.ceil= ceil;
            this.floor = floor;
        }
    }
    public Pair helper(int house,int[] heaters){
        //here we find the heater which is closest to the house i.e. closest heater will be either just before the house or just after the house so we find ceil and floor
        int lo = 0,hi = heaters.length-1;
        int possibleceil=Integer.MAX_VALUE,possiblefloor=Integer.MIN_VALUE;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            
            if(heaters[mid] == house){
                return new Pair(0,0);
            }else if(heaters[mid] > house){
                // System.out.println("cc");
                possibleceil = heaters[mid];
                hi = mid-1;
            }else{
                possiblefloor = heaters[mid];
                lo = mid+1;
            }
            
        }
        return new Pair(possibleceil,possiblefloor);
        
    }
    public int findRadius(int[] houses, int[] heaters) {
        int minumumRadius = 0;
        Arrays.sort(heaters);
        for(int i = 0;i<houses.length;i++){
            Pair p = helper(houses[i],heaters);
            // System.out.println(p.floor + " " +p.ceil);
            int d1 = (p.ceil==Integer.MAX_VALUE ? Integer.MAX_VALUE:p.ceil - houses[i]);
            int d2 = (p.floor == Integer.MIN_VALUE) ? Integer.MAX_VALUE:houses[i]-p.floor;
            int m = Math.min(d1,d2);
            minumumRadius = Math.max(m,minumumRadius);
        }
        return minumumRadius;
    }
```
  
</p>
</details>
  
  
5. Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :
    Each student gets exactly one packet.
    The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.
  - Approach1 : 
    - Sort the chocolates array
    - Now iterate over the array for i = 0 to i <= arr.length-m
      - check if arr[i+m-1] - arr[i] < minsofar if yes minsofar = arr[i+m-1]-arr[i]

<details><summary>Code</summary>
<p>

```java
   public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        Collections.sort(a);
        // your code here
        long minsofar = Integer.MAX_VALUE;
        for(int i = 0;i<=a.size()-(int)(m);i++){
            long gap = a.get(i+(int)(m)-1)-a.get(i);
            if(gap<minsofar){
                minsofar = gap;
            }
        }
        return minsofar;
    }
  
```
  
    
</p>
</details>
  
  
6. Count the triplets :
  - Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
  - Approach 1 : 0(nlogn)
    - We can apply sum of pairs equal to target concept where target will become the arr[i]
 
  
<details><summary>Code</summary>
<p>

```java
  
  int pairsum(int[] arr, int target,int i,int j){
        int count = 0;
        while(i<j){
            int sum = arr[i]+arr[j];
            if(sum == target){
                count++;
                i++;
                j--;
            }else if (sum > target){
                j--;
            }else{
                i++;
            }
        }
        return count;
    }
    int countTriplet(int arr[], int n) {
        // code here
        Arrays.sort(arr);
        int res = 0;
        for(int i = n-1;i>=2;i--){
            res+=pairsum(arr,arr[i],0,i-1);
        }
        return res;
    }
  
```
  
    
</p>
</details>

  
7. 724 Find Pivot Index :
  Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.
  - Approach 1 : Brute Force 0(n2) 
    - travel from i = 1st idx to arr.length-1
    - now travel from 0 to i-1 and find sum
    - and travel from i+1 to arr.length and find sum 
    - check if both sum's are equal if yes return i
 
  - Approach 2 : Optimised 0(N) , space 0(N)
    - make two arrays one with prefic sum and one with suffix sum 
    - now iterate over the array from i = 1 to i< arr.length - 1
      - check if prefix[i-1] == suffix[i+1] return i;

 

                                                            
<details><summary>Code</summary>
<p>

```java
 public int pivotIndex(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];
        pre[0] = nums[0];
        suf[nums.length-1] = nums[nums.length-1];
        for(int i = 1;i<pre.length;i++){
            pre[i] = pre[i-1] + nums[i];
        }
        for(int i = nums.length-2;i>=0;i--){
            suf[i] = suf[i+1]+nums[i];
        }
        if(suf[1] == 0) return 0;
        
        for(int i = 1;i<nums.length-1;i++){
            if(pre[i-1] == suf[i+1]) return i;
        }
        if(pre[nums.length-2] == 0) return nums.length-1;
        return -1;
    }
  
```

</p>
</details>

  
8. Koko Eating Bananas :
  Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
  Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
  Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
  Return the minimum integer k such that she can eat all the bananas within h hours.
  
    - Approach 1 : Brute Force 
      - The possible speed of eating bananas per hour can be 1 to max of array. As if koko eats max of array bananas in every hour then in total arr.length hours it will eat all the piles of bananas
      - We will write a function which checks if koko can eat all piles of bananas with current speed where speed will vary from 1 to max of array
      - No of hours taken to eat each pile of bananas is ceil of bananas/speed 
    - Approach 2 : Optimised
      - Here we will use binary search as we know the answer can range from 1 to max of array and 1 to 11 is sorted so we can use binary search
      - lo = 1 and hi = max of array
         - we find mid and check if with speed of mid koko can eat all bananas if yes then we mark this mid as possible ans and make hi = mid-1
         - if with k speed koko cant eat all bananas then we will make lo = mid + 1 as we need know we need to increase the speed 
  
  
  
                                                            
<details><summary>Code</summary>
<p>

```java
  // brute force 
  class Solution {
    public boolean caneat(int[] piles,int speed, int hour){
        for(int bananas:piles){
            int hrs = (int)(Math.ceil(1.0*bananas/speed)); //time taken in each pile
            hour-=hrs;
            if(hour<0) return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        // possible speed is 1 to 11
        int maxSpeed = 0;
        for(int val:piles){
            if(val>maxSpeed){
                maxSpeed = val;
            }
        }
        for(int i = 1;i<=maxSpeed;i++){
            if(caneat(piles,i,h)) return i;
        }
        return -1;
    }
}
  
  
  
  
  
 // optimised 
  public boolean caneat(int[] piles,int speed, int hour){
        for(int bananas:piles){
            int hrs = (int)(Math.ceil(1.0*bananas/speed)); //time taken in each pile
            hour-=hrs;
            if(hour<0) return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        // possible speed is 1 to 11
        int maxSpeed = 0;
        for(int val:piles){
            if(val>maxSpeed){
                maxSpeed = val;
            }
        }
        int lo =1,hi = maxSpeed,ans = 0;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(caneat(piles,mid,h)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return ans;
    }
  
  
```
</p>
</details>

                      
                      
9. Allocate Minimum Number Of Pages (InterviewQuery): 
  - Given an array of integers A of size N and an integer B.
  College library has N bags,the ith book has A[i] number of pages.You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.
  A book will be allocated to exactly one student.
  Each student has to be allocated at least one book.Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
  - Approach1 : 
    - if the number of students greater than the number of books then return -1 and books cannot be divided
    - the answer will range from minimum number of pages that can be assigned and the maximum number of pages that can be assigned
    - minimum number of pages that can be assigned is : if each student is given one book then max of array will be the minimum pages that will be assigned in this permutation
    - maximum number of pages that can be asigned is : if all the books are assinged to a single student then minimum pages that need to be read by the student will be sum of arr
    - Now we know that the answer will vary from max of array to sum of array so we can apply binary search
    - we write a function can AllocateBooks which checks if x number of books can be assinged to given number of students

  
                                                            
<details><summary>Code</summary>
<p>

```java
  
  public class Solution {
    public boolean canAllocate(int[] arr, int mid, int pages){
        int p =1,sum=0;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>mid){
                p++;
                sum=arr[i];
            }
        }
        return p<=pages;
    }
    public int books(int[] A, int B) {
        if(A.length<B) return -1;
    int hi=0,lo=Integer.MIN_VALUE;
    for(int val: A){
        hi+=val;
        lo = Math.max(lo,val);
    }
    int poss = 0;
    while(lo<=hi){
        int mid = lo + (hi-lo)/2;
        if(canAllocate(A,mid,B)){
            poss = mid;
            hi = mid-1;
        }else{
            lo = mid+1;
        }
    }
    return poss;
    }
}

  
```
</p>
</details>  
  
  
  
10. 1011 Capacity To Ship Packages Within D Days : (Similar to Allocate pages)
  - A conveyor belt has packages that must be shipped from one port to another within days days.
  The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
  Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days
  - Approach 1 : 
    - mincase if we place one by one the packages on the ship the minimum capacity of ship will be max of array as ship should be able to handle all the bags so minimum weight it should be able to handle is max of weights.
    - maxcase will be if all the packages are loaded to the ship on the same day so ship should be able to handle sum of all weights
    - Now we know the answer range we can apply binary search

  
<details><summary>Code</summary>
<p>

```java  
  class Solution {
    public  boolean canShipWithWeight(int[] arr,int min_weight,int days){
        int total_weight = 0, days_taken = 1;
        for(int i = 0;i<arr.length;i++){
            total_weight+=arr[i];
            if(total_weight>min_weight){
                days_taken++;
                total_weight = arr[i];
            }
        }
        return days_taken<=days;
    }

  public  int shipWithinDays(int[]arr, int days) {
    //write your code here
    int lo =0,hi=0;
    for(int val:arr){
        hi +=val;
        lo = Math.max(lo,val);
    }
    int poss = 0;
    while(lo<=hi){
        int mid = lo+(hi-lo)/2;
        if(canShipWithWeight(arr,mid,days)){
            poss = mid;
            hi = mid-1;
        }else{
            lo = mid+1;
        }
    }
    
    return poss;
  }

}
```
</p>
</details>    
