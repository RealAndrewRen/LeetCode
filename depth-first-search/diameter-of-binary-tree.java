class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // update global diameter
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // return height of this subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
