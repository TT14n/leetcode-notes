package linkedlist;
public class LC142 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head, slow = head;
        // 假设起点到环口需要 a 步，环的一圈为 c 步
        // 假设快指针走了 2b 步，慢指针走了 b 步
        // 则 2b - b = kc 圈，b = kc
        // 再走 a 步到达起点 ==> 再创建一个指针一起走
        while (true) {
            if(fast.next==null || fast.next.next==null){
                return null;
            }
            fast = fast.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        ListNode ptr = head;
        while(ptr != slow){
            slow = slow.next;
            ptr = ptr.next;
        }
        return slow;
    }

}
