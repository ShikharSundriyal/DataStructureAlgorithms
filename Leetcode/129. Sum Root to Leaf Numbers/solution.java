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
    int sum;
    public void helper(TreeNode node, String path){
        if(node.left == null && node.right == null){
            path+=node.val+"";
            int num = Integer.parseInt(path);
            // System.out.println(num);
            sum+=num;
            return;
        }
        if(node.left!=null)
            helper(node.left,path+node.val+"");
        if(node.right!= null)
            helper(node.right,path+node.val+"");
        
    }
    public int sumNumbers(TreeNode root) {
        sum = 0;
        helper(root,"");
        return sum;
    }
}
