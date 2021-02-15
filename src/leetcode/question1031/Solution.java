package leetcode.question1031;

public class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int res1 = 0;
        int pos1 = 0;
        for (int i = 0; i < A.length-L; i++){
            //res1 = Math.max(res1, arraySum(A,i,L));
            if (res1 < arraySum(A,i,L)){
              res1 = arraySum(A,i,L);
              pos1 = i;
            }
        }

        int res2 = 0;
        if (M > pos1+1 || M > (A.length - pos1 - L -1)){
            return -1;
        }

        for (int i = 0; i < pos1 - M; i++){
            res2 = Math.max(res2, arraySum(A,i,M));
        }
        for (int i = pos1+ L; i < A.length - M ; i++){
            res2 = Math.max(res2,arraySum(A,i,M));
        }

        return res1+res2;
    }

    public static int arraySum(int[] nums, int i, int l){
        int res = 0;
        while (l-- > 0){
            res += nums[i++];
        }

        return res;
    }
}
