package com;

import java.util.Random;

class lc215 {
    int[] nums;
    int targetIndex;
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        targetIndex = nums.length - k;
        return quickSelect(0, nums.length-1);
    }

    public int quickSelect(int left, int right){
        if(left == right) return nums[left];//left or right edge
        int pivotIndex = new Random().nextInt(right-left) + left;
        pivotIndex = partition(left, right, pivotIndex);
        if(targetIndex == pivotIndex) return nums[pivotIndex];
        else if(targetIndex > pivotIndex) return quickSelect(pivotIndex+1, right);
        else return quickSelect(left, pivotIndex-1);
    }
    public int partition(int left, int right, int pivotIndex){
        int pivot = nums[pivotIndex];
        int slow = left, fast = slow;
        swap(pivotIndex, right);
        while(fast < right){
            if(nums[fast] < pivot) swap(fast, slow++);//小于一起走，大于留下慢指针
            fast++;                                    //慢指针永远指向第一个大于pivot的
        }
        swap(fast, slow);
        return slow;
    }
    void swap(int indexA, int indexB){
        if(indexA == indexB) return;
        int t = nums[indexB];
        nums[indexB] = nums[indexA];
        nums[indexA] = t;
    }
}
