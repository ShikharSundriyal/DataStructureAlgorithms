1. 26 Remove Duplicates from Sorted Array : 2 approaches </br>
Approach 1 : 2 pointer i at 0 , j at 1, if(arr[i] == arr[j] ) increase j++ else i++ assign value of arr[i] = arr[j] then increase j++ </br>
Approach 2 : Start vising the array from backwards, if arr[i] == arr[i-1] then arr[i] = arr[i+1] and arr[i+1] = Integer.Maxvalue make sure to handle case for [1,1] and else count++ return count+1; </br>

2. 561 Array Partition I </br>
Approach : We need to make the sum max, so inorder to make sum max we need to make sure we select a pair which contains the maximum number, so for that we sort the array and take the i and i+2 elemnts and sum them as min(arr[o],arr[1]) will be arr[0] as array is sorted.
