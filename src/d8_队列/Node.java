package d8_队列;

public class Node {
    Object element;//数据域
    Node next;//指针域

    public Node(Node next) {
        this.next = next;
    }

    public Node(Object element, Node next) {
        this.element = element;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                ", next=" + next +
                '}';
    }
}
