package d5_链表练习题;

public class Exercises6 {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }
        linkList.print(linkList.head);
        System.out.println("*****************");
        Node reverseList = linkList.reverseList(linkList.head);
        linkList.print(reverseList);
    }
}
