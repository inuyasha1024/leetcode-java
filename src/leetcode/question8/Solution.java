package leetcode.question8;

import java.math.BigInteger;

class Solution {
    public static int myAtoi(String str) {
        char a = ' ';
        int j = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ' || str.charAt(i) == '+'){
                continue;
            }else{
                a = str.charAt(i);
                j = i;
                break;
            }
        }
        if(!Character.isDigit(a) && a != '-'){
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        if(str.charAt(j) == '-'){
            sb.append("-");
            for(int i = j+1; i < str.length(); i++){
                if(Character.isDigit(str.charAt(i))){
                    sb.append(str.charAt(i));
                }else{
                    break;
                }
            }
        }else{
            for(int i = j; i < str.length(); i++){
                if(Character.isDigit(str.charAt(i))){
                    sb.append(str.charAt(i));
                }else{
                    break;
                }
            }
        }

        BigInteger int1 = BigInteger.valueOf(Integer.MIN_VALUE);
        BigInteger int2 = BigInteger.valueOf(Integer.MAX_VALUE);

        if (sb.charAt(0) == '-'){
            if(sb.length() == 1){
                return 0;
            }
            BigInteger res = new BigInteger(sb.substring(1,sb.length()));
            if (res.compareTo(int2) > 0){
                return Integer.MIN_VALUE;
            }
        }else {
            if(sb.length() == 0){
                return 0;
            }
            BigInteger res = new BigInteger(sb.toString());
            if (res.compareTo(int2) > 0){
                return Integer.MAX_VALUE;
            }
        }


        return Integer.valueOf(sb.toString());

    }

    public static void main(String[] args) {

        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }


}
//best solution
class Solution2 {
    public int myAtoi(String str) {
        int result = 0;
        boolean started = false;
        int sign = 1;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == ' ' && !started) {
                continue;
            }
            else if(c == '-' && !started) {
                sign = -1;
                started = true;
            }
            else if(c == '+' && !started) {
                started = true;
            }
            else if(c >= '0' && c <= '9') {
                if(!started) {
                    started = true;
                }
                if(result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && c >= '8') {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result *= 10;
                result += (int)c - (int)'0';
            }
            else {
                break;
            }
        }
        return result * sign;
    }
}