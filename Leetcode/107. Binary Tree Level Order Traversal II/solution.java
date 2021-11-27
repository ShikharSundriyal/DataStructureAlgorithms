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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        
        q.add(root);
        while(q.size()>0){
            int sz = q.size();
            
            ArrayList<Integer> al = new ArrayList<>();
            for(int i = 0;i<sz;i++){
                TreeNode n = q.remove();
                al.add(n.val);
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            }
            res.add(al);
        }
        Collections.reverse(res);
        return res;
    }
}
