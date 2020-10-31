package d9_栈和队列练习题;

import java.util.Stack;

/**
 * 3.两个栈实现一个队列
 */
public class Exercises3 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 入队列
     *
     * @param data
     */
    public void push(int data) {
        stack1.push(data);
    }

    /**
     * 出队列
     *
     * @return
     */
    public int pop() {
        //stack1中的数据放到stack2中之前，要保证stack2中的数据是空的，不然出队列顺序会乱
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());//把stack1出栈的数据，放到stack2中
            }
        }
        //stack2为空有两个可能，一是两个栈都为空，二是stack2出完了
        if (stack2.isEmpty()) {
            System.out.println("队列为空");
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        Exercises3 exercises3 = new Exercises3();
        exercises3.push(1);
        exercises3.push(2);
        exercises3.push(3);
        exercises3.push(4);

        System.out.println(exercises3.pop());
        exercises3.push(5);

        System.out.println(exercises3.pop());
        System.out.println(exercises3.pop());
        System.out.println(exercises3.pop());
        System.out.println(exercises3.pop());
//        System.out.println(exercises3.pop());
    }
}
