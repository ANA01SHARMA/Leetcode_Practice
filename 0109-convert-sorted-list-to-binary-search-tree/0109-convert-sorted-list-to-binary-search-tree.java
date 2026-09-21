/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    
    public TreeNode sortedListToBST(ListNode head) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        // Convert linked list to array
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        
        // Create BST
        return createBST(arr, 0, arr.size() - 1);
    }
    
    public TreeNode createBST(ArrayList<Integer> arr, int left, int right) {
        
        if (left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        
        TreeNode root = new TreeNode(arr.get(mid));
        
        root.left = createBST(arr, left, mid - 1);
        root.right = createBST(arr, mid + 1, right);
        
        return root;
    }
}