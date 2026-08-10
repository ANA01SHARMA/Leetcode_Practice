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
    TreeNode ans= null;
    public TreeNode searchBST(TreeNode root, int val) {
        solve(root, val);
        return ans;
    }

    public void solve(TreeNode root, int value){
        if(root==null)
        return;
        if(root.val==value){
            ans=root;
            return;
        }
        if(root.val>value){
            solve(root.left, value);
        }
        if(root.val<value){
            solve(root.right, value);
        }
        
    } 

}