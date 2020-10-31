package d14_剑指offer.b5_栈和队列;

import java.util.Stack;

/**
 * 两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Test5 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        //stack1中的数据放到stack2中之前，要保证stack2中的数据是空的，不然出队列顺序会乱
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        //stack2为空有两个可能，一是两个栈都为空，二是stack2出完了
        if (stack2.isEmpty()) {
            System.out.println("队列为空");
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Test5 test5 = new Test5();
        test5.push(1);
        test5.push(2);
        test5.push(3);
        test5.push(4);
        System.out.println(test5.pop());
        System.out.println(test5.pop());
        test5.push(5);
        System.out.println(test5.pop());
        System.out.println(test5.pop());
    }
}
