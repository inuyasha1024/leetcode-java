package leetcode.question1395;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
//    public int numTeams(int[] rating) {
//        int count = 0;
//        Set<List<Integer>> set = new HashSet<>();
//        List<List<Integer>> collections = new ArrayList();
//        for (int i = 0; i < rating.length; i++) {
//            findAllCollection(collections, rating, new ArrayList<Integer>(), 0);
//        }
//        for (List<Integer> list: collections){
//            if ((list.get(0) > list.get(1) && list.get(1) > list.get(2)) ||(list.get(0) < list.get(1) && list.get(1) < list.get(2))){
////                count ++;
//                set.add(list);
//            }
//        }
//        return set.size();
//    }
//    public void findAllCollection(List<List<Integer>> collections, int[] rating,List<Integer> collection, int p){
//        List<Integer> list = new ArrayList();
//        list.addAll(collection);
//        if(list.size() == 3){
//            collections.add(list);
//            return;
//        }
//        for(int i = p; i < rating.length; i++){
//            list.add(rating[i]);
//            findAllCollection(collections,rating,list,i+1);
//            list.remove(list.size() -1);
//        }
//
//    }
public int numTeams(int[] rating) {
    Set<List<Integer>> set = new HashSet();
    for(int i = 0; i < rating.length; i++){
        for(int j = 0; j < rating.length; j++){
            for(int k = 0; k < rating.length; k++){
                if((rating[i] > rating[j] && rating[j] > rating[k]) || (rating[i] < rating[j] && rating[j] < rating[k])){
                    List<Integer> list = new ArrayList();
                    list.add(rating[i]);
                    list.add(rating[j]);
                    list.add(rating[k]);
                    set.add(list);
                }

            }
        }
    }
    return set.size();
}

    public static void main(String[] args) {
        new Solution().numTeams(new int[]{2,1,3});
    }
}
