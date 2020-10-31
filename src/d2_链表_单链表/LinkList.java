package d2_链表_单链表;

/**
 * 单向链表
 */
public class LinkList implements List {

    Node head;//头指针
    Node current;//当前节点对象
    int size;//节点的个数

    /**
     * 初始化一个空链表
     */
    public LinkList() {
        //初始化头节点，让头指针指向头节点，并且让当前节点对象等于头节点
        this.head = current = new Node(null);
        this.size = 0;//单向链表，初始长度为0
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
        //在头结点之后操作
        if (index == -1) {
            return;
        }
        current = head.next;
        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }
    }

    @Override
    public void insert(int index, Object object) {
        if (index < 0 || index > size) {
            throw new RuntimeException("参数操作");
        }
        index(index - 1);//定位到要操作节点的前一个节点对象
        current.setNext(new Node(object, current.next));
        size++;
    }

    @Override
    public void delete(int index) {
        if (isEmpty()) {
            throw new RuntimeException("链表为空，不能删除");
        }
        if (index < 0 || index > size) {
            throw new RuntimeException("参数错误");
        }
        index(index - 1);//定位到要操作节点的前一个节点对象
        current.setNext(current.next.next);
        size--;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("参数错误");
        }
        index(index);
        return current.getElement();
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        for (int i = 0; i < 10; i++) {
            int temp = (int) ((Math.random() * 10) % 10);
            linkList.insert(i, temp);
            System.out.print(temp + " ");
        }
        System.out.println();
        System.out.println("删除第五个元素后：");
        linkList.delete(4);
        for (int i = 0; i < linkList.size; i++) {
            System.out.print(linkList.get(i) + " ");
        }
    }
}
