## Approach :
1. Sort the array
2. once the array is sorted we need to rearrange the elements such that at for all index after 0, (i-1)th element and (i+1)th element are either both greater than arr[i] or both are lesser than arr[i] so that in either case they cannot satisfy the condition.
3. Keep a pointer at start of array and end of array, as array is sorted bring the largest element from last to 0th position and keep the smalles elment that we are getting from left pointer at 1st position. Now for 1st position if we see (i-1)th element is larger than arr[i] and (i+1)th element will also we the larger than arr[i] as the array is sorted.
