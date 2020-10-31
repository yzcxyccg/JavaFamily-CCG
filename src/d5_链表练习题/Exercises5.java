package d5_链表练习题;

public class Exercises5 {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        LinkList linkList1 = new LinkList();
        LinkList linkList2 = new LinkList();
        for (int i = 0; i < 5; i++) {
            linkList1.add(i);
        }
        for (int j = 3; j < 8; j++) {
            linkList2.add(j);
        }

        linkList.head = linkList.mergeLinkList(linkList1.head, linkList2.head);
        linkList.print(linkList.head);


    }
}
