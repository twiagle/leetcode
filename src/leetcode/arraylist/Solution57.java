package leetcode.arraylist;

import java.util.ArrayList;
import java.util.List;
//这是一道让我明白while和for循环的区别的题，while用于非循环控制条件的地方
//迭代处理i<intervals.length借助避免复杂的判断条件，在规则内运动最好了，别管什么效率，简单是最好的
public class Solution57 {
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        if(intervals.length == 0) {
//            int[][] res = new int[1][2];
//            res[0] = newInterval;
//            return res;
//        }
//        List<Integer[]> res = new ArrayList<>();
//        int i =0;
//        while(i<intervals.length && intervals[i][1] < newInterval[0])
//            res.add(new Integer[]{intervals[i][0],intervals[i][1]});
//        i++;
//    }
//    //i is first [][1] >= [0]
//    Integer[] tmpInterval = new Integer[2];
//    tmpInterval[0] = Math.  (newInterval[0], intervals[i][0]);
//    i++;
//        for (; i < intervals.length; i++) {
//        if(intervals[i][0] > newInterval[1]){
//            break;
//        }
//    }
//    tmpInterval[1] = Math.max(intervals[i-1][1],newInterval[1]);
//        res.add(tmpInterval);
//
//        for (;  i< intervals.length; i++) {
//        res.add(new Integer[]{intervals[i][0],intervals[i][1]});
//    }
//    int[][] result = new int[res.size()][2];
//        for (int j = 0; j < res.size(); j++) {
//        result[j][0] = res.get(j)[0];
//        result[j][1] = res.get(j)[1];
//    }
//        return result;
//}
public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> res = new ArrayList<>();
    int i =0;
    while(i<intervals.length && intervals[i][1] < newInterval[0]){
        res.add(new int[]{intervals[i][0],intervals[i][1]});
        i++;
    }
    //i is first [][1] >= [0]  overlap
    while(i<intervals.length && intervals[i][0] <= newInterval[1]){
        newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
        i++;
    }
    res.add(newInterval);

    for (;  i< intervals.length; i++) {
        res.add(new int[]{intervals[i][0],intervals[i][1]});
    }
    int[][] result = new int[res.size()][2];
    for (int j = 0; j < res.size(); j++) {
        result[j][0] = res.get(j)[0];
        result[j][1] = res.get(j)[1];
    }
    return result;
}
}
