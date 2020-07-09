package leetcode.queue;

import java.util.PriorityQueue;

class Solution295 {

    /** initialize your data structure here. */
    //维护两个堆，一个大顶堆，一个小顶堆。大顶堆中存储前半部分数据，小顶堆中存储后半部分数据，且小顶堆中的数据都大于大顶堆中的数据。
    /** initialize your data structure here. */
    PriorityQueue<Integer> smallTop;//小顶
    PriorityQueue<Integer> bigTop;//大顶
    public Solution295() {
        smallTop = new PriorityQueue<>((a, b)->a-b);
        bigTop = new PriorityQueue<>((a,b)->b-a);
    }

    public void addNum(int num) {
        if(bigTop.size() <= smallTop.size()){
            int t = num;
            if(smallTop.peek() < num){
                t = smallTop.poll();
                smallTop.add(num);
            }
            bigTop.add(t);
        }else{
            int t = num;
            if(bigTop.peek() > num){
                t = bigTop.poll();
                bigTop.add(num);
            }
            smallTop.add(t);
        }
    }

    public double findMedian() {
        if(smallTop.size() == bigTop.size()){
            return (smallTop.peek() + bigTop.peek())/2;
        }else{
            return bigTop.peek();
        }
    }
}