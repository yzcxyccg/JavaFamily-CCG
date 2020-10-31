package d5_链表练习题;

public class Exercises1 {
    public static void main(String[] args) {
        Exercises1 exercises1 = new Exercises1();
        LinkList linkList = new LinkList();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }
        linkList.print(linkList.head);
    }
}
