package leetcode.question3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int findLongestSubstring(String str){
        int i =0 , j = 0, res = 0;
        char[] chars = str.toCharArray();
        //Set<Character> characterSet = new HashSet<>();
        Map<Character, Integer> charMap = new HashMap<>();
        while (i < str.length()){
            if(!charMap.containsKey(chars[i])){
                charMap.put(chars[i],i);
                ++i;
                res = Math.max(res,i-j);
            }else {
                j = charMap.get(chars[i]);
                charMap.remove(chars[i]);
                res = Math.max(res, i-j);
            }
        }
        return  res;
    }
}
