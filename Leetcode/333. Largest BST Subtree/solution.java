/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public class Pair{
        int min;
        int max;
        boolean isbst;
        int sz;
        Pair(int min, int max, int sz, boolean isbst){
            this.min = min;
            this.max = max;
            this.sz = sz;
            this.isbst = isbst;
        }
    }
    public Pair isTreeBST(TreeNode node){
        if(node == null){
            return new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE,0,true);
        }
        
        Pair l = isTreeBST(node.left);
        Pair r = isTreeBST(node.right);
        boolean amibst = l.isbst && r.isbst && l.max<node.val && r.min>node.val;
        int mymin = Math.min(Math.min(l.min,r.min),node.val);
        int mymax = Math.max(Math.max(l.max,r.max),node.val);
        int mysz = 0;
        if(amibst) {
            mysz = l.sz+r.sz+1;
        }else{
            mysz = Math.max(l.sz,r.sz);
        }
        return new Pair(mymin,mymax,mysz,amibst);
        
    }
    public int largestBSTSubtree(TreeNode root) {
        
        Pair res = isTreeBST(root);
        return res.sz;
        
    }
}
