package d15_leetcode;

/**
 * insertion-sort-list
 * 使用插入排序对链表进行排序。
 */
public class Test5 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode preNode = result;
        ListNode current = head;
        while(current != null){
            ListNode next = current.next;
            preNode = result;
            while(preNode.next != null && preNode.next.val < current.val)
                preNode = preNode.next;
            current.next = preNode.next;
            preNode.next = current;
            current = next;
        }
        return result.next;
    }
}
