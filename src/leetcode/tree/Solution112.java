package leetcode.tree;

/**
 * 1\ sum有可能是负数啊
 * 2、空树，sum=0  啊
 * 3、必须从根到叶子啊，中间不行啊，
 * 不加 root.left == null && root.right == null 就是中间也行
 * 用 || 真是省了全局变量啊
 */

public class Solution112 {
    int target;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        target = sum;
        return isSum(root, 0);
    }

    boolean isSum(TreeNode root, int sum) {
        if(root == null) return false;
        int cur=sum + root.val;

        if(root.left == null && root.right == null && cur == target)  return true;
        return isSum(root.left, cur) || isSum(root.right, cur);
    }
}
