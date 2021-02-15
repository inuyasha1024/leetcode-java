package question115;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static String reverseWords(String s) {
        List<String> strs = Arrays.asList(s.split("\\s+")).stream().filter(str -> str.length() > 0).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (int i = strs.size() - 1; i >= 0; i--){
            if (i != 0){
                sb.append(strs.get(i));
                sb.append(" ");
            }else {
                sb.append(strs.get(i));
            }
        }
        
        String str = strs.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(""));
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("a good   example"));
        System.out.println(reverseWords("the sky is blue"));
    }
}
