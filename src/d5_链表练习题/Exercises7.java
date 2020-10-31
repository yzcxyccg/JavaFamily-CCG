package d5_链表练习题;

public class Exercises7 {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }

        // linkList.reversePrint(linkList.head);
        linkList.reversePrint1(linkList.head);
    }
}
