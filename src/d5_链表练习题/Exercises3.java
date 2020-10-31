package d5_链表练习题;

public class Exercises3 {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }

        System.out.println("节点为：" + linkList.findLastNode2(9));
    }
}
