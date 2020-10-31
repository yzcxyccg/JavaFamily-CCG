package d4_循环链表_双向循环链表;

public class Node {
    Object element;//数据域
    Node next;//后继指针域
    Node prior;//前驱指针域

    public Node(Node next) {
        this.next = next;
    }

    public Node(Object element, Node next) {
        this.element = element;
        this.next = next;
    }

    public Node(Object element, Node next, Node prior) {
        this.element = element;
        this.next = next;
        this.prior = prior;
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

    public Node getPrior() {
        return prior;
    }

    public void setPrior(Node prior) {
        this.prior = prior;
    }
}
