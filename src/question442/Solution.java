package question442;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            if (nums[Math.abs(nums[i])-1] < 0){
                res.add(Math.abs(nums[i]));
            }
            nums[Math.abs(nums[i])-1] = - Math.abs(nums[Math.abs(nums[i])-1]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDuplicates(nums);
        System.out.println(list);
    }
}
