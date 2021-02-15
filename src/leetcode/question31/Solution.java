package leetcode.question31;

public class Solution {
    public static int[] nextPermutation(int[] nums) {
        //find the first num
        int t = 0;
        for (int l = nums.length-1; l>0;l--){
            if (nums[l] > nums[l-1]){
                t = l-1;
                break;
            }
        }
        int k = 0;
        int val = Integer.MAX_VALUE;
        for (int i = t; i < nums.length; i++){
            if (nums[i] < val && nums[i] > nums[t]){
                k = i;
            }
        }

        int temp = nums[k];
        nums[k] = nums[t];
        nums[t] = temp;
        nums = reverse(nums,t+1);

        return nums;
    }

    private static int[] reverse(int[] nums, int l) {
        int i = l;
        int k = nums.length-1;
        for (; i <= k; i++,k--){
            int temp = nums[k];
            nums[k] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,7,4,3,1};
        int[] res = nextPermutation(nums);
        System.out.println(res);
    }
}
