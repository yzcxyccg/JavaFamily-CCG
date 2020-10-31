package d14_剑指offer;


class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
public class Test {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }
        //判断节点的数量是否能够凑成一组
        if(temp == null)
            return head;
        ListNode t2 = temp.next;
        temp.next = null;
        //把当前的组进行逆序
        ListNode newHead = reverseList(head);
        //把之后的节点进行分组逆序
        ListNode newTemp = reverseKGroup(t2, k);
        // 把两部分连接起来
        head.next = newTemp;
        return newHead;
    }
    //逆序单链表
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
    public static ListNode solve(ListNode head, int k) {
        // 调用逆序函数
        head = reverseList(head);
        // 调用每 k 个为一组的逆序函数（从头部开始组起）
        head = reverseKGroup(head, k);
        // 在逆序一次
        head = reverseList(head);
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
        ListNode n8 = new ListNode(8);
        n1.next = n2;n2.next=n3;n3.next=n4;
        n4.next = n5;n5.next=n6;n6.next=n7;
        n7.next=n8;
        System.out.println(solve(n1,3).next.next.val);

    }
}
