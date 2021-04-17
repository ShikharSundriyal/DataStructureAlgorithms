import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }
  
  public static class BSTPair{
      int min;
      int max;
      boolean isBST;
      BSTPair(){
          
      }
      BSTPair(int min, int max, boolean isBST){
          this.min = min;
          this.max = max;
          this.isBST = isBST;
      }
  }
  public static BSTPair isTreeBST(Node node){
      if(node == null){
          return new BSTPair(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
      }
      // get a pair from left side, containing the min, max and if the left subtree is BST
      BSTPair lp = isTreeBST(node.left);
      // get a pair from right side, containing the min, max and if the right subtree is BST
      BSTPair rp = isTreeBST(node.right);
      /*At a given node checking if the tree is BST, 
        FOR THAT WE have to check if 
                        is left subtree is BST
                        is right Subtree is BST 
                        is node.data greater than all the values in left subtree and node.data is smaller than all values on right subtree 
     */
      boolean property = (lp.isBST && rp.isBST && (lp.max < node.data && rp.min > node.data));
      // Calculating the max, comparision btw node.data, left subtree max and right subtree max
      int max = Math.max(Math.max(lp.max,rp.max),node.data);
      // calculating min btw node.data left subtree min and right subtree min
      int min = Math.min(Math.min(lp.min,rp.min),node.data);
      BSTPair p = new BSTPair(min,max,property);
      return p;
      
  }

 
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    BSTPair res = isTreeBST(root);
    System.out.println(res.isBST);
    // write your code here
  }

}