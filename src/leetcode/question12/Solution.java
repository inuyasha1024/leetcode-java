package leetcode.question12;

public class Solution {
    static String intToRoman(int num){
        String res = "";
        int[] vals = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str = {"M","DM","D","CD","C","LC","L","XL","X","VX","V","IV","I"};
        for(int i =0 ; i< str.length; i++){
            while (num <= vals[i]){
                num -= vals[i];
                res += str[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
