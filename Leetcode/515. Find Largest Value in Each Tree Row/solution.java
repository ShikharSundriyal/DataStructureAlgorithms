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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        ArrayList<Integer> res = new ArrayList<>();
        while(queue.size()>0){
            int sz = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0;i<sz;i++){
                TreeNode node= queue.remove();
                if(node.val > max) max = node.val;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
