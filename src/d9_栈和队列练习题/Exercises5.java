package d9_栈和队列练习题;

import java.util.Stack;

/**
 * 5.设计最小函数min()的栈，要求min，push，pop的时间复杂度都是O(1)
 */
public class Exercises5 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /**
     * 入栈操作
     *
     * @param data
     */
    public void push(int data) {
        stack.push(data);
        //在辅助栈中进行判断
        if (minStack.size() == 0 || data < minStack.peek()) {
            minStack.push(data);
        } else {
            minStack.push(minStack.peek());//peek方法返回栈顶元素
        }
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public int pop() {
        if (stack.size() == 0) {
            throw new RuntimeException("栈为空");
        }
        int data = stack.pop();
        minStack.pop();//将辅助栈中的元素弹出
        return data;
    }

    public int min() {
        if (minStack.size() == 0) {
            throw new RuntimeException("栈为空");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        Exercises5 exercises5 = new Exercises5();
        exercises5.push(3);
        exercises5.push(5);
        exercises5.push(8);
        exercises5.push(2);
        exercises5.push(1);
        System.out.println(exercises5.pop());
        System.out.println(exercises5.min());
    }
}
