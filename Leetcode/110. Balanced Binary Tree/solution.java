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
    boolean balanced = true;
    public int height(TreeNode node){
        if(node == null || balanced == false) return -1;
        int lh = height(node.left);
        int rh = height(node.right);
        int bf = Math.abs(lh-rh);
        if(bf>1){
            balanced = false;
        }
        return Math.max(lh,rh)+1;
        
    }
    public boolean isBalanced(TreeNode root) {
        balanced = true;
        height(root);
        return balanced;
    }
}
