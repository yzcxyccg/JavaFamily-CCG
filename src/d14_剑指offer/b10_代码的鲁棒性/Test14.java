package d14_剑指offer.b10_代码的鲁棒性;


/**
 *链表中倒数第k个节点
 *输入一个链表，输出该链表中倒数第k个结点。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Test14 {
    public static ListNode FindKthToTail(ListNode head,int k) {
        if(head == null) return null;
        ListNode one = head;
        ListNode two = head;

        for (int i = 0; i < k - 1; i++) {
            one = one.next;
            if(one.next == null) return null;
        }
        while (one.next != null) {
            one = one.next;
            two = two.next;
        }
        return two;
    }


    public static void main(String[] args) {

    }
}
