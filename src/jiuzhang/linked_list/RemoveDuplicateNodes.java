package jiuzhang.linked_list;

public class RemoveDuplicateNodes {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public ListNode removeDuplicateNodes(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while (head.next != null && head.next.next != null){
            if (head.next.val == head.next.next.val){
                int val = head.next.val;
                while ( head.next != null && head.next.val == val ){
                    head.next = head.next.next;
                }
            }else {
                head = head.next;
            }
        }

        return dummy.next;
    }

    public ListNode removeDuplicateNodes2( ListNode head){
        //
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        slow.next = fast;

        while (fast != null){
            while (fast.next != null && fast.val == fast.next.val){
                fast = fast.next;
            }

            if (slow.next != fast){
                slow.next = fast.next;
            }else {
                slow = slow.next;
                fast = fast.next;
            }
        }

        return dummy.next;
    }
}
