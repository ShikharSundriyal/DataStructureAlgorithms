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
