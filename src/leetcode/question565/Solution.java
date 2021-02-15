package leetcode.question565;

public class Solution {
    public int arrayNesting(int[] nums) {
//        //Map<Integer, Integer> res = new HashMap<>();
//        int res = 0;
//        for (int i = 0; i < nums.length; i++){
//            Map<Integer, Integer> map = new HashMap<>();
//            while (!map.containsKey(nums[i])){
//                map.put(nums[i],i);
//                i = nums[i];
//            }
//            res = Math.max(res, map.size());
//        }
//        return res;

        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if (!visited[i]){
                int start = nums[i];
                int count = 0;
                do {
                    start = nums[start];
                    visited[start] = true;
                    count++;
                }while (start != nums[i]);
                res = Math.max(res,count);
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,0,3,1,6,2};
        System.out.println(new Solution().arrayNesting(nums));
    }
}
