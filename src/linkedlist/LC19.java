package linkedlist;
public class LC19 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (n > 0) {
            n--;
            fast = fast.next;
            // System.out.println(fast.val);
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            // System.out.println(fast.val + " " + slow.val);
        }
        slow.next = slow.next.next;
        return head;
    }
}
