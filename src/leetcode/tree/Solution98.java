package leetcode.tree;

/**
 * 1\ 二叉查找树可以一一映射到数轴上，直接投影就行，可以看出每个节点都是一个二分查找
 * 2、二叉查找树不能有重复，所以加等号判断重复
 * 3、2147xxxx47  是Integer.MAX_VALUE所以要long才行
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return  isValidNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidNode(TreeNode root, long left, long right) {
        if (null == root) {
            return true;
        }
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return isValidNode(root.left, left, root.val) && isValidNode(root.right, root.val, right);
    }
}
