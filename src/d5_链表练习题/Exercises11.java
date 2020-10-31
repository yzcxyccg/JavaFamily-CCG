package d5_链表练习题;

public class Exercises11 {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        LinkList linkList1 = new LinkList();
        LinkList linkList2 = new LinkList();
        Node first = null;
        for (int i = 0; i < 8; i++) {
            linkList1.add(i);
            if (i == 4) {
                first = linkList1.current;
            }
        }
        for (int j = 2; j < 4; j++) {
            linkList2.add(j);
        }
        linkList2.add(first);
        Node firstCommonNode = linkList.getFirstCommonNode(linkList1.head, linkList2.head);
        linkList1.print(linkList1.head);
        System.out.println("***************************");
        linkList2.print(linkList2.head);
        System.out.println("firstCommonNode:" + firstCommonNode.data);
    }
}
