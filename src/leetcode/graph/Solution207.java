package leetcode.graph;

import java.util.*;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        //graph prerequisite -> to take
        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int toTake = prerequisites[i][0];
            //注意map.put返回的是old value
            if (!map.containsKey(pre)) {
                List<Integer> l = new LinkedList<>();
                map.put(pre, l);
                l.add(toTake);
            }else{
                map.get(pre).add(toTake);
            }
            ++inDegree[toTake];
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                deque.offer(i);
            }
        }
        //selective bfs using queue is very smart
        while (!deque.isEmpty()) {
            int pre = deque.poll();

            if(map.containsKey(pre)){
                for (Integer toTake : map.get(pre)) {
                    if(--inDegree[toTake] == 0){
                        deque.offer(toTake);
                    }

                }
            }

//            map.remove()
        }
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] !=0 ) return false;
        }
        return true;
    }
}
