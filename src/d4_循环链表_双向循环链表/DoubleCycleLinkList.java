package d4_循环链表_双向循环链表;

public class DoubleCycleLinkList implements List {
    Node head;//头指针
    Node current;//当前节点对象
    int size;//节点个数

    //初始化一个空链表
    public DoubleCycleLinkList() {
        //初始化头节点，让头指针指向头节点，并且让当前节点等于头节点
        this.head = current = new Node(null);
        this.size = 0;//默认为0
        this.head.next = head;//指向它自己
        this.head.prior = head;//指向它自己
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 定位函数，实现当前操作的前一个节点
     *
     * @param index
     */
    public void index(int index) {
        if (index < -1 || index > size - 1) {
            throw new RuntimeException("参数异常");
        }
        //在头节点之后操作
        if (index == -1) {
            return;
        }
        current = head.next;
        int i = 0; //循环变量
        while (current != head && i < index) {
            current = current.next;
            i++;
        }
    }

    @Override
    public void insert(int index, Object object) {
        if (index < 0 || index > size) {
            throw new RuntimeException("参数异常");
        }
        //定位函数
        index(index - 1);
        current.setNext(new Node(object, current.next));
        current.next.setPrior(current);
        current.next.next.setPrior(current.next);
        size++;
    }

    @Override
    public void delete(int index) {
        if (isEmpty()) {
            throw new RuntimeException("链表为空，不能删除");
        }
        if (index < 0 || index > size) {
            throw new RuntimeException("参数异常");
        }
        index(index - 1);
        current.setNext(current.next.next);
        current.next.setPrior(current);
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
        DoubleCycleLinkList doubleCycleLinkList = new DoubleCycleLinkList();
        for (int i = 0; i < 10; i++) {
            /*int temp = (int) ((Math.random() * 10) % 10);
            doubleCycleLinkList.insert(i, temp);
            System.out.print(temp + " ");*/
            doubleCycleLinkList.insert(i, i);
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("删除第五个元素后：");
        doubleCycleLinkList.delete(4);
        for (int i = 0; i < doubleCycleLinkList.size; i++) {
            System.out.print(doubleCycleLinkList.get(i) + " ");
        }
    }
}
