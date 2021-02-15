package leetcode.question1108;

public class Solution {
    public static String defangIPaddr(String address) {
        String[] strings = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++){
            if (i < strings.length-1){

                sb.append(strings[i]);
                sb.append("[.]");
            }else {
                sb.append(strings[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "1.1.1.1";
        System.out.println(defangIPaddr(s));
    }
}
