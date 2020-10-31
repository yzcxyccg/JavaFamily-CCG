package d6_栈_顺序栈;

import java.util.Scanner;

public class SequenceStack implements Stack {
    Object[] stack;//对象数组（存储数据）
    final int defaultSize = 10;//默认的最大长度
    int top;//栈顶的位置（数组的下标）
    int maxSize;//最大的长度

    //定义构造函数 来初始化栈
    public SequenceStack() {
        init(defaultSize);
    }

    //带有指定长度的构造函数
    public SequenceStack(int maxSize) {
        init(maxSize);
    }

    public void init(int maxSize) {
        this.maxSize = maxSize;
        top = 0;
        stack = new Object[maxSize];
    }

    @Override
    public void push(Object object) {
        //判断栈是否为空
        if (top == maxSize) {
            throw new RuntimeException("栈已满不能入栈");
        }
        stack[top] = object;
        top++;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        top--;
        return stack[top];
    }

    @Override
    public Object getTop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    public static void main(String[] args) {
        SequenceStack sequenceStack = new SequenceStack(10);

        Scanner in = new Scanner(System.in);
        int temp;
        for (int i = 0; i < 10; i++) {
            System.out.println("请输入第" + (i + 1) + "个数：");
            temp = in.nextInt();
            sequenceStack.push(temp);
        }
        while (!sequenceStack.isEmpty()) {
            System.out.println(sequenceStack.pop());
        }
    }
}
