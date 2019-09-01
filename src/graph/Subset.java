package graph;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subset(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(res,subset,0,nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> subset, int p, int[] nums){
        res.add(new ArrayList<>(subset));
        for (int i = p; i< nums.length; i++){
            subset.add(nums[i]);
            dfs(res,subset,i+1,nums);
            subset.remove(subset.size()-1);
        }
    }
}
