package question938;

public class Solution {

    static int res = 0;
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val = val;
        }
    }
    public int rangeSumBST(TreeNode root, int L, int R) {

        rangeSumBSTHelper(root,L,R);
        return res;
    }

    void rangeSumBSTHelper( TreeNode treeNode, int L, int R){
        if (treeNode == null){
            return;
        }

        if (treeNode.val >= L && treeNode.val <= R){
            res += treeNode.val;
        }

        rangeSumBSTHelper(treeNode.left,L,R);
        rangeSumBSTHelper(treeNode.right,L,R);
    }
}
