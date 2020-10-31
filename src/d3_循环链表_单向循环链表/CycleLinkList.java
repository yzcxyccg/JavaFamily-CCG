package d3_循环链表_单向循环链表;

public class CycleLinkList implements List {
    Node head;//头指针
    Node current;//当前节点对象
    int size;//节点个数


    /**
     * 初始化一个空链表
     */
    public CycleLinkList() {
        //初始化头节点，让头指针指向头节点，并且让当前节点对象等于头节点
        this.head = current = new Node(null);
        this.size = 0;//单向链表，初始长度为0
        this.head.next = this.head;
    }

    public CycleLinkList(Node head, Node current, int size) {
        this.head = head;
        this.current = current;
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 定位函数，实现当前操作对象的前一个节点，也就是让当前节点对象定位到要操作节点的前一个节点
     *
     * @param index
     */
    public void index(int index) {
        if (index < -1 || index > size - 1) {
            throw new RuntimeException("参数错误");
        }
        //在头节点之后操作
        if (index == -1) {
            return;
        }
        current = head.next;
        int j = 0;
        while (current != head && j < index) {
            current = current.next;
            j++;
        }
    }

    @Override
    public void insert(int index, Object object) {
        if (index < 0 || index > size) {
            throw new RuntimeException("参数错误");
        }
        //使用定位函数，来对要操作的节点进行定位
        index(index - 1);
        current.setNext(new Node(object, current.next));
        size++;
    }

    @Override
    public void delete(int index) {
        //判断链表是否为空
        if (isEmpty()) {
            throw new RuntimeException("链表为空，不能删除");
        }
        if (index < 0 || index > size) {
            throw new RuntimeException("参数错误");
        }
        index(index - 1);//使用定位函数，来对要操作的节点进行定位
        current.setNext(current.next.next);
        size--;
    }

    @Override
    public Object get(int index) {
        if (index < 1 || index > size) {
            throw new RuntimeException("参数错误");
        }
        index(index);
        return current.getElement();
    }

    public static void main(String[] args) {

    }
}
