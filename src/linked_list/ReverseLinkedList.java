package linked_list;

public class ReverseLinkedList {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public ListNode reverse(ListNode head){
        if (head.next == null){
            return  null;
        }
        ListNode prev = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    public ListNode reverse2(ListNode head, int m, int n){
        return null;
    }
}
