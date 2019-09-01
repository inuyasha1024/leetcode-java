package question905;

import java.util.*;

public class Solution {
    public static int[] deckRevealedIncreasing(int[] deck) {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < deck.length; i++){
            list.add(deck[i]);
        }
        Collections.sort(list,Collections.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < list.size(); i++){
            if (queue.isEmpty()){
                queue.offer(list.get(i));
            }else {
                int temp = queue.poll();
                queue.offer(temp);
                queue.offer(list.get(i));
            }
        }
        int[] res = new int[deck.length];
        for (int i = res.length - 1; i >= 0; i--){
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {17,13,11,2,3,5,7};
        int[] res = deckRevealedIncreasing(nums);
        System.out.println(res);
    }
}
