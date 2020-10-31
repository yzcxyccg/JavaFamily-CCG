package d14_剑指offer.b10_代码的鲁棒性;

/**
 * 反转链表
 * 输入一个链表，反转链表后，输出新链表的表头。
 */

public class Test15 {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
