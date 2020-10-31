package d14_剑指offer.b13_举例让抽象具体化;


import java.util.Stack;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Test20 {

    private static Stack<Integer> stack = new Stack<Integer>();
    private static Integer minElement = Integer.MAX_VALUE;

    public void push(int node) {
        if(stack.empty()){
            minElement = node;
            stack.push(node);
        }else{
            if(node <= minElement){
                stack.push(minElement);//在push更小的值时需要保留在此值之前的最小值
                minElement = node;
            }
            stack.push(node);
        }
    }

    public void pop() {
        //增加最后一个元素以及栈为空时候的检测
        if(stack.size() == 0)return;
        if( minElement == stack.peek()){
            if(stack.size() >1){
                stack.pop();
                minElement = stack.peek();
            }else{
                minElement = Integer.MAX_VALUE;
            }
        }
        stack.pop();
    }
    public int top() {
        return stack.peek();
    }

    public int min() {
        return minElement;
    }

    public static void main(String[] args) {
        Test20 test20 = new Test20();
        test20.push(3);
        test20.push(2);
        test20.push(1);
        test20.pop();
        test20.pop();
        test20.pop();
        System.out.println(test20.min());
    }
}
