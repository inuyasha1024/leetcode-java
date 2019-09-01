package question39;

import java.util.*;

public class Solution {

    public static List<Integer> getThreeDigitsNum(){
        List<Integer> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] nums = {1,2,3,4};
        trackBack(res,sb,nums,0);
        return res;
    }

    public static void trackBack(List<Integer> res, StringBuilder sb, int[] nums, int pos){
        if (sb.toString().length() > 2){
            res.add(Integer.parseInt(sb.toString()));
            return;
        }
        for (int i = pos; i< nums.length; i++) {
            sb.append(nums[i]);
            trackBack(res,sb,nums,i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public static Set<List<Integer>> combinationSum(int[] nums, int target){
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        helper(res,list,target,nums);

        return res;
    }

    public static void helper(Set<List<Integer>> res, List<Integer> list, int target, int[] nums){
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        for (int i = 0 ; i < nums.length; i++){
            if (target == nums[i]){
                list1.add(nums[i]);
                list1.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 > o2? 1:-1;
                    }
                });
                res.add(list1);
            }
            else if (target > nums[i]){
                list1.add(nums[i]);

                helper(res,list1,target-nums[i],nums);
                list1.remove(list1.size()-1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,5};
        int target = 8;
        Set<List<Integer>> res = combinationSum(nums,target);
//        System.out.println(res);

        List<Integer> res1 = getThreeDigitsNum();
        System.out.println(res1);
    }
}
