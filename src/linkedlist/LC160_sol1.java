package linkedlist;
import java.util.HashMap;

public class LC160_sol1 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Boolean> map = new HashMap<>();
        ListNode node;
        
        node = headA;
        while(node != null){
            map.put(node, true);
            node = node.next;
        }

        node = headB;
        while(node != null){
            if(map.containsKey(node)){
                return node;
            }
            node = node.next;
        }
        return null;
    }
}
