package leetcode.backtracking;

import java.util.*;

/**
 * 回溯就是暴力搜索的同时知道及时止损
 * 去重的方法：类似求一个集合有多少非空子集：[a,b,c] a, ab, abc,b,bc,c 结果集不计算顺序(去重)，此时需要按顺序搜索，才能做到不重不漏
 * 下一个元素只能选  它自己或者在它之后的元素，不能选给定数组在它之前的
 * [2,2,3]和[3,2,2]只算一个，单元素允许重复
 * 无负数
 * 可以[1,2,3] 4 举例
 */
public class Solution39 {
    Deque<Integer> stack = new ArrayDeque<>();//store trace，和回溯算法本体无关
    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        backTracking(0,target);
        return res;
    }

    public void backTracking(int index, int target) {
        if(target < 0) return;//回溯的精髓在此，失败止损
        if (target == 0) {//成功到达
            res.add(Arrays.asList(stack.toArray(new Integer[0])));
            return;
        }
        //还没到达，也没失败
        //允许重复的问题是不能用length控制，永远进入自己可就麻烦了
        //保证不会有重复
        // 允许当前元素加入，故无法visited去除
        for (int i = index; i< candidates.length; i++) {
            stack.push(candidates[i]);
            backTracking(i, target - candidates[i]);
            stack.pop();//成与不成都应该pop，紧跟回溯的脚步
        }
    }
}
