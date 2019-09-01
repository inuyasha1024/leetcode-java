package question456;

import java.util.Stack;

public class Solution {
    public boolean find132pattern(int[] nums) {

        if (nums.length < 3){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;
        for (int i = nums.length -1; i >= 0; i--){
            if (nums[i] < third){
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()){
                third = Math.max(third,stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,5,0,3,4};
        //System.out.println(find132pattern(nums));
    }
}
