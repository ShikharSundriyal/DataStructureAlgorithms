import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		LinkedList<Integer> ls = new LinkedList<>(); // a datastructure which follows FIFO
		ls.addFirst(10); // adds element to the first position [10]
		ls.addLast(20); // adds element to the end of the linked list [head->10->20->tail]
		ls.addLast(30); // adds element to the end of the linked list [head->10->20->30->tail]
		System.out.println(ls); // 10->20->30
		ls.removeFirst(); // removes the first element from the front
		System.out.println(ls); // [head->20->30->tail]
		ls.removeLast(); // removes the element from the end of the list 
		System.out.println(ls); // [head->20->tail]
	}
}