package jiuzhang.recursion;

import java.util.ArrayList;

public class UniqueSubSet {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        subSetHelper(res,list,nums,0);
        System.out.println(res.size());
    }

    public static void subSetHelper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] nums, int pos){
        res.add(new ArrayList<>(list));
        for (int i=pos; i< nums.length; i++){
            list.add(nums[i]);
            subSetHelper(res,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
