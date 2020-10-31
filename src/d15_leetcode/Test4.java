package d15_leetcode;

/**
 * sort-list
 * 在O(n log n)的时间内使用常数级空间复杂度对链表进行排序。
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Test4 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode quick = head.next;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode right = slow.next;
        ListNode left = head;
        slow.next = null;
        return merge(sortList(left), sortList(right));
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode result = new ListNode(0);
        ListNode p = result;
        while (left != null && right != null) {
            if (left.val > right.val) {
                result.next = right;
                right = right.next;
            } else {
                result.next = left;
                left = left.next;
            }
            result = result.next;
        }
        if (left != null) result.next = left;
        if (right != null) result.next = right;
        return p.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(4);
        n1.next = n2;
        //
        // n2.next = n3;n3.next = n4;
//        n4.next = n5;n5.next = n6;n6.next = n7;
        Test4 test4 = new Test4();
        System.out.println(test4.sortList(n1).val);
    }
}
