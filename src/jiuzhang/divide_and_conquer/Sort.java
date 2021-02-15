package jiuzhang.divide_and_conquer;

public class Sort {

    class Node {
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }

    class ResultType{
        int singlePath;
        int maxPath;
        ResultType(int maxPath, int singlePath){
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    //find max sum connection
    public ResultType maxSumConnection(Node root){
        if (root == null){
            return new ResultType(Integer.MIN_VALUE,0);
        }

        //Divide
        ResultType left = maxSumConnection(root.left);
        ResultType right = maxSumConnection(root.right);

        //Conquer
        int singlePath = Math.max(left.singlePath,right.singlePath) + root.val;
        singlePath = Math.max(singlePath,0) ;

        int maxPath = Math.max(left.maxPath,right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath+right.singlePath+root.val);

        return new ResultType(singlePath,maxPath);

    }

    //find lca
    public Node findLongestCommonAncestor(Node root, Node node1, Node node2){
        if (root == null || root == node1 || root == node2){
            return root;
        }

        Node left = findLongestCommonAncestor(root.left,node1,node2);
        Node right = findLongestCommonAncestor(root.right,node1,node2);

        if (left != null && right != null){
            return root;
        }
        if (left != null && right == null){
            return left;
        }
        if (right != null && left == null){
            return right;
        }

        return null;
    }


//    public int[] divideAndConquerSort(int[] nums){
//        if (nums.length < 2){
//            return nums;
//        }
//
//        int[] left = divideAndConquerSort()
//    }
}
