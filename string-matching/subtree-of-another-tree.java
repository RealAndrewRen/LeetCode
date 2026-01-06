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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null){
            return subRoot == null;
        }
        while (root != subRoot && root != null){
            if (root.val < subRoot.val){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
    return contains(root, subRoot);
    }
    public boolean contains(TreeNode root, TreeNode n){
        if (n == null){
            return true;
        }
        if (root == null){
            return n == null;
        }
        return root.val == n.val && contains(root.right, n.right) && contains(root.left, n.left);
    }
}