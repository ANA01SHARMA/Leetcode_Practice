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
    public void flatten(TreeNode root) {

        TreeNode curr = root;

        while (curr != null) {

            if (curr.left != null) {

                TreeNode prev = curr.left;

                // Find the rightmost node of left subtree
                while (prev.right != null) {
                    prev = prev.right;
                }

                // Connect original right subtree
                prev.right = curr.right;

                // Move left subtree to right
                curr.right = curr.left;

                // Set left to null
                curr.left = null;
            }

            curr = curr.right;
        }
    }
}