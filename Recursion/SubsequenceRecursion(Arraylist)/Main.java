import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(getSubSequence(str));
	}
	
	public static ArrayList<String> getSubSequence(String str){
		//basecase
		if(str.length() == 0){
			ArrayList<String> al = new ArrayList<>();
			al.add("");
			return al;
		}
		// get the first character
		char ch = str.charAt(0);
		str = str.substring(1,str.length());
		//faith : get all the subsequence for substring
		ArrayList<String> partialsubsequence = getSubSequence(str);
		ArrayList<String> finalresult = new ArrayList<>();
		
		for(String val:partialsubsequence){
			finalresult.add(val);
		}
		for(String val:partialsubsequence){
			finalresult.add(ch+val);
		}
		return finalresult;
	}
}