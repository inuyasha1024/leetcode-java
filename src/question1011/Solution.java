package question1011;

class Solution {
//    public static int shipWithinDays(int[] weights, int D) {
////        int mid = 0;
////        int max = 0;
////        for (int i = 0; i < weights.length; i++){
////            max += weights[i];
////        }
////
////        int min = Integer.MIN_VALUE;
////        for (int i = 0; i < weights.length; i++){
////            if (min < weights[i]){
////                min = weights[i];
////            }
////        }
////
////        while (min+1 < max){
////            mid = min + (max - min)/2;
////            int weight = 0;
////            int day = getDays(weights, mid);
////
////            if (day > D){
////                min = mid;
////            }else if(day < D){
////                max = mid;
////            }else {
////                max = mid;
////            }
////        }
////
////        return mid;
////    }
////
////    public static int getDays(int[] weights, int mid){
////        int day = 0;
////        int weight = 0;
////        for (int i = 0; i < weights.length; i++){
////            if (weight + weights[i] <= mid){
////                weight += weights[i];
////            }else {
////                weight = weights[i];
////                day++;
////            }
////        }
////        day++;
////        return day;
////    }

    public int shipWithinDays(int[] weights, int D) {
        int min = 0;
        int max = 0;

        for (int i = 0; i < weights.length; i++){
            max += weights[i];
        }
        for (int i = 0; i < weights.length; i++){
            min = Math.max(min, weights[i]);
        }

        while (min + 1 < max){
            int mid = min + (max - min)/2;

            int weight = 0;
            int day = 1;
            for (int i = 0; i < weights.length; i++){
                if (weight + weights[i] <= mid){
                    weight += weights[i];
                }else {
                    weight = weights[i];
                    day++;
                }
            }

            if (day < D){
                max = mid;
            }else if (day == D){
                max = mid;
            }else {
                min = mid + 1 ;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,1};
        System.out.println(new Solution().shipWithinDays(nums,4));
    }
}
