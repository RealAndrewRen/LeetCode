import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }

        List<Integer> level = new ArrayList<>();
        TreeNode marker = new TreeNode(Integer.MIN_VALUE);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(marker);   // mark end of first level

        while (!q.isEmpty()) {
            TreeNode curr = q.remove();

            if (curr.val == Integer.MIN_VALUE) {
                // finished one level
                result.add(level);
                level = new ArrayList<>();

                if (!q.isEmpty()) {
                    q.add(marker);  // mark next level
                }
            } else {
                level.add(curr.val);

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        return result;
    }
}
