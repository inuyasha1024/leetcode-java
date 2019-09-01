package question2;

class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
    }
}

public class Solution {


//    public Node addTowNums(Node n1, Node n2){
//        Node first = new Node();
//        Node tem = new Node();
//
//        while (n1.next != null && n2.next != null){
//            Node node = new Node();
//            node.val = n1.val + n2.val;
//            tem = node;
//            if (tem.next == null){
//                first = tem;
//            }else {
//                tem.next = node;
//            }
//            n1 = n1.next;
//            n2 = n2.next;
//            if (n1.next == null){
//                node.next = n2;
//            }
//            if (n2.next == null){
//                node.next = n1;
//            }
//        }
//
//        tem = first;
//
//        while (tem.next != null){
//            if (tem.val >= 10){
//                tem.val = tem.val%10;
//                tem.next.val += 1;
//            }
//            tem = tem.next;
//        }
//        return  first;
//    }

    public static Node addTowNums(Node n1, Node n2){
        Node first = new Node(-1);
        Node curr = first;
        int carry = 0;
        while (n1 != null || n2 != null){
            int val1 = n1 == null? 0: n1.val;
            int val2 = n2 == null? 0: n2.val;

            int sum = carry + val1 + val2;
            Node node = new Node(carry % 10);
            curr.next = node;
            carry = sum>10? 1:0;

            curr = curr.next;

            n1 = n1 == null? null:n1.next;
            n2 = n2 == null? null: n2.next;
        }
        if (carry != 0){
            curr.next = new Node(1);
        }
        return first.next;
    }

    public static void main(String[] args) {

    }
}
