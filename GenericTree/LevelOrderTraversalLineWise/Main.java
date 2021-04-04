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

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void traversals(Node node){
    System.out.println("Node Pre " + node.data);

    for(Node child: node.children){
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    System.out.println("Node Post " + node.data);
  }

  public static void levelOrderLinewise(Node node){
    // write your code here
    Queue<Node> mainQ = new ArrayDeque<>();
    mainQ.add(node);
    // Approch 3
    // Add the root node and the marker that depicts that we have to print a new line
    // remove from queue , if node == marker that means prinln and again add the marker to the queue
    // if not marker than push all the child nodes in the queue.
    Node infi = new Node();
    infi.data = Integer.MIN_VALUE;
    mainQ.add(infi);
    
    while(mainQ.size() !=0){
        Node p = mainQ.remove();
        if(p.data == Integer.MIN_VALUE ){
            System.out.println();
            // to handle if infinity is present in the last of the queue
            if(mainQ.size()!=0)
                mainQ.add(infi);
        }else {
            System.out.print(p.data+" ");
            for(Node child:p.children){
                mainQ.add(child);
            }
        }
    }
    
    //Approach 2
    // while(mainQ.size() !=0){
    //     int sz = mainQ.size();
    //     for(int i = 0;i<sz;i++){
    //         Node p = mainQ.remove();
    //         System.out.print(p.data+" ");
    //         for(Node child:p.children){
    //             mainQ.add(child);
    //         }
    //     }
    //     System.out.println();
    // }
    //Approach 1
    // Queue<Node> childQ = new ArrayDeque<>();
    // mainQ.add(node);
    // while(mainQ.size() !=0 || childQ.size()!=0){
    //     Node p = mainQ.remove();
    //     System.out.print(p.data+" ");
    //     for(Node child:p.children){
    //         childQ.add(child);
    //     }
    //     if(mainQ.size() == 0){
    //         mainQ = childQ;
    //         childQ = new ArrayDeque<>();
    //         System.out.println();
    //     }
    // }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    levelOrderLinewise(root);
  }

}