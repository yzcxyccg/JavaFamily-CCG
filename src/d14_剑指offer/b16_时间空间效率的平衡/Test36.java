package d14_剑指offer.b16_时间空间效率的平衡;

/**
 * 两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，
 * 保证传入数据是正确的）
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Test36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)return null;
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        int lenDif = 0;
        ListNode longPHead = null;
        ListNode shortPHead = null;
        if(length1 > length2){
            longPHead = pHead1;
            shortPHead = pHead2;
            lenDif = length1 - length2;
        }else{
            longPHead = pHead2;
            shortPHead = pHead1;
            lenDif = length2 - length1;
        }
        for(int i = 0 ; i < lenDif ; i++){
            longPHead = longPHead.next;
        }
        while(longPHead !=null && shortPHead != null){
            if(longPHead == shortPHead)
                return longPHead;
            longPHead = longPHead.next;
            shortPHead = shortPHead.next;
        }
        return null;
    }
    public int getLength(ListNode pHead){
        int length = 0;
        while(pHead != null){
            length++;
            pHead = pHead.next;
        }
        return length;
    }
}
