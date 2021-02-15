package jiuzhang.travel;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}

public class TravelTree {

    public List<Integer> preorderTravelWithRecursion(TreeNode root){
        List<Integer> res = new ArrayList<>();
        preorderTravelHelper(root,res);
        return res;

    }

    public List<Integer> preorderTravelWithoutRecursion(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null){

                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        return res;
    }

    public void preorderTravelHelper(TreeNode node, List<Integer> res){
        if (node == null){
            return;
        }
        res.add(node.val);
        preorderTravelHelper(node.left, res);
        preorderTravelHelper(node.right, res);
    }

    public List<Integer> inorderTravelWithRecursion(TreeNode root){
        List<Integer> res = new ArrayList<>();
        inorderTravelHelper(root,res);
        return res;
    }

    public void inorderTravelHelper(TreeNode node, List<Integer> res){
        if (node == null){
            return;
        }
        inorderTravelHelper(node.left,res);
        res.add(node.val);
        inorderTravelHelper(node.right,res);
    }

    public List<Integer> postorderTravelWithRecursion(TreeNode root){
        List<Integer> res = new ArrayList<>();
        postorderTravelHelper(root,res);
        return res;
    }
    public void postorderTravelHelper(TreeNode node, List<Integer> res){
        if (node == null){
            return;
        }
        postorderTravelHelper(node.left,res);
        postorderTravelHelper(node.right,res);
        res.add(node.val);
    }
}
