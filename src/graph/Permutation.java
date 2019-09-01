package graph;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permutation(int[] nums){

        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new boolean[nums.length],new ArrayList<Integer>(),nums);
        return res;

    }

    public void dfs(List<List<Integer>> res,  boolean[] visited, List<Integer> permutation, int[] nums){
        if (permutation.size() == nums.length){
            res.add(new ArrayList<>(permutation));
        }
        for (int i = 0; i< nums.length; i++){
            if (visited[i]){
                continue;

            }
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(res,visited,permutation,nums);
            visited[i] = false;
            permutation.remove(permutation.size()-1);
        }
    }
}
