package d5_链表练习题;

public class Exercises10 {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        Node second = null;
        for (int i = 0; i < 8; i++) {
            linkList.add(i);
            if (i == 2) {
                second = linkList.current;
            }
        }
        linkList.add(second);
        Node node = linkList.hasCycle1(linkList.head);//获取相遇的节点
        int cycleLength = linkList.getCycleLength(node);//获取环的长度
        Node cycleStart = linkList.getCycleStart(linkList.head, cycleLength);//获取环的起始点
        System.out.println("cycleStartData:" + cycleStart.data);
    }
}
