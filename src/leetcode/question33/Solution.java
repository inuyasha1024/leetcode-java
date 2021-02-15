package leetcode.question33;

public class Solution {
//    public int search(int[] nums){
//
//    }


    public int getMix(int[] nums){
        int start = 0;
        int end = nums.length-1;
        int mix = 0;
        while (start + 1 < end){
            int mid = start + (end - start)/2;

            if (nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1] ){
                start = mid;
            }else if(nums[mid-1] > nums[mid] && nums[mid] > nums[mid+1] ){
                end = mid;
            }else {
                 mix = mid;
            }
        }
        return mix;
    }

//    public int find(int[] nums, int target){
//        int start = 0;
//        int end = nums.length-1;
//        while (start + 1 < end){
//            int mid = start + (end - start)/2;
//            if (nums[mid] > target){
//
//            }
//        }
//    }
}
