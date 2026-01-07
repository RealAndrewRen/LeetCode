class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        // If trees match starting here, we're done
        if (isSame(root, subRoot)) return true;

        // Otherwise, check left and right subtrees
        return isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        // Both null → identical
        if (a == null && b == null) return true;

        // One null → not identical
        if (a == null || b == null) return false;

        // Values must match
        if (a.val != b.val) return false;

        // Check both subtrees
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
}
