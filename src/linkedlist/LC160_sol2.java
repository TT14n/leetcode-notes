package linkedlist;

public class LC160_sol2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 要注意，他们的最后一段 c 是相同的，所以目的是弥补 a 和 b 的链表长度
        // 利用 a+b，则最后一段肯定是c
        ListNode nodeA = headA, nodeB = headB;
        while(nodeA != null || nodeB != null){
            if(nodeA == nodeB){
                return nodeA;
            }
            
            if(nodeA == null){
                nodeA = headB;
            }else{
                nodeA = nodeA.next;
            }
            
            if(nodeB == null){
                nodeB = headA;
            }else{
                nodeB = nodeB.next;
            }
        }
        return null;
    }
}
