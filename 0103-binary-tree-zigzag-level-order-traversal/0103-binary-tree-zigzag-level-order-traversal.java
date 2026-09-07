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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lst=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        if(root==null)
            return lst;

        q.offer(root);
        boolean flag=false;
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0; i<n; i++) {
                TreeNode cur=q.poll();
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);

                if(!flag) list.add(cur.val);
                if(flag) list.add(0,cur.val);
            }
            lst.add(list);
            flag=!flag;
        }       
        return lst;
    }
}