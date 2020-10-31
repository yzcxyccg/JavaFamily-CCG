package d15_leetcode;

/**
 * reorder-list
 * 将给定的单链表L： L 0→L 1→…→L n-1→L n,重新排序为： L 0→L n →L 1→L n-1→L 2→L n-2→…
 * 要求使用原地算法，并且不改变节点的值
 * 例如：对于给定的单链表{1,2,3,4}，将其重新排序为{1,4,2,3}.
 */
public class Test8 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)return;
        ListNode slow = head;
        ListNode quick = head.next;
        while(quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode head1 = slow.next;
        slow.next = null;
        head1 = reverse(head1);
        ListNode current = head;
        while(head1 != null){
            ListNode next = head1.next;
            head1.next = current.next;
            current.next = head1;
            current = head1.next;
            head1 = next;
        }
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)return head;
        ListNode current = head;
        head = null;
        while(current != null){
            ListNode next = current.next;
            current.next = head;
            head = current;
            current = next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;n2.next = n3;n3.next = n4;
        n4.next = n5;n5.next = n6;
        //n6.next = n7;
        Test8 test8 = new Test8();
        test8.reorderList(n1);
        while(n1!=null){
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }
}
