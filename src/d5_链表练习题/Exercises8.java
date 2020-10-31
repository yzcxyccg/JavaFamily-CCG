package d5_链表练习题;

public class Exercises8 {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }
        linkList.add(linkList.head);
        System.out.println(linkList.hasCycle(linkList.head));
    }
}
