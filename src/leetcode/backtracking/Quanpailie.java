package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 无重复元素 全排列
 */
public class Quanpailie {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track, res);
        return res;
    }

    // 路径:记录在 track 中
    // 选择列表:nums 中不存在于 track 的那些元素
    // 结束条件:nums 中的元素全都在 track 中出现
    static void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> res) {
    // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 前序 做选择，写入当前记录中，影响递归结束条件，或剪枝条件
            track.add(nums[i]);
            // 遍历多叉树
            backtrack(nums, track, res);
            // 后序 撤销选择
            track.removeLast();
        }
    }
}
