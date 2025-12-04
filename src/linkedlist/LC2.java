package linkedlist;
public class LC2 {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode now = head;
        ListNode pre = null;
        
        int up = 0;
        while(l1 != null || l2 != null){
            // 加法
            if(l1 != null){
                now.val += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                now.val += l2.val;
                l2 = l2.next;
            }

            now.val += up;
            up = now.val / 10;
            now.val = now.val % 10;

            // 调整链表结构
            if(pre != null){
                pre.next = now;
            }
            pre = now;
            now.next = new ListNode();
            now = now.next;
            
        }

        // 判断最后一个 up;
        if(up > 0){
            now.val = up;
        }else{
            pre.next = null;
        }

        return head;
    
    }
}
