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
        int dia;
        int ht;
        Pair(int dia, int ht){
            this.dia = dia;
            this.ht  = ht;
        }
    }
    
    public Pair helper(TreeNode node){
        if(node == null){
            return new Pair(0,-1);
        }
        Pair lp = helper(node.left);
        Pair rp = helper(node.right);
        int newdia = Math.max(Math.max(lp.ht + rp.ht +2, lp.dia),rp.dia);
        int myht = Math.max(lp.ht,rp.ht)+1;
        return new Pair(newdia,myht);
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        
        Pair res = helper(root);
        return res.dia;
        
    }
}
