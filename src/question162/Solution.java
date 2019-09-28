package question162;

class Solution {
    public int findPeakElement(int[] nums) {


//        int start = 1;
//        int end = nums.length - 2;
//
//        while (start + 1 < end){
//            int mid = start + (end - start)/2;
//            if (nums[mid] < nums[mid -1]){
//                end = mid;
//            }else if (nums[mid] < nums[mid +1]){
//                start = mid;
//            }else {
//                return  mid;
//            }
//        }
//
//        if (nums[start] < nums[end]){
//            return end;
//        }else {
//            return start;
//        }

        for (int i = 0; i< nums.length; i++){
            if (i == 0 && nums[i] > nums[i+1]){
                return i;
            }
            else if (i > 0 && i < nums.length-1){
                if (nums[i] > nums[i+1] && nums[i] > nums[i-1]){
                    return i;
                }
            }else {
                if (i == nums.length -1 && nums[i] > nums[i-1]){
                    return i;
                }
            }

        }
        return 0;
    }
}
