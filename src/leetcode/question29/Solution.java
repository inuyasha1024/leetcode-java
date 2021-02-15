package leetcode.question29;

class Solution {
    public static int divide(int dividend, int divisor) {
        int sign1 = 1;
        int sign2 = 1;
        int a = 0;
        int b = 0;
        if(dividend < 0) {
            sign1 = -1;
        }
        if(divisor < 0) {
            sign2 = -1;
        }

        int mod = (dividend * sign1) % (divisor * sign2);
        if(dividend == Integer.MIN_VALUE){
            a = Integer.MAX_VALUE;
        }else{
            a = dividend * sign1;
        }

        if(divisor == Integer.MIN_VALUE){
            b = Integer.MAX_VALUE;
        }else{
            b = divisor * sign2;
        }

        int res = (a - mod) / b;
        return res * sign1 * sign2;

    }


    public static void main(String[] args) {
        divide(-2147483648,2);
    }
}
