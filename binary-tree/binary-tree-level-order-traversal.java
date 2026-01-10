import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<ArrayList<Integer>>();
        List<Integer> level;
        TreeNode marker = new TreeNode(Integer.MIN_VALUE);

        if (root == null){
            return null;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode curr = q.remove();
            if (curr.val == Integer.MIN_VALUE){
                result.add(level);
                level = new ArrayList<Integer>();
                if (!q.isEmpty){
                    q.add(marker);
                }
            }
            else{
                level.add(curr.val);
                q.add(root.left);
                q.add(root.right);
            }
            result.add(level);
        }
    return result;
    }
}
