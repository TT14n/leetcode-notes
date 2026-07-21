/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
package linkedlist;

public class LC148 {
    public static void main(String[] args) {
        ListNode p4 = new ListNode(3);
        ListNode p3 = new ListNode(1, p4);
        ListNode p2 = new ListNode(2, p3);
        ListNode p1 = new ListNode(4, p2);
        ListNode head = sortList(p1);
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        public ListNode(int val) {
            this.val = val;
        }
    }

    // 归并算法
    public static ListNode sortList(ListNode head) {
        if (head == null){
            return null;
        }

        // 归并排序 head
        return mergeSort(head);
    }

    // 快慢指针找中间节点
    static ListNode findMid(ListNode head){
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast != null && fast.next != null){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 归并排序实现
    static ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        // 找到中间节点
        ListNode mid = findMid(head);

        // 链表相对于数组，难点在于链表没办法通过 idx 定位头尾节点
        // 通过拆分让尾节点为 null，头结点总是返回
        // 先分成子任务进行排序，通过让 mid.next 为 null，拆分两部分
        ListNode next = mid.next;
        mid.next = null;
        ListNode lhead = mergeSort(head);
        ListNode rhead = mergeSort(next);
        // 排序
        return mergeList(lhead, rhead);
    }

    static ListNode mergeList(ListNode lhead, ListNode rhead){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (lhead != null && rhead != null){
            if(lhead.val < rhead.val){
                cur.next = lhead;
                lhead = lhead.next;
            }else{
                cur.next = rhead;
                rhead = rhead.next;
            }
            cur = cur.next;
        }
        cur.next = lhead != null ? lhead : rhead;
        return dummy.next;
    }
}