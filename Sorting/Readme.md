1. Merge Two Sorted Array </br>
Time complexity : O(n+m) </br>
Approach : 2 pointer approach, one pointer at arr1 and second pointer at arr2

2. Merge Sort </br>
Approach : find mid, using faith get the sorted first half, using faith get the sorted second half</br>
now mergeTwoSortedArr for first and second half</br>
base case for recursion when lo == hi {only one element is present which is sorted so return an array with that element}

3. Bubble sort : Adjacent element comparision in each iteration</br>
at 1st iteration, will put the largest element on the right</br>
at 2nd iteration, will find the 2nd largest element</br>
the right side becomes sorted as we are pushing the larger elements to the right</br>
total nuber of iterations required to sort an array of length n is n-1 </br>
problem will become smaller with each iteration as right side is becoming sorted </br>
iterations loop from [1 to n-1] </br>
comparisions loop [0 to n-iter)</br>

4. selection Sort : </br>
sorted array starts forming from left side</br>
three variables , i =0 to  i < arr.length-1 ,j = i+1 to j<arr.length , inside i loop declare minidx = i; </br>
i loop for number of iterations,</br>
at each iteration we are trying to place correct element at ith position -> </br>
for i = 0 smallest element should come, </br>
we have to find the min element in the entire array that is we iterate over the array from i+1 and end and find the index which has smallest element </br>
after j loop completes we have index of smallest element ,  swap the smallest element with ith element.</br>
1st iteration puts smallest element to 0th position</br>
2nd interation puts second smallest to 1st position</br>

5. Insertion Sort</br>
we have two areas sorted area and unsorted array, at any given moment we have to insert an element from unsorted region to a sorted region</br>
iterations loop from itr = 1 to itr <= arr.length-1. (iteration starts from 1 as an array of length 1 is already sorted)</br>
inner loop for j = itr to j >=1 j-- , if arr[j-1] > arr[j] swap else break</br>

6. Sort 01 : (In linear time, without using extra space, in sinle parse) ([Code](https://github.com/ShikharSundriyal/DataStructureAlgorithms/blob/main/Sorting/Sort%2001/solution.java))</br>
If two parse, in first parse count the number of zeroes , now traverse again and fill the starting total_number_of_zeroes with 0 and remaining elements with 1.</br>
define regions , 0's region : 0 to j-1 , 1's region j to i-1 , unknown region -> i to end</br>

7. Sort 012 : </br>
Approach1 : define regions , 0's region 0 ti j-1, 1's region j to i-1 , 2's region i to k-1, k to end unknown</br>
In approach 1 there is a edge case here if we have only 2 regions and one region is missing. Solution to handle edge case -> before swapping check if i,j or j,k are different</br>
Approach2 : define regions , 0's region 0 ti j-1, 1's region j to i-1 , 2's region k+1 to end, i to k unknown</br>
i=0,j=0,k=arr.length-1</br>

8. Partition an array : </br>
Similar to sort 01 
define region -> all elements less than or equal to pivot place in 0 to j-1, if element greater than pivot then j to i-1, i to end unknown

9. Quick sort (complexity varies from nlogn to n2)</br>
Based on partition an array</br>
treat last element as pivot and call partition an array function which will place the pivot index at correct position, make sure the partition an array returns the index of the pivot element</br> 
now call quicksort on lo to pi-1 and quicksort on pi+1 to hi </br>
base case will be when lo > hi return (meaning no elements remaining in the array )</br>

10. Quick select (Kth smallest , based on quick sort ) :</br>
partition an array returns the pivot index and also places the correct element at that pivot index .</br>
we have to find when k == pi i.e. element at pi index is kth smallest element.</br>
3 cases when pi == k then return arr[pi]</br>
if(pi < k) i.e. we have to find 4th smallest and pi is 2 , then we have to call quick select on right hand side i.e quickselect(lo = pi+1,hi = hi,k = k)</br>
else (pi > k) i.e we have to find 4 th smallest and pi is 5 , then we have to call qucick select on left hand side i.e. quickselect(lo = lo, hi = pi-1, k=k)</br>
