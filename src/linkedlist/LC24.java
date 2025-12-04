package linkedlist;

public class LC24 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode now = dummy;
        while (now.next.next != null) {
            ListNode next = now.next; // 这里可以画个图比较好理解
            System.out.println(now.next + " " + next.next);
            now.next = next.next;
            System.out.println(next.next + " " + now.next.next);
            next.next = now.next.next;
            System.out.println(next.next.next + " " + next);
            now.next.next = next;

            now = now.next;
        }
        return head;
    }
}
