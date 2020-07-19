package leetcode.arraylist;

import java.util.*;

public class lc56 {
    int[][] merge(int[][] intervals) {
        // 将所有的区间按照起始时间的先后顺序排序
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        // 定义一个 previous 变量，初始化为 null
        int[] previous = null;
        // 定义一个 result 变量，用来保存最终的区间结果
        List<int[]> result = new ArrayList<>();

        // 从头开始遍历给定的所有区间
        for (int[] current : intervals) {
            // 如果这是第一个区间，或者当前区间和前一个区间没有重叠，那么将当前区间加入到结果中
            if (previous == null || current[0] > previous[1]) {
                result.add(previous = current);
            } else { // 否则，两个区间发生了重叠，更新前一个区间的结束时间
                previous[1] = Math.max(previous[1], current[1]);
            }
        }

        return result.toArray(new int[result.size()][]);

    }

}
