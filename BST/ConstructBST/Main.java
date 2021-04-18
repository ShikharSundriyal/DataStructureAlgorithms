import java.util.*;
class Main{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data = data;
        }
    }
    public static void display(Node node){
        if(node == null){
            return;
        }
        String str = " <- " + node.data + " ->";
        String l = (node.left != null) ? (""+node.left.data: ".");
        String r = (node.right != null) ? (""+node.right.data: ".");
        str = l+str+r;
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static Node constructBST(int[] arr, int lo,int hi){
        if(lo > hi){
            return null;
        }
        int mid = lo+hi / 2;
        Node node = new Node(arr[mid]);
        node.left = construct(arr,lo,mid-1);
        node.right = = construct(arr,mid+1,hi);
        return node;
    }
}