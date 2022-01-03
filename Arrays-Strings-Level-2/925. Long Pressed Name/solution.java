import java.util.*;
 
 import javax.sound.sampled.BooleanControl.Type;
 
 public class Main {
 	 public static void main(String[] args) {
 
 	 	 Scanner scn = new Scanner(System.in);
 	 	 String name = scn.next();
 	 	 String typed = scn.next();
 	 	 System.out.println(isLongPressedName(name, typed));
 
 	 }
 
 	 // -----------------------------------------------------
 	 // This is a functional problem. Only this function has to be written.
 	 // This function takes as input 2 strings
 	 // It should return boolean output.
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
 
 }
