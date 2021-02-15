package leetcode.question1052;

public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = Integer.MIN_VALUE;
        int temp = 0;
        for(int i = 0; i < customers.length; i++){
            if (i <= X-1){
                temp += customers[i];
            }else {
                if (grumpy[i] == 0){
                    temp += customers[i];
                }
            }
        }


        for (int i = X ; i < customers.length; i++){
            if (grumpy[i] == 1){
                temp = temp + customers[i];
            }
            if (grumpy[i - X] == 1){
                temp = temp - customers[i - X];
            }
            res = Math.max(temp,res);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] customers = new int[]{4,10,10};
        int[] grumpy = new int[]{1,1,0};
        int X = 2;
        System.out.println(new Solution().maxSatisfied(customers,grumpy,X));
    }
}
