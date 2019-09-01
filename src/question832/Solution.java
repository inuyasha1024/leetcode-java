package question832;

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++){
            horizontalReverse(A[i]);
            revert(A[i]);
        }

        return A;
    }

    public static void horizontalReverse(int[] nums){
        int i = 0, n = nums.length-1;
        while (i < n){
            int temp = nums[i];
            nums[i++] = nums[n];
            nums[n--] = temp;
        }
    }

    public static void revert(int[] nums){
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0) {
                nums[i] = 1;
            }else {
                nums[i] = 0;
            }
        }
    }
}
