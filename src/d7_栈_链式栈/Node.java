package d7_栈_链式栈;

public class Node {
    Object element;//数据域
    Node next;//指针域

    public Node() {
    }

    public Node(Node next) {
        this.next = next;
    }

    public Node(Object element, Node next) {
        this.element = element;
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
