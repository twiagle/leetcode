package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if(nums.length<1) return res;
            // 结果集不计算顺序(去重)，此时需要按顺序搜索，才能做到不重不漏
            //对原数组排序，保证相同的数字都相邻，然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」
            Arrays.sort(nums);
            dfs(res, new ArrayList<>(), nums, new boolean[nums.length]);

            return res;
        }
        void dfs(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] visited){
            if(cur.size()==nums.length){
                res.add(new ArrayList(cur));
                return;
            }
            for (int i = 0; i < visited.length; i++) {
                // 不可重复使用
                if (visited[i]) continue;
                // 从第二个元素开始，如果和前一个相同，且前一个没有使用
                if(i > 0 && nums[i] == nums[i-1] &&  !visited[i-1]){
                    continue;
                }
                // 路径add
                cur.add(nums[i]);
                // 从选择列表移除
                visited[i] = true;
                dfs(res,cur,nums,visited);
                // 路径remove
                cur.remove(cur.size()-1);
                // 加入选择列表
                visited[i] = false;
            }
        }
    }
}
