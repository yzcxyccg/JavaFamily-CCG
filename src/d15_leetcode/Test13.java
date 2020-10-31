package d15_leetcode;

/**
 * copy-list-with-random-pointer
 * 现在有一个这样的链表：链表的每一个节点都附加了一个随机指针，随机指针可能指向链表中的任意一个节点或者指向空。
 * 请对这个链表进行深拷贝。
 */
class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
}
public class Test13 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)return head;
        //对每一个结点进行复制，将新节点插入到原结点之后
        RandomListNode node = head;
        while(node != null){
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node = node.next.next;
        }
        //根据原结点Random给新节点的Random赋值
        node = head;
        while(node != null){
            if(node.random != null)node.next.random = node.random.next;
            node = node.next.next;
        }
        RandomListNode newHead = head.next;
        node = head;
        //将新节点从链表中拆分出来
        while(node != null){
            RandomListNode newNode = node.next;
            node.next = newNode.next;
            if(node.next != null)newNode.next = node.next.next;
            node = node.next;
        }
        return newHead;
    }
}
