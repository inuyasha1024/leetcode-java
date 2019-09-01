package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    //queue implement bfs
    public List<List<Integer>> bfsTravel(TreeNode root){
        if(root == null){
            return  null;
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i =0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            res.add(list);

        }

        return res;
    }

    public boolean validBST(TreeNode root){
//        if (root == null){
////            return true;
////        }
////        boolean left = validBST(root.left);
////        boolean right = validBST(root.right);
////
////        boolean l = root.left == null? true : root.left.val < root.val;
////        boolean r = root.right == null? true : root.right.val < root.val;
////
////        if (l && r && left && right){
////            return true;
////        }else {
////            return false;
////        }
        return false;

    }

    //二叉树的前序遍历
    public List<Integer> preorderTravel(TreeNode root){

        if (root == null){
            return null;
        }
        List<Integer> res = new ArrayList<>();

        List<Integer> left = preorderTravel(root.left);
        List<Integer> right = preorderTravel(root.right);

        res.add(root.val);
        if (left != null){

            res.addAll(left);
        }
        if (right != null){

            res.addAll(right);
        }

        return res;
    }
}
