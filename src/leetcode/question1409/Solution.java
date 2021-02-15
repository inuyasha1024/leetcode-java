package leetcode.question1409;

class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] nums = new int[m];
        int[] res = new int[queries.length];
        for(int i = 0; i < m; i++){
            nums[i] = i+1;
        }

        for(int i = 0; i < queries.length ; i++){
            int a = queries[i];
            for(int j = 0; j < nums.length; j++){
                if(a == nums[j]){
                    res[i] = j;
                    move(nums,j);
                }else{
                    continue;
                }
            }
        }
        return res;
    }
    public void move(int[] nums, int j){
        int tmp = nums[0];
        nums[0] = nums[j];
        int[] res = new int[nums.length];
        for (int i = 0; i < j; i++){
            int k = nums[i+1];
            nums[i+1] = tmp;
            tmp = k;
        }
    }

    public static void main(String[] args) {
        int[] res = new Solution().processQueries(new int[]{3,1,2,1},5);
        System.out.println(res);
    }
}
