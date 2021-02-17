package jiuzhang.class1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coding {

  public List<List<Integer>> permutation2(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
    permutation2Help(res, new ArrayList(), numsList);
    return res;
  }

  public void permutation2Help(List<List<Integer>> res, List<Integer> list, List<Integer> nums) {
    if (nums.size() == 0){
      res.add(new ArrayList<>(list));
      return;
    }

    for (int i = 0; i < nums.size(); i++) {
      list.add(nums.get(i));
      List<Integer> temp = new ArrayList<>(nums);
      temp.remove(i);
      permutation2Help(res, list, temp);
      list.remove(list.size() - 1);
    }
  }

  public List<List<Integer>> permutation(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    permutationHelp(res, new ArrayList<>(), nums);
    return res;
  }

  public void permutationHelp(List<List<Integer>> res, List<Integer> list, int[] nums) {
    if (list.size() == nums.length){
      res.add(new ArrayList<>(list));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (list.contains(nums[i])) {
        continue;
      }
      list.add(nums[i]);
      permutationHelp(res, list, nums);
      list.remove(list.size() - 1);
    }
  }


  public List<List<Integer>> subsets2(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    subset2Helper(res, new ArrayList<>(), nums, 0);
    return  res;
  }

  public void subset2Helper(List<List<Integer>> res, List<Integer> list, int[] nums, int pos) {
    res.add(new ArrayList<>(list));

    for (int i = pos; i < nums.length; i++) {
      if (i != pos && nums[i] == nums[i -1]) {
        continue;
      }
      list.add(nums[i]);
      subset2Helper(res, list, nums, i + 1);
      list.remove(list.size() - 1);
    }
  }


  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    subsetHelper(res, new ArrayList(), nums, 0);
    return res;
  }

  public void subsetHelper(List<List<Integer>> res, List<Integer> list, int[] nums, int pos) {
    //snapshot
    res.add(new ArrayList<>(list));

    for (int i = pos; i < nums.length; i++) {
      list.add(nums[i]);
      subsetHelper(res, list, nums, i + 1);
      list.remove(list.size() - 1);
    }
  }


  //find the target string in source string
  //cant find return -1
  public static int strStr(String source, String target){

    if (source == null || target == null) {
      return -1;
    }

    char[] sourceChar = source.toCharArray();
    char[] targetChar = target.toCharArray();
    boolean isStrFound = true;

    for (int i = 0; i < sourceChar.length; i ++) {
      int temp = i;
      isStrFound = true;
      for (int j = 0; j < targetChar.length; j++) {
        if (sourceChar[temp] == targetChar[j] && temp < sourceChar.length) {
          temp ++;
          continue;
        }else {
          isStrFound = false;
          break;
        }
      }

      if (isStrFound) {
        return i;
      }
    }

    return -1;
  }


  public static void main(String[] args) {
    int res = strStr("resource", "our");
//    System.out.println(res);

//    System.out.println(Arrays.toString(new Coding().subsets(new int[] {1,2,3}).toArray()));

//    System.out.println(Arrays.toString(new Coding().subsets2(new int[] {2,1,2}).toArray()));

    System.out.println(Arrays.toString(new Coding().permutation2(new int[] {1,2,3}).toArray()));
  }
}
