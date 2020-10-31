package d7_栈_链式栈;

import d6_栈_顺序栈.Stack;

import java.util.Scanner;

public class LinkStack implements Stack {
    Node head;//栈顶指针
    int size;//节点个数


    @Override
    public void push(Object object) {
        head = new Node(object, head);
        size++;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        Object element = head.element;
        head = head.next;
        size--;
        return element;
    }

    @Override
    public Object getTop() {
        return head.element;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        LinkStack linkStack = new LinkStack();
        Scanner in = new Scanner(System.in);
        int temp;
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第" + (i + 1) + "个数：");
            temp = in.nextInt();
            linkStack.push(temp);
        }
        //遍历
        while (!linkStack.isEmpty()) {
            System.out.println(linkStack.pop());
        }
    }
}
