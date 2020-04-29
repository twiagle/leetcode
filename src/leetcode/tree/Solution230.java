package leetcode.tree;

/**
 * 中序遍历当中遇到的元素都是按照从小到大的顺序出现
 *
 */
public class Solution230 {
    int target;
    int res;
    int order=0;
    int state = 0;
    public int kthSmallest(TreeNode root, int k) {

        target = k;
        recursive(root);
        return res;
    }

    private void recursive(TreeNode root) {
        if (null == root || 1 == state) {
            return;
        }
        recursive(root.left);
        ++order;
        if (target == order) {
            res = root.val;
            state = 1;
            return;
        }
        recursive(root.right);
    }
}
