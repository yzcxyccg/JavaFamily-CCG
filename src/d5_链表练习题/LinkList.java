package d5_链表练习题;

import java.util.Stack;

public class LinkList {
    public Node head;//头节点
    public Node current;//当前节点

    //1.单链表的创建与遍历

    /**
     * 向链表中添加数据
     *
     * @param data
     */
    public void add(int data) {
        //判断链表是否为空
        if (head == null) {//如果头节点为空说明这个链表没有创建，把新节点赋给头节点
            head = new Node(data);
            current = head;
        } else {
            //创建新的节点，放在当前节点后面
            current.next = new Node(data);
            //把链表当前的索引向后移动一位
            current = current.next;
        }
    }

    /**
     * 向链表中添加节点
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (head == null) {
            head = node;
            current = head;
        } else {
            current.next = node;
            current = current.next;
        }
    }

    /**
     * 遍历列表
     *
     * @param node
     */
    public void print(Node node) {
        if (node == null) {
            return;
        }
        current = node;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    //求单链表中节点的个数

    /**
     * 求单链表的长度
     *
     * @param head
     * @return
     */
    public int getLength(Node head) {
        if (head == null) {
            return 0;
        }
        int length = 0;
        current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    //3.查找单链表中倒数第k个节点（d14_剑指offer,题15）

    /**
     * 查找单链表中倒数第k个节点
     *
     * @param index
     * @return
     */
    public int findLastNode(int index) {
        //第一次遍历,获取链表的长度size
        int size = getLength(head);
        //第二次遍历，输出倒数第index个节点的数据
        current = head;
        for (int i = 0; i < size - index; i++) {
            current = current.next;//跳出循环时current就为第index个节点
        }
        return current.data;
    }

    /**
     * 查找单链表中倒数第k个节点2
     *
     * @param index
     * @return
     */
    public int findLastNode2(int index) {
        if (index == 0 || head == null) {
            return 0;
        }
        Node first = head;
        Node second = head;
        //让second节点往后移index个节点
        for (int i = 0; i < index; i++) {
            second = second.next;
            if (second == null) {//说明index已经大于链表长度
                throw new RuntimeException("参数错误");
            }
        }
        //让first和second节点同时往后走，直到second节点为空
        while (second != null) {
            first = first.next;
            second = second.next;
        }
        //跳出循环时first就为倒数第index个节点
        return first.data;
    }

    //4.查找单链表的中间节点

    /**
     * 查找链表的中间节点 使用双指针 不需要遍历
     *
     * @param head
     * @return
     */
    public Node fingMidNode(Node head) {
        if (head == null) {
            return null;
        }

        Node first = head;
        Node second = head;
        //每次移动时second移两位 first移一位
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

        return first;
    }

    //5.合并两个有序的单链表，合并之后的链表依然有序（d14_剑指offer,题17）

    /**
     * 合并两个有序的单链表，合并之后的链表依然有序
     *
     * @param head1
     * @param head2
     * @return
     */
    public Node mergeLinkList(Node head1, Node head2) {
        //两个单链表同时为空
        if (head1 == null && head2 == null) {
            return null;
        }
        //其中一个单链表为空
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        //一开始，让current节点指向head1和head2中较小的数据，得到head节点
        if (head1.data < head2.data) {
            head = current = head1;
            head1 = head1.next;
        } else {
            head = current = head2;
            head2 = head2.next;
        }

        while (head1 != null & head2 != null) {
            if (head1.data < head2.data) {//新链表中current指针的下一个节点对应较小的数据
                current.next = head1;
                head1 = head1.next;
                current = current.next;//current指针向后移
            } else {
                current.next = head2;
                head2 = head2.next;
                current = current.next;
            }
        }
        //合并剩余元素
        if (head1 != null) {//说明链表2已经合并完成，但是链表1还没有遍历完
            current.next = head1;
        }
        if (head2 != null) {
            current.next = head2;
        }
        return head;
    }

    //6.单链表的反转（d14_剑指offer,题16）

    /**
     * 单链表的反转
     *
     * @param head
     * @return
     */
    public Node reverseList(Node head) {
        //如果链表为空或者只有一个结点，不需要反转
        if (head == null || head.next == null) {
            return head;
        }
        Node current = head;//先让current结点指向原来链表的头节点
        Node next = null;//定义当前节点的下一个节点
        Node reverseHead = null;//反转之后新链表的头节点

        while (current != null) {
            next = current.next;//暂时保存当前节点的下一个节点，因为指针向后移动时要使用
            current.next = reverseHead;
            reverseHead = current;
            current = next;//让current节点后移
        }

        return reverseHead;
    }

    //7.从尾到头打印单链表（d14_剑指offer,题5）

    /**
     * 从尾到头打印单链表
     *
     * @param head
     */
    public void reversePrint(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = head;
        //将链表的所有节点压栈
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        //将栈中的节点打印
        while (stack.size() > 0) {
            System.out.println(stack.pop().data);
        }
    }

    /**
     * 从尾到头打印单链表 通过递归方式实现
     *
     * @param head
     */
    public void reversePrint1(Node head) {
        if (head == null) {
            return;
        }
        reversePrint1(head.next);
        System.out.println(head.data);
    }

    //8.判断单链表是否有环

    /**
     * 判断单链表是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node first = head;
        Node second = head;
        while (second != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) {
                return true;
            }
        }
        return false;
    }

    //9.取出有环链表中，环的长度

    /**
     * 判断单链表是否有环
     *
     * @param head
     * @return
     */
    public Node hasCycle1(Node head) {
        if (head == null) {
            return null;
        }
        Node first = head;
        Node second = head;
        while (second != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) {
                return first;//把相遇的节点返回
            }
        }
        return null;
    }

    /**
     * 获取环的长度
     *
     * @param node
     * @return
     */
    public int getCycleLength(Node node) {
        if (node == null) {
            return 0;
        }
        Node current = node;
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
            //当current走回原来的节点时
            if (current == node) {
                return length;
            }
        }
        return length;
    }

    //10.单链表中，取出环的起始点（d14_剑指offer,题56）

    /**
     * 单链表中，取出环的起始点
     *
     * @param head
     * @param cycleLength
     * @return
     */
    public Node getCycleStart(Node head, int cycleLength) {
        if (head == null) {
            return null;
        }
        Node first = head;
        Node second = head;
        //先让second指针走length步
        for (int i = 0; i < cycleLength; i++) {
            second = second.next;
        }
        //first指针和second指针同时走，相等时，此位置便是环的起始位置
        while (first != null && second != null) {
            first = first.next;
            second = second.next;
            if (first == second) {
                return first;
            }
        }
        return null;
    }

    //11.判断两个单链表相交的第一个交点（d14_剑指offer,题37）

    /**
     * 判断两个单链表相交的第一个交点
     *
     * @param head1
     * @param head2
     * @return
     */
    public Node getFirstCommonNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int length1 = getLength(head1);
        int length2 = getLength(head2);
        int lengthDif = 0;//两个链表长度的差值
        Node longHead;
        Node shortHead;
        if (length1 > length2) {
            longHead = head1;
            shortHead = head2;
            lengthDif = length1 - length2;
        } else {
            longHead = head2;
            shortHead = head1;
            lengthDif = length2 - length1;
        }

        //将较长的链表向前走lengthDifbu
        for (int i = 0; i < lengthDif; i++) {
            longHead = longHead.next;
        }
        //将两个链表同时向前移动
        while (longHead != null && shortHead != null) {
            if (longHead == shortHead) {//第一个相等的节点就是相交的第一个结点
                return longHead;
            }
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return null;
    }
}
