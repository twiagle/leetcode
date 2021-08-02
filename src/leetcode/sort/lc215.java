package leetcode.sort;

import java.util.Random;

class lc215 {
    int[] nums;
    int targetIndex;
    static Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        targetIndex = nums.length - k;
        return quickSelect(0, nums.length-1);
    }
    void quickSort(int left, int right){
        if(left >= right) return;
        int pivot = partition(left, right);
        quickSort(left,pivot-1);
        quickSort(pivot + 1, right);
    }

    public int quickSelect(int left, int right){
        if(left == right) return nums[left];//left or right edge

        int pivotIndex = partition(left, right);
        //从小到大，下标
        if(targetIndex == pivotIndex) return nums[pivotIndex];
        else if(targetIndex > pivotIndex) return quickSelect(pivotIndex+1, right);
        else return quickSelect(left, pivotIndex-1);
    }
    //每次partition都返回随机分点的正确位置，同时使得左边小，右边大
    public int partition(int left, int right){
        int pivotIndex = random.nextInt(right-left) + left;
        int pivot = nums[pivotIndex];
        int slow = left, fast = slow;
        //先把分点放到最右
        swap(pivotIndex, right);
        while(fast < right){
            if(nums[fast] < pivot) swap(fast, slow++);//小于一起走，大于留下慢指针
            fast++;                                    //慢指针永远指向第一个大于pivot的
        }
        //fast到了最右，slow指最后一个大于分点的数
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
