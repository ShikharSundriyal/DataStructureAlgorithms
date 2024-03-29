import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  
  static int ceil = Integer.MIN_VALUE;
  static int floor = Integer.MAX_VALUE;
  public static void ceilAndFloor(Node node, int data) {
    // Write your code here
    // set ceil
    // if current nodes data is bigger than data and it should be less than the current ceil
    if(node.data > data && ceil > node.data){
        ceil = node.data;
    }
    //set floor
    // if current nodes data is smaller and it should be bigger than the current floor
    if(node.data < data && floor < node.data){
        floor = node.data;
    }
    for(Node child:node.children){
        ceilAndFloor(child,data);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    ceil = Integer.MAX_VALUE;
    floor = Integer.MIN_VALUE;
    ceilAndFloor(root, data);
    System.out.println("CEIL = " + ceil);
    System.out.println("FLOOR = " + floor);
  }

}