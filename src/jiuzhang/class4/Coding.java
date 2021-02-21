package jiuzhang.class4;

import java.util.List;

public class Coding {

  public int minimumTotal(List<List<Integer>> triangle) {
    if(triangle.size() == 0) {
      return 0;
    }

    if(triangle.size() == 1) {
      return triangle.get(0).get(0);
    }


    int[][] hash = new int[triangle.size()][triangle.size()];

    List<Integer> list = triangle.get(triangle.size() - 1);
    int[] lastRow = hash[hash.length - 1];
    for(int i = 0; i < lastRow.length; i++) {
      lastRow[i] = list.get(i);
    }

    for(int i = triangle.size() - 2; i >= 0; i--) {
      for(int j = 0; j < triangle.get(i).size(); j++) {
        hash[i][j] = triangle.get(i).get(j) + Math.min(hash[i + 1][j], hash[i + 1][j + 1]);
      }
    }

    return hash[0][0];
  }

  public int minPathSum(int[][] grid) {
    int w = grid.length;
    int l = grid[0].length;
    int[][] f = new int[w][l];

    for(int i = 0; i < w; i++) {
      for(int j = 0; j < l; j++) {
        if(i == 0 && j == 0) {
          f[0][0] = grid[0][0];
        }else if(i == 0) {
          f[i][j] = f[i][j-1] + grid[i][j];
        }else if(j == 0) {
          f[i][j] = f[i-1][j] + grid[i][j];
        }else{
          f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + grid[i][j];
        }
      }
    }

    return f[w-1][l-1];
  }


  public boolean canJump(int[] nums) {
    boolean[] f = new boolean[nums.length];

    if(nums.length == 1) {
      return true;
    }
    if(nums[0] == 0) {
      return false;
    }

    f[0] = true;

    for(int i = 1; i < nums.length; i++) {
      f[i] = false;
      for(int j = 0; j < i; j++) {
        if(nums[j] >= i-j) {
          f[i] = true;
        }
      }
      for(int k = 0; k < i; k++){
        if(!f[k]){
          f[i] = false;
        }
      }
    }

    return f[nums.length - 1];
  }

  public int jump(int[] nums) {
    int[] f = new int[nums.length];

    f[0] = 0;

    for(int i = 1; i < nums.length; i++) {
      int min = Integer.MAX_VALUE;
      for(int j = 0; j < i; j++) {
        if(nums[j] >= i - j) {
          min = Math.min(min, f[j] + 1);
        }
      }
      f[i] = min;
    }

    return f[nums.length - 1];
  }
}
