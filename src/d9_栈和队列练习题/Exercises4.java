package d9_栈和队列练习题;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 4.两个队列实现一个栈
 */
public class Exercises4 {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    /**
     * 入栈操作
     *
     * @param data
     */
    public void push(int data) {
        queue1.add(data);
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public int pop() {
        int data = 0;
        if (queue1.size() == 0) {
            throw new RuntimeException("栈为空");
        }
        while (queue1.size() != 0) {
            if (queue1.size() == 1) {
                data = queue1.poll();
                while (queue2.size() != 0) {//把queue2中的数据都放到queue1中
                    queue1.add(queue2.poll());
                }
                return data;
            }
            queue2.add(queue1.poll());
        }
        throw new RuntimeException("栈为空");
    }

    public static void main(String[] args) {
        Exercises4 exercises4 = new Exercises4();
        exercises4.push(1);
        exercises4.push(2);
        exercises4.push(3);
        exercises4.push(4);

        System.out.println(exercises4.pop());
        System.out.println(exercises4.pop());

        exercises4.push(5);

        System.out.println(exercises4.pop());
        System.out.println(exercises4.pop());
        System.out.println(exercises4.pop());
    }
}
