package oj;


/**
 * 不要添加package answer之类的语句
 * Main为唯一的public class,其他用默认
 */

import java.util.*;
import java.util.stream.Stream;

/**
 现在现在有一台机器，这台机器可以接收两种形式任务：（1）任务列表，任务列表里面有N个任务，对于第i个任务，机器在Ti时间开始执行，并在1个单位时间内做完。
 （2）临时任务，机器可以在任意时间接收一个临时任务，但任务列表里面的任务优先级要高于临时任务，也就是说当机器空闲的时候才会执行临时任务。
 现在机器已经接收一个任务列表。接下来会有M个临时任务，我们想知道每个临时任务何时被执行。为了简化问题我们可以认为这M个临时任务是独立无关即任务是可以同时执行的，互不影响的。
 可以运行daemon任务的位置区间（两头开），将daemon任务排序，放入合适区间
 */
public class Solution360_1 {
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);

        String line = cin.nextLine();
        String[] str = line.split(" ");
        int[] integers = Stream.of(str).mapToInt(Integer::valueOf).toArray();
        int n = integers[0], m = integers[1];

        //construct proper validInterval
        line = cin.nextLine();
        str = line.split(" ");
        int[] priorTask = Stream.of(str).mapToInt(Integer::valueOf).toArray();
        Deque<Integer[]> validInterval = new ArrayDeque<>();
        if(priorTask[0]>1)
            validInterval.offerFirst(new Integer[]{0, priorTask[0]});
        for (int i = 1; i < priorTask.length; i++) {
            if (priorTask[i] - priorTask[i - 1] > 1) {
                validInterval.offerLast(new Integer[]{priorTask[i - 1], priorTask[i]});
            }
        }
        validInterval.offerLast(new Integer[]{priorTask[priorTask.length-1], (int)(1e9) + 1});


        int order = 0;
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);
        for (int i = 0; i < m; i++) {//如果用cin.hasNext()或者nextInt会阻塞
            minHeap.offer(new Integer[]{Integer.parseInt(cin.nextLine()), order++});
        }
        int[] result = new int[m];

        //for each daemon task, find a proper validInterval
        while (!minHeap.isEmpty()) {
            Integer[] daemon = minHeap.poll();

            while(daemon[0] >= validInterval.peekFirst()[1]){
                validInterval.pollFirst();
            }

            Integer[] interval = validInterval.peekFirst();
            int l = interval[0], r = interval[1];
//            if (daemon[0] < r) {
                if (daemon[0] > l) {
                    result[daemon[1]] = daemon[0];
                }else{
                    result[daemon[1]] = l+1;
                }
//            }
        }
        Arrays.stream(result).forEach(System.out::println);//another sout way
//        Stream.of(result).flatMapToInt(Arrays::stream).forEach(System.out::println);
    }
}













