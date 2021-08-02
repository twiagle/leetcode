package leetcode.binarysearch;

public class BinarySearch {
    public int binarySearch(int[] data, int len, int tar){
        int left = 0;
        int right = len-1;
        while(left<=right){
            int mid = left + ((right - left) >> 1);// + priority to >>
            if(data[mid] == tar){
                return mid;
            }else if(data[mid] > tar){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return -1;
    }
    public int firstGlance(int[] data, int len, int tar){
        int left = 0;
        int right = len-1;
        while(left<=right){
            int mid = left + ((right - left) >> 1);// + priority to >>
            if(data[mid] == tar){
                if(mid==0 || data[mid-1] != tar)
                    return mid;
                else right = mid -1;
            }else if(data[mid] > tar){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return -1;
    }
    public int firstGE(int[] data, int len, int tar){//>=
        int left = 0;
        int right = len-1;
        while(left<=right) {
            int mid = left + ((right - left) >> 1);// + priority to >>
            if(data[mid] < tar){
                left = mid +1;
            }else{
                if(mid == 0 || data[mid-1] < tar){
                    return mid;
                }else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }
    public int rotationSortedArrayFindMin(int[]nums,  int len){
        if(nums.length == 1) return nums[0];
        int left = 0;
        int right = len-1;
        if(nums[left] < nums[right]){
            return nums[0];
        }

        while(left<=right) {
            int mid = left + ((right - left) >> 1);
            //ending return smaller one
            if(nums[mid-1] > nums[mid]) return nums[mid];
            if(nums[mid] > nums[mid+1]) return nums[mid+1];

            if(nums[mid] > nums[0]){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
}
