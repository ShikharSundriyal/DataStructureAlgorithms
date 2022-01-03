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
