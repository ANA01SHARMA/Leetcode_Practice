class Solution {
    int min = Integer.MAX_VALUE;
    int prev = -1;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != -1) {
            min = Math.min(min, root.val - prev);
        }

        prev = root.val;

        inorder(root.right);
    }
}