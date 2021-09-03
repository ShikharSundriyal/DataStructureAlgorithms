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
