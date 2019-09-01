package question14;

public class Solution {
    public static String longestCommonPrefix(String[] strings){
        StringBuilder sb = new StringBuilder();
        for (int i =0 ; i < strings[0].length(); i++){
            char c = strings[0].charAt(i);
            for (int j = 1; j < strings.length; j++){
                if ( strings[j].length() < i+1 || strings[j].charAt(i) != strings[0].charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(c);

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strings));
    }
}
