import java.util.*;
public class Main{
    public static class Node{
        ArrayList<Node> children;
        int data;
        public Node(int data){
            this.data = data;
            children = new ArrayList<>();
        }
    }
    public static Node construct(int[] data){
        Stack<Node> st = new Stack<>();
        Node root = new Node(data[0]);
        st.push(root);
        for(int i = 1;i<data.length;i++){
            if(data[i] == -1){
                //leaving
                st.pop();
            }else{
                Node nn = new Node(data[i]);
                st.peek().children.add(nn);
                st.push(nn);
            }
        }
        return root;
    }
    public static void display(Node root){
        System.out.print(root.data+"->" );
        for(Node child:root.children)
            System.out.print(child.data+" ");
        System.out.println();
        for(Node child:root.children)
            display(child);
    }
    public static void main(String[] args){
        int[] data = {10,20,-1,30,50,-1,-1,40,-1,-1};
        Node root = construct(data);
        display(root);
    }
}