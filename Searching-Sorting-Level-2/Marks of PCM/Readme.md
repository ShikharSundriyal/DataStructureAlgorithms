1. Marks Of Pcm :
  - Here we need to do a custom sort based on the physics marks , if physics marks are equal sort by desc of chem marks and then asc of maths marks.
  - Approach 1 : 
    - Create a Pair class which contains all three marks 
    - iterate over the individual subject marks and create a pair .
    - then sort that array containing all the pairs
    - the compareTo function should follow the mentioned order
 
 2. 74 Search a 2D Matrix :
  -   Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
    -   Integers in each row are sorted from left to right.
    -   The first integer of each row is greater than the last integer of the previous row.
  - Approach 1 : Time 0(logN)
    - Here if we look at the properties given we can imagine the 2d array as a single 1d array that is sorted from left to right
    - We will first find the potential row where we can find the target by using binary search
    - once we have the potential row we will apply binary search on that row to check if the target element is present in the potential row or not.
 
 
3. 240 Search a 2D Matrix II :
  - Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
    - Integers in each row are sorted in ascending from left to right.
    - Integers in each column are sorted in ascending from top to bottom. 
  - Approach 1 : 
    - Here if we look at the property we can see that unlike previous questtion the last element of each row is not smaller than the first element of first row
    - Here we will keep the index at (0,arr[0].length-1) now check
      -  if the target is greater than the element if yes then i++ as target element will not be present in that row
      -  else if the target is smaller than the element then j-- , as target will not be present in that column 
