import java.util.*;
class Main{
    public static class Node{
        int data;
        Node left;
        Node right;
        
    }
    public static class Pair{
        int state;
        Node n;
        public Pair(Node n, int state){
            this.n = n;
            this.state = state;
        }
    }
    public static Node construct(Integer[] arr){
        Stack<Pair> st = new Stack<>();
        Node root = new Node();
        root.data = arr[0];
        Pair p = new Pair(root,0);
        st.push(p);
        for(int i =1;i<arr.length;i++){
            Pair tos = st.peek();
            if(arr[i] == null){
                tos.state++;  
                if(tos.state == 2){
                    st.pop();
                }
            }else{
                Node c = new Node();
                c.data = arr[i];
                Pair ch = new Pair(c,0);
                if(tos.state == 0){
                    tos.n.left = c;
                    tos.state++;
                    st.push(ch);
                }else if(tos.state == 1){
                    tos.n.right = c;
                    st.pop();
                    st.push(ch);
                }
            }
        }
        return root;
    }
    public static int size(Node node) {
        // write your code here
        if(node == null){
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        return ls+rs+1;
      }

    public static void display(Node root){
        if(root == null){
            return;
        }
        if(root.right == null && root.left == null){
            System.out.println(". "+"<-"+root.data+"->"+" .");
        }
        else if(root.left == null){
            System.out.println(". "+"<-"+root.data+"->"+root.right.data);
        }else if(root.right == null ){
            System.out.println(root.left.data+"<-"+root.data+"->"+" .");
        }else{
            System.out.println(root.left.data+"<-"+root.data+"->"+root.right.data);
        }
       
        display(root.left);
        display(root.right);
    }
    public static void main(String[] args) {
        Integer[] arr = {10,20,40,null,null,null,30,null,null};
        Node root = construct(arr);
        display(root);
        System.out.println(size(root));
    }
}