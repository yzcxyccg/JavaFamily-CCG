package d15_leetcode;

/**
 * linked-list-cycle
 * 判断给定的链表中是否有环
 * 扩展：
 * 你能给出不利用额外空间的解法么?
 */
public class Test10 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)return false;
        ListNode slow = head;
        ListNode quick = head;
        while(quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow)return true;
        }
        return false;
    }
}
