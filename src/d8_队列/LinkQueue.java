package d8_队列;

public class LinkQueue implements Queue {
    Node front;//队头
    Node rear;//队尾
    int count;//计数器

    public LinkQueue() {
        init();
    }

    public void init() {
        front = rear = null;
        count = 0;
    }

    @Override
    public void append(Object object) {
        Node node = new Node(object, null);
        //如果当前节点不为空
        if (rear != null) {//队尾节点指向新节点
            rear.next = node;
        }
        rear = node;//设置队尾节点为新节点
        //说明要插入的节点是队列的第一个节点
        if (front == null) {
            front = node;
        }
        count++;
    }

    @Override
    public Object delete() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能删除");
        }
        Node node = front;
        front = front.next;
        count--;
        return node.element;
    }

    @Override
    public Object getFront() {
        if (!isEmpty()) {
            return front.element;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        LinkQueue linkQueue = new LinkQueue();
        linkQueue.append("a");
        linkQueue.append("b");
        linkQueue.append("c");
        linkQueue.append("d");
        linkQueue.append("e");
        linkQueue.append("f");

        linkQueue.delete();
        linkQueue.delete();

        linkQueue.append("g");

        while (!linkQueue.isEmpty()) {
            System.out.println(linkQueue.delete());
        }
    }
}
