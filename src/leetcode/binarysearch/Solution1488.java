package leetcode.binarysearch;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//水池第一次下雨不用管，第二次下雨就得找一个在第一次下雨后，第二次下雨之前（当前，从前往后扫描可保证）的晴天抽水
public class Solution1488 {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> sunnyDay = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>(); //第几个湖泊上次下雨的日子
        int[] res = new int[rains.length];
        Arrays.fill(res,1);

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                sunnyDay.add(i);
                continue;
            }
            res[i] = -1;//不能干活
            //i天池塘rains[i]下雨，如果是第二次下，就找个i以前的晴天
            int poolNum = rains[i];
            if(map.containsKey(poolNum)){
                int preDay = map.get(poolNum);//poolNum第一次下雨是那天
                Integer tarDay =  sunnyDay.higher(preDay);//tar那天抽pre
                if(tarDay == null) return new int[0];
                sunnyDay.remove(tarDay);
                res[tarDay] = poolNum;
                map.put(poolNum,i);
            }else{
                map.put(poolNum,i);
            }
        }
        return res;
    }
}
