package leetcode.arraylist;

/**
 * 167. 两数之和 II - 输入有序数组
 * skill; two pointer
 * for a single target: if sum < target ,we must find sth bigger, but the right is the biggest, so only thing we can do is let left bigger
 * 有点像控制变量，和11题盛水容器有点像，给一个值极值，另一个可选，那个题没法排序，只能一次遍历
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length-1;
        while (l < r) {
            int sum = (numbers[l] + numbers[r]);
            if (target == sum) {
                break;
            }else if(target > sum){
                l++;
            }else{
                r--;
            }

        }
        return new int[]{l+1, r+1};
    }
}
