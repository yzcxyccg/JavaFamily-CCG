package d15_leetcode;

/**
 * linked-list-cycle-ii
 * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 * 拓展：
 * 你能给出不利用额外空间的解法么？
 */
public class Test9 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)return null;
        ListNode current = isHuan(head);
        if(current == null)return null;
        while(current != head){
            current = current.next;
            head = head.next;
        }
        return current;
    }
    public ListNode isHuan(ListNode head){
        ListNode quick = head;
        ListNode slow = head;
        while(quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow)return slow;
        }
        return null;
    }
}
