package d5_链表练习题;

public class Exercises9 {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        Node second = null;//将第二个节点记录下来
        for (int i = 0; i < 5; i++) {
            linkList.add(i);
            if (i == 1) {
                second = linkList.current;
            }
        }

        // linkList.add(second);
        linkList.add(linkList.head);
        Node node = linkList.hasCycle1(linkList.head);
        int cycleLength = linkList.getCycleLength(node);
        System.out.println("cycleLength;" + cycleLength);
    }
}
