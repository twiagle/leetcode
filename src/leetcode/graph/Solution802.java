package leetcode.graph;

import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] prerequisites) {
        int numCourses = prerequisites.length;
        int[] deDegree = new int[numCourses];
        List<Integer> res = new LinkedList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        //先构建map，省的判空逻辑分支
        for (int i = 0; i < prerequisites.length; i++) {
            //注意map.put返回的是old value
            List<Integer> l = new LinkedList<>();
            map.put(i, l);
        }
        //出度为0的，就是安全点，链表存入边的节点，也就是拿掉我，谁可以少一条出边
        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = 0; j < prerequisites[i].length; j++) {
                map.get(prerequisites[i][j]).add(i);
                ++deDegree[i];
            }
        }

        for (int i = 0; i < deDegree.length; i++) {
            if (deDegree[i] == 0) {
                deque.offer(i);
            }
        }
        //selective bfs using queue is very smart
        while (!deque.isEmpty()) {
            int pre = deque.poll();

            if(map.containsKey(pre)){
                for (Integer toTake : map.get(pre)) {
                    if(--deDegree[toTake] == 0){
                        deque.offer(toTake);
                    }
                }
            }

//            map.remove()
        }
        for (int i = 0; i < numCourses; i++) {
            if(deDegree[i] ==0) res.add(i);
        }
        return res;
    }
}
