package leetcode.question78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res,list,nums,0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int p){
        if (list.size()>nums.length){
            return;
        }
        res.add(new ArrayList<>(list));
        for (int i = p; i < nums.length; i++){
            list.add(nums[i]);
//            res.add(list);
            helper(res,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> res = subsets(new int[]{1,2,3});
//        System.out.println(res);
    }
}
