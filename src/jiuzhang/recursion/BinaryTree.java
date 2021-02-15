package jiuzhang.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
    }
}

public class BinaryTree {

    public List<Integer> preorderTravelByStack(Node root){
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            res.add(node.val);

            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }

        return res;
    }

    public List<Integer> preorderTravelByRecursion(Node root){
        List<Integer> res = new ArrayList<>();
        //res.add(root.val);
        traverse(root,res);
        return res;
    }


    public void traverse(Node root, List<Integer> res){
        if (root == null){
            return ;
        }
        res.add(root.val);
        traverse(root.left,res);
        traverse(root.right,res);
    }


    public List<Integer> preorderTravelByDivideAndConquer(Node root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        res.add(root.val);
        List<Integer> left = preorderTravelByDivideAndConquer(root.left);
        List<Integer> right = preorderTravelByDivideAndConquer(root.right);

        res.addAll(left);
        res.addAll(right);
        return res;
    }

    public int findMaxDepth(Node root){
        if(root == null){
            return 0;
        }

        int left = findMaxDepth(root.left);
        int right = findMaxDepth(root.right);

        return Math.max(left,right)+1;

    }

    public boolean isBalancedTree(Node root){
//        if (root == null){
//            return true;
//        }
//
//        boolean left = isBalancedTree(root.left);
//        boolean right = isBalancedTree(root.right);
//
//        return left && right? true : false;
        return maxDepthWithBalance(root) != -1;

    }

    public int maxDepthWithBalance(Node root){
        if(root == null){
            return 0;
        }

        int left = maxDepthWithBalance(root.left);
        int right = maxDepthWithBalance(root.right);

        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left,right);
    }
}
