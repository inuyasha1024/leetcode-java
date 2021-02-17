package jiuzhang.class2;

import java.util.Arrays;

public class Coding {

  public double findMedianSortedArray(int[] numsA, int[] numsB) {
    int m = numsA.length + numsB.length;
    return m / 2 == 0 ? (findKthSortedArray(m/2, 0, numsA, 0, numsB) + findKthSortedArray(m/2 + 1, 0, numsA, 0, numsB)) / 2.0 :
            findKthSortedArray(m/2 + 1, 0, numsA, 0, numsB);
  }

  public int findKthSortedArray(int k, int aStart, int[] numsA, int bStart, int[] numsB) {
    if (aStart >= numsA.length) {
      return numsB[bStart + k - 1];
    }
    if (bStart >= numsB.length) {
      return numsA[aStart + k - 1];
    }
    if (k == 1) {
      return Math.min(numsA[aStart],numsB[bStart]);
    }

    int aKey = aStart + k / 2 - 1 < numsA.length ? numsA[aStart + k / 2 - 1] : Integer.MAX_VALUE;
    int bKey = bStart + k / 2 - 1 < numsB.length ? numsB[bStart + k / 2 - 1] : Integer.MAX_VALUE;

    return aKey > bKey ? findKthSortedArray(k - k / 2, aStart, numsA, bStart + k /2, numsB) :
            findKthSortedArray(k - k / 2, aStart + k /2, numsA, bStart, numsB);
  }

  public int[] reverseArray(int[] nums) {
    int start = 0;
    int end = nums.length - 1;

    while (start + 1 < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;

      start ++;
      end --;
    }

    return nums;
  }

  public int searchRotatedSortedArray(int[] nums, int target) {
    int start = 0;
    int end = nums.length;
    int mid;

    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[mid] >= nums[start]) {
        if (target <= nums[mid] && target >= nums[start]) {
          end = mid;
        }else {
          start = mid;
        }
      }else {
        if (target >= nums[mid] && target <= nums[end]) {
          start = mid;
        }else {
          end = mid;
        }
      }
    }

    if (nums[start] == target) {
      return start;
    }
    if (nums[end] == target) {
      return end;
    }
    return  -1;
  }

  public int findPeak(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    int mid;

    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
        return mid;
      }else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
        start = mid;
      }else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]){
        end = mid;
      }
    }
    return -1;
  }

  public int findFirstBadVersion(int n) {
//    int start = 1;
//    int end = n;
//    int mid;
//
//    while (start + 1 < end) {
//      mid = start + (end - start) / 2;
//      if (VersionControl.isBadVersion(mid)) {
//        end = mid;
//      }else {
//        start = mid;
//      }
//    }
//
//    if (VersionControl.isBadVersion(start)) {
//      return start;
//    }
//    if (VersionControl.isBadVersion(end)) {
//      return end;
//    }
    return  -1;
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    int[] column = new int[matrix.length];
    for (int i = 0; i < matrix.length; i++) {
      column[i] = matrix[i][0];
    }

    int[] row = matrix[getRow(column, target)];

    int start = 0;
    int end = row.length - 1;
    int mid;

    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (row[mid] == target) {
        return  true;
      }else  if (row[mid] < target) {
        start = mid;
      }else {
        end = mid;
      }
    }

    if (row[start] == target || row[end] == target) {
      return  true;
    }
    return false;
  }

  public int getRow(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    int mid;

    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (target == nums[mid]) {
        return mid;
      }else if (target < nums[mid]) {
        end = mid;
      }else {
        start = mid;
      }
    }

    if (nums[end] <= target) {
      return end;
    }else if (nums[start] <= target) {
      return start;
    }else {
      return 0;
    }
  }

  public int searchInsert(int[] nums, int target) {
    return -1;
  }

  public int[] searchRange(int[] nums, int target) {

    if (nums.length == 0 || nums == null) {
      return new int[] {-1,-1};
    }

    int first = findFirstPos(nums, target);
    int last = findLastPos(nums, target);

    return new int[] {first, last};
  }

  public int findLastPos(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    int mid;

    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        end = mid;
      }else if (nums[mid] > target) {
        end = mid;
      }else if (nums[mid] < target) {
        start = mid;
      }
    }

    if (nums[start] == target) {
      return start;
    }
    if (nums[end] == target) {
      return  end;
    }

    return -1;
  }

  public int findFirstPos(int[] nums, int target) {

    int start = 0;
    int end = nums.length - 1;
    int mid;

    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        start = mid;
      }else if (nums[mid] > target) {
        end = mid;
      }else if (nums[mid] < target) {
        start = mid;
      }
    }

    if (nums[end] == target) {
      return end;
    }
    if (nums[start] == target) {
      return  start;
    }
    return -1;
  }


  public static void main(String[] args) {
    int[] res = new Coding().searchRange(new int[] {5,7,7,8,9,10}, 8);
    int res1 = new Coding().searchInsert(new int[] {1,3,5,6}, 0);
//    System.out.println(res1);
//    System.out.println(Arrays.toString(res));

    int[][] matrix = new int[][] {
            {1,3,5,7}, {10,11,16,20}, {23,30,34,50}
    };

    boolean res2 = new Coding().searchMatrix(matrix,13);
//    System.out.println(res2);

//    System.out.println(new Coding().findPeak(new int[] {1,2,1,3,4,5,7,6}));

    int[] res3 = new Coding().reverseArray(new int[] {5,4,3,2,1,6});
    System.out.println(Arrays.toString(res3));
  }
}
