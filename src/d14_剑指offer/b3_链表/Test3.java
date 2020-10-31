package d14_剑指offer.b3_链表;

import d2_链表_单链表.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test3 {
    /**
     * 从尾到头打印链表
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     */
    public static List<Integer> printListFromTailToHead() {
        Node head = new Node(0, new Node(1, new Node(2, new Node(3, new Node(4, null)))));
        Node current = head;
        Stack<Node> stack = new Stack<>();
        while (current != null) {
            stack.push(current);
            current = current.getNext();
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (stack.size() > 0) {
            list.add((Integer) stack.pop().getElement());
        }
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        printListFromTailToHead();
    }
}
