package question7;

public class Solution {
    public static int reverseInteger(int num){

        boolean isNegative = false;
        if (num < 0){
            num = - num;
            isNegative = true;
        }

        StringBuilder sb = new StringBuilder();
        if (isNegative){
            sb.append("-");
        }
        while (num > 0){
            sb.append(num%10);
            num = num/10;
        }

        int res = Integer.parseInt(sb.toString());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(120));
    }
}
