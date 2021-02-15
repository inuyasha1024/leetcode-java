package leetcode.question1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int toSun(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i =0; i< nums.length; i++){
            if (map.containsKey(target-nums[i])){
                return i;
            }
        }
        return -1;
    }
}
