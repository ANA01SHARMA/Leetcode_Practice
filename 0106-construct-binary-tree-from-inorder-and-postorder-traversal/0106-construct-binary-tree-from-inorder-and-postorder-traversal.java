import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int value = postorder[postIndex--];
        TreeNode root = new TreeNode(value);

        int index = map.get(value);

        root.right = build(inorder, postorder, index + 1, end);
        root.left = build(inorder, postorder, start, index - 1);

        return root;
    }
}