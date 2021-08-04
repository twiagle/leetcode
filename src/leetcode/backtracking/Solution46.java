package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, new ArrayList<>(), nums, new boolean[nums.length]);

        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] visited){
        if(cur.size()==nums.length){
            res.add(new ArrayList(cur));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if(visited[i]){
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
