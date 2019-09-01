package question608;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++){
            map.put(numbers[i],i);
        }

        for (int i = 0; i < numbers.length; i++){
            int k = target - numbers[i];
            if (map.containsKey(k) && map.get(k) != i){
                res[0] = k < numbers[i]? map.get(k) + 1 : i + 1;
                res[1] = k < numbers[i]? i + 1 : map.get(k) + 1;
                break;
            }
        }
        return res;
    }
}
