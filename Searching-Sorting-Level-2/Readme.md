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
