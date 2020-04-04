package alg.leetcode.tree;

public class Solution525 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return  0;
        }
        int leftLen = maxDepth(root.left);
        int rightLen = maxDepth(root.right);
        return 1 + Math.max(leftLen, rightLen);
    }


}
