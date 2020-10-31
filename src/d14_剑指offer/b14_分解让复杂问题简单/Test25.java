package d14_剑指offer.b14_分解让复杂问题简单;

/**
 * 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Test25 {
    public static RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }
        RandomListNode currentNode = pHead;
        //*1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while (currentNode != null) {
            RandomListNode newNode = new RandomListNode(currentNode.label);
            RandomListNode pNode = currentNode.next;
            currentNode.next = newNode;
            newNode.next = pNode;
            currentNode = pNode;
        }
        //*2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        currentNode = pHead;
        while (currentNode != null) {
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }
        currentNode = pHead;
        RandomListNode cloneNode = pHead.next;
        //*3、拆分链表，将链表拆分为原链表和复制后的链表
        while (currentNode != null) {
            RandomListNode pNode = currentNode.next;
            currentNode.next = pNode.next;
            currentNode = currentNode.next;
            pNode.next = currentNode == null ? null : currentNode.next;
        }
        return cloneNode;
    }

    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n2.random = n4;
        n3.random = n5;
        System.out.println(Clone(n1).label);
    }
}
