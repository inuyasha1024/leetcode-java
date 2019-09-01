package dfs;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public List<List<Integer>> combine(int[] nums, int k){
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        combineDFS(res,list,nums,0,k);
        return res;
    }


    public void combineDFS(List<List<Integer>> res,List<Integer> list, int[] nums, int pos, int k){
        if (list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            combineDFS(res,list,nums,pos+1,k);
            list.remove(list.size()-1);
        }

    }
}
