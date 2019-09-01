package question11;

public class Solution {
    public static int maxContainer(int[] height){
        int i = 0, j = height.length -1, max = 0;
        while (i<j){
            int contain = Math.min(height[i],height[j]) * (j-i);
            max = Math.max(max,contain);
            if (height[i] > height[j]){
                --j;
            }else {
                ++i;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxContainer(height));
    }
}
