package binary_search;

public class SearchRange {
    public int[] searchRange(int[] nums, int target){


//        int[] bounds = new int[2];
//
//
//        int start = 0;
//        int end = nums.length-1;
//
//        //left bound
//        while (start + 1 < end){
//            int mid = start + (end - start)/2;
//            if (target == nums[mid]){
//                mid = end;
//            }else if (target < nums[mid]){
//                mid = end;
//            }else {
//                mid = start;
//            }
//        }
//
//        if (nums[start] == target){
//            bounds[0] = start;
//        }
//        else if (nums[end] == target){
//            bounds[0] = end;
//        }else {
//            bounds[0] = bounds[1] = -1;
//            return bounds;
//        }
//
//        //right bound
//        while (start < end){
//            int mid = start + (end - start)/2;
//            if (nums[mid] == target){
//                start = mid;
//            }
//            else if (nums[mid] < target){
//                mid = end;
//            }else {
//                mid = start;
//            }
//        }
//
//        if (nums[end] == target){
//            bounds[1] = end;
//        }else if (nums[start] == target){
//            bounds[1] = start;
//        }else {
//            bounds[0] = bounds[1] = -1;
//            return bounds;
//        }
//        return bounds;

        int start = 0;
        int end = nums.length-1;

        int[] bound =new int[2];

        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target){
                mid = end;
            }else {

            }
}       return null;
    }


}
