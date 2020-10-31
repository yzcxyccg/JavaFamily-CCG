package d14_剑指offer.b3_链表;

/**
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Test56 {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null)return pHead;
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!= null){
            if(cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val)
                    cur = cur.next;
                cur = cur.next;
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }
    public void traverse(ListNode pHead){
        while (pHead != null) {
            System.out.println(pHead.val);
            pHead = pHead.next;
        }
    }
    public static void main(String[] args) {
        Test56 test56 = new Test56();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;n2.next = n3;n3.next = n4;
        n4.next = n5;n5.next = n6;n6.next = n7;
        n1 =  test56.deleteDuplication(n1);
        test56.traverse(n1);
    }
}
