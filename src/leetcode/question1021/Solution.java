package leetcode.question1021;

import java.util.Stack;

class Solution {
    public static String removeOuterParentheses(String S) {
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean isOuter = true;
        if (chars[0] != '('){
            return null;
        }

        for (int i = 0; i < chars.length; i++){
            if (chars[i] != '(' && chars[i] != ')'){
                sb.append(chars[i]);
            }else {
                if (chars[i] == '('){
                    if (stack.isEmpty() && isOuter){
                        isOuter = false;
                        continue;
                    }else {
                        stack.push(chars[i]);
                        sb.append(chars[i]);
                    }
                }else {
                    if (stack.isEmpty()){
                        isOuter = true;
                        continue;
                    }else {
                        stack.pop();
                        sb.append(chars[i]);
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String res = removeOuterParentheses("(()())(())");
        System.out.println(res);
    }
}
