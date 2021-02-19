package jiuzhang.class3;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Coding {


  public int[] partitionArray(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;

    while (start < end) {
      if(nums[start] < target) {
        start ++;
      }
      if (nums[end] > target) {
        end --;
      }
      if (nums[start] > target && nums[end] < target) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
      }
    }

    return nums;
  }

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList();

    if(root == null) {
      return res;
    }

    perorderTraversalHelper(res, root);
    return res;
  }

  private void perorderTraversalHelper(List<Integer> res, TreeNode root) {
    if(root != null) {
      res.add(root.val);
    }else{
      return;
    }

    perorderTraversalHelper(res, root.left);
    perorderTraversalHelper(res,root.right);

  }

  public List<Integer> preorderTraversal2(TreeNode root) {
    List<Integer> res = new ArrayList();
    Stack<TreeNode> stack = new Stack();

    stack.push(root);

    while(!stack.isEmpty()) {
      TreeNode node = stack.pop();
      if(node != null) {
        res.add(node.val);
        stack.push(node.right);
        stack.push(node.left);
      }
    }

    return res;
  }
}
