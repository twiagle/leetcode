package leetcode.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  15.三数之和
 *  skill: sorted + double pointer
 */
class Solution15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int[] iiii = new int[2];
        List<List<Integer>> result = new ArrayList<>(0);
        result.add(null);
        result.get(1);
        int first=0;
        while (first < nums.length -2 && nums[first] <= 0) {
            if(first > 0 && nums[first] == nums[first-1]) {//如果这里写成while，必须把父亲的while条件也写进去
                first++;//不++就死循环了
                continue;
            }
            int left = first + 1, right = nums.length-1;
            int target = -nums[first];
            while (left < right) {
                int sum = nums[left] + nums[right];
                if(sum == target){
                    List<Integer> list  = new ArrayList<>(3);
                    list.add(nums[first]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;//注意必须先移动再判断相同，以下均同理
                    while(left < right && nums[left] == nums[left-1])
                        left++;

                    right--;
                    while(left < right && nums[right] == nums[right+1])
                        right--;
                }else if(sum > target){
                    right--;
                    while(left < right && nums[right] == nums[right+1])
                        right--;
                }else{
                    left++;
                    while(left < right && nums[left] == nums[left-1])
                        left++;
                }
            }
            first++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{4, 2, 1, 0, -1, -1}));
    }
}