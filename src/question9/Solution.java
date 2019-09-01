package question9;

import java.util.Stack;

public class Solution {
    public boolean isPalindromeNum(int num){
        boolean isPalindrome = true;
        String s = new Integer(num).toString();
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length;
        while (i <= j){
            if (chars[i] != chars[j]){
                isPalindrome = false;
            }
        }

        return isPalindrome;
    }

    public boolean isPalindromeNumNoString(int num){
        return false;
    }
}
