package leetcode.question771;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        char[] j  = J.toCharArray();
        char[] s = S.toCharArray();
        int res = 0;
        for (int i = 0; i < j.length; i++){
            for (int k = 0; k < s.length; k++){
                if (s[k] == j[i]){
                    res++;
                }
            }
        }

        return res;
    }
}
