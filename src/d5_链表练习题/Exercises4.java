package d5_链表练习题;

public class Exercises4 {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }
        System.out.println(linkList.fingMidNode(linkList.head).data);
        System.out.println(linkList.fingMidNode(linkList.head));
    }
}
