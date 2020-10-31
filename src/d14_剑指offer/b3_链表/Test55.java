package d14_剑指offer.b3_链表;

/**
 * 链表中环的入口结点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Test55 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        //1.判断是否有环,若有环返回第一次相交的结点
        ListNode pNode = isHuan(pHead);
        if (pNode == null) return null;
        //2.获取环的长度
        int length = getLength(pNode);
        ListNode current = pHead;
        for (int i = 0; i < length; i++)
            current = current.next;
        while (current != null) {
            if (current == pHead) return current;
            current = current.next;
            pHead = pHead.next;
        }
        return null;
    }

    public ListNode isHuan(ListNode pHead) {
        ListNode quick = pHead;
        ListNode slow = pHead;
        while (quick != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow)
                return slow;
        }
        return null;
    }

    public int getLength(ListNode pNode) {
        int length = 0;
        ListNode current = pNode;
        while (current != null) {
            length++;
            current = current.next;
            if (current == pNode) break;
        }
        return length;
    }
}
