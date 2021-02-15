package jiuzhang.recursion;

public class BinarySearch {
    public int binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] == target){
                end = mid;
            }else if(nums[mid] < target){
                start = mid;
            }else if (nums[mid] > target){
                end = mid;
            }
        }

        if (nums[start] == target){
            return start;
        }
        if (nums[end] == target){
            return  end;
        }

        return -1;

    }

    public static int binaryInsert(int[] nums, int t){
        int start = 0, end = nums.length-1, mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] >= t){
                end = mid;
            }else {
                start = mid;
            }
        }
        return end;

    }

    public static int findPeak(int[] nums){
        int start = 0, end = nums.length-1, mid;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid -1] && nums[mid] < nums[mid+1]){
                return mid;
            }else if (nums[mid] < nums[mid + 1]){
                start = mid + 1;
            }else if (nums[mid] > nums[mid +1]){
                end = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(binaryInsert(nums,4));
    }
}
